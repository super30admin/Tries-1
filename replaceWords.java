// Time Complexity : O(nm) + O(kl) where nm for constructing the hashmap and kl for the replacement of the words
// Space Complexity : O(nm) + O(k) where nm for constructing the hashmap and k for string array to hold k words
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use Trie here to compare the string words with the dictionary words
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];        // 26 for the alphabets
            isEnd = false;
        }
    }

    TrieNode root;                              // global root variable

    private void insert(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }


    private String update(String word) {
        TrieNode curr = root;
        char[] c = word.toCharArray();

        for (int i=0; i< word.length(); i++) {
            if (curr.isEnd) {                                 // while traversing the input word if we encounter an isEnd, we return the substring till that index, which is the word in the dictionary
                return word.substring(0, i);
            }
            else if (curr.children[c[i]-'a'] == null) {       // the child is not present which means the alphabet is not present in the trie
                return word;
            }
            curr = curr.children[c[i]-'a'];
        }

        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0) return sentence;
        root = new TrieNode();

        // build the trie
        for (String word: dictionary) {
            insert(word);
        }

        // replace words
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word: words) {
            String replace = update(word);
            sb.append(replace + " ");
        }

        return sb.toString().trim();
    }
}