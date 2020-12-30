/** Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, 
* replace all the successors in the sentence with the root forming it.
* TC  O(N) where N is the length of the sentence
* SC  O(N) size of trie
class Solution {
    class TrieNode {
        boolean lastChar;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i<word.length(); i++ ) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.lastChar = true;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0)
            return "";
        root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }
        StringBuilder replaced = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String[] splited = sentence.split("\\s+");
        for (int i = 0; i < splited.length; i ++) {
            TrieNode curr = root;
            temp = new StringBuilder();
            if (i > 0) {
                replaced.append(" ");
            }
            for (int j = 0; j <splited[i].length(); j++ ) {
                char c = splited[i].charAt(j);
                if (curr.children[c-'a'] == null || curr.lastChar) {
                    break;
                }
                temp.append(splited[i].charAt(j));
                curr = curr.children[c-'a'];
            }
            if (curr.lastChar) {
                 replaced.append(temp);
            }
           else {
               replaced.append(splited[i]);
           }
        }
        return replaced.toString();
    }
}
