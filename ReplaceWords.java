//tc : O(#wordsInSentence * maxStringLength)
//sc : O(#wordsInDictionary * maxStringLength)
//run successfully on leetcode
//no problems

//created a trie of the dictionary values
//searched the prefic values in the trie if exists
//eles put the same word in the string

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        class Trie {
            class TrieNode {
                boolean isEnd;
                String word;
                TrieNode[] children;

                public TrieNode() {
                    this.children = new TrieNode[26];
                    this.isEnd = false;
                }
            }

            TrieNode root = new TrieNode();

            public void insert(String word) {
                TrieNode curr = root;
                for (int i = 0; i < word.length(); i++) {
                    int ind = word.charAt(i) - 'a';
                    if (curr.children[ind] == null)
                        curr.children[ind] = new TrieNode();
                    if (curr.children[ind].isEnd)
                        return;
                    curr = curr.children[ind];
                }
                curr.isEnd = true;
                curr.word = word;
            }

            public String getPrefix(String word) {
                TrieNode curr = root;
                for (int i = 0; i < word.length(); i++) {
                    int ind = word.charAt(i) - 'a';
                    if (curr.children[ind] == null)
                        return word;
                    if (curr.children[ind].isEnd)
                        return curr.children[ind].word;
                    curr = curr.children[ind];
                }
                return word;
            }

        }

        Trie dict = new Trie();
        for (String word : dictionary) {
            dict.insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(dict.getPrefix(word));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
}