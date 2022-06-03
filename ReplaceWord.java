// Time: O(No of the words in the sentence * Length of the prefix from dictionary)
// Space: O(No of the words in the sentence + Length of the words in the dictionary)
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public TrieNode getTrieNode() {
            return root;
        }
        public void insertWord(String word){
            TrieNode curr = root;
            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        //Creating a prefix tree in Trie
        for(String word: dictionary){  //Time: O(No of words in dictionary * Length of the words)
            trie.insertWord(word);
        }

        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        // Traversing every word in the sentence
        for(int j=0;j<words.length;j++) { //O(No of words in the sentence)
            TrieNode curr = trie.getTrieNode();
            StringBuilder replacement = new StringBuilder();
            String word = words[j];
            // looking for the match in the prefix tree
            for(int i=0;i<word.length();i++) { //O(Length of each word in the sentence)
                char c = word.charAt(i);
                // when the first prefix is found, add it to our result
                if(curr.children[c-'a'] == null || curr.isEnd) break;
                replacement.append(c);
                curr = curr.children[c-'a'];
            }
            //when match is found, replace the original word
            if(curr.isEnd) res.append(replacement);
            //when we don't get the exact prefix in the dictionary
            //keep the word same as in the sentence
            else res.append(word);
            if(j<words.length-1) res.append(" ");

        }
        return res.toString();
    }
}}