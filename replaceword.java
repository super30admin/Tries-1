class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        //Create a trie
        TrieNode trie = new TrieNode();
        //put all the words in the trie
        for (String root: roots) {
            //starting with the root of trie
            TrieNode cur = trie;
            //Check all alphabet by alphabet
            for (char letter: root.toCharArray()) {
                //If it is null meaning dint find the char make a new trie node
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                //make cur as the next char or children
                cur = cur.children[letter - 'a'];
            }
            //make cur.word as root
            cur.word = root;
        }
        //finding shortest prefix
        //for creating ans call string builder funtion (beacuse string will be modified)
        StringBuilder ans = new StringBuilder();
        //split the scentence with spaces as delimiter
        for (String word: sentence.split("\\s+")) {
            //If the length of ans greater than 0 or has the word in ans
            if (ans.length() > 0)
                //append space after the word in answer
                ans.append(" ");
            //assign tire to current
            TrieNode cur = trie;
            //Check for every word
            for (char letter: word.toCharArray()) {
                //if word not found break
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                //make cur as its child element or next node
                cur = cur.children[letter - 'a'];
            }
            //If ans is not null then append cur.word else retain word as it is 
            ans.append(cur.word != null ? cur.word : word);
        }
        //return the ans
        return ans.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }
}