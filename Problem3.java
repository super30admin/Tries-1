// Time Complexity : O(nxl) - n is the number of words in the array, l - length of the words
// Space Complexity : O(length of the sentence) - for the StringBuilder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//648. Replace Words
//https://leetcode.com/problems/replace-words/

class Solution {
    // time: O(nxl) - n is the number of words in the sentence, l - length of the
    // words
    // space: O(length of the sentence) 
    StringBuilder result = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    int m = 0;

    class Trie {

        class TrieNode {
            boolean isEnd;
            TrieNode[] children;

            public TrieNode() {
                // this.isEnd = false;
                children = new TrieNode[26];
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) { // System.out.print(word.charAt(i)); System.out.println(" " + i);
                if (curr.children[word.charAt(i) - 'a'] == null)
                    curr.children[word.charAt(i) - 'a'] = new TrieNode();
                curr = curr.children[word.charAt(i) - 'a']; // how to go to the node it is poiting to
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            temp = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                if (curr.isEnd) {
                    return true;
                }
                if (curr.children[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                curr = curr.children[word.charAt(i) - 'a'];// how to go to the node it is poiting to
                temp.append(Character.toString(word.charAt(i)));

            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (curr.children[prefix.charAt(i) - 'a'] == null)
                    return false;
                curr = curr.children[prefix.charAt(i) - 'a']; // how to go to the node it is poiting to
            }
            return true;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) { //

        Trie t = new Trie();

        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i) != " ") {
                t.insert(dictionary.get(i));
                // System.out.println(dictionary.get(i));
            }
        }

        String[] sen = sentence.split(" ");
        int N = sen.length;

        for (int j = 0; j < N; j++) {// loop through the sentence and check if startsWith is present, if yes, replace
                                     // it with that word, if not, replace it with the existing word

            if (t.search(sen[j])) { // System.out.println("if else " + sen[j]);
                result.append(temp.toString());
                temp = new StringBuilder();
                m = 0;
            } else if (!(t.search(sen[j]))) { // System.out.println("if " + sen[j]);
                result.append(sen[j]);
                temp = new StringBuilder(); // string builder is extra space
                m = 0;
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
