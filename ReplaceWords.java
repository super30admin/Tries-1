// Time Complexity : O(n) n is sentence length
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ReplaceWords {
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode node = new TrieNode();
        
        //insert all dictionary words in trie 
        for (String root: roots) {
            TrieNode cur = node;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = node;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null) 
                    break;
                cur = cur.children[letter - 'a'];
            }
            //if clipped word overlaps with current word, break from above and add clipped word to sentence
            ans.append(cur.word != null ? cur.word : word);
        }
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