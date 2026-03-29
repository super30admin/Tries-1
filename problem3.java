    /**
    Time Complexity : O(N * L + S * L)
    Explanation:
    - Building Trie from dictionary: O(N * L)
    - For each word in sentence (S words), we traverse up to L characters
    So total ≈ O(N * L + S * L)

    Space Complexity : O(N * L)
    Explanation:
    Trie stores all dictionary words.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to replace words efficiently.
    Brute force comparison for every prefix was slow.
    Optimized using Trie:
        - Insert all dictionary roots
        - For each word, find shortest matching prefix
    Also ensured to stop early when a root word is found.
    */

    class Solution {



        class TrieNode {
            boolean isEnd;
            TrieNode[] children;
    
            public TrieNode() {
                this.children = new TrieNode[26];
            }
        }
    
        TrieNode root = new TrieNode();
    
        // Insert dictionary word into Trie
        private void insert(String word) {
    
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
    
        // Find shortest root replacement
        private String swap(String word) {
    
            TrieNode curr = root;
            StringBuilder prefix = new StringBuilder();
    
            for (int i = 0; i < word.length(); i++) {
    
                char c = word.charAt(i);
    
                // No matching root
                if (curr.children[c - 'a'] == null) {
                    return word;
                }
    
                prefix.append(c);
                curr = curr.children[c - 'a'];
    
                // Found shortest root
                if (curr.isEnd) {
                    return prefix.toString();
                }
            }
    
            return word;
        }
    
        public String replaceWords(List<String> dictionary, String sentence) {
    
            // Build Trie
            for (String word : dictionary) {
                insert(word);
            }
    
            String[] arr = sentence.split(" ");
            StringBuilder sb = new StringBuilder();
    
            // Replace each word
            for (String s : arr) {
                sb.append(swap(s)).append(" ");
            }
    
            return sb.toString().trim();
        }
    }