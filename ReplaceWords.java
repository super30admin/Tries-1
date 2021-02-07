// Time Complexity : O(n) where n is the longest word in Trie.
// Space Complexity : O(n) where n is the longest word in Trie.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Insert all the words from dictionary in a Trie
//For each word in the sentence, check if there is a word in the trie which can be replaced 


class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        if(sentence == null || sentence.length() == 0) return "";
        if(dictionary == null || dictionary.size() == 0) return sentence;

        Trie t = new Trie();
        for(String word : dictionary) {
            t.insert(word);
        }

        String[] words = sentence.split("\\s");
        StringBuilder result = new StringBuilder();


        for(String word : words) {
            StringBuilder replacement = new StringBuilder();
            TrieNode cur = root;
            for(char c : word.toCharArray()) {
                if(cur.children[c-'a'] == null || cur.bEnd) break;
                replacement.append(c);
                cur = cur.children[c-'a'];
            }
            if(cur.bEnd) {
                result.append(replacement);
                result.append(" ");
            } else {
                result.append(word);
                result.append(" ");
            }

        }

        return result.toString().trim();
    }

    class TrieNode {
        TrieNode[] children;
        boolean bEnd;
        public TrieNode() {
            children = new TrieNode[26];
            bEnd = false;
        }

    }
    TrieNode root;

    class Trie {
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode cur = root;
            for(char c  : word.toCharArray()){
                if(cur.children[c-'a'] == null) {
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.bEnd = true;
        }
    }
}
