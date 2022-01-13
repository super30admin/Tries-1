// Time Complexity : O(nm) + O(kl) 
// Space Complexity : O(nm) + O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach 

// We first create Trie for this
// Then add the words into the trie
// We then split the given sentence and try to find the replacement in the trie, once we find it we replace it

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary.size() == 0 || dictionary == null) {
            return sentence;
        }
        root = new TrieNode();
        for (String word : dictionary) {
            insert(word);
        }
        String[] splitArray = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < splitArray.length; i++) {
            result.append(" ");
            StringBuilder replace = new StringBuilder();
            TrieNode curr = root;
            String word = splitArray[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (curr.children[c - 'a'] == null || curr.isEnd)
                    break;
                replace.append(c);
                curr = curr.children[c - 'a'];
            }
            if (curr.isEnd) {
                result.append(replace);
            } else
                result.append(word);
        }
        return result.toString().trim();
    }
}