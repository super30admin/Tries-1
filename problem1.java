    /**
    Time Complexity :
    insert()     -> O(L)
    search()     -> O(L)
    startsWith() -> O(L)

    Explanation:
    L = length of the word/prefix.
    Each operation processes one character at a time.

    Space Complexity : O(N * L)
    Explanation:
    In worst case, we store N words each of length L,
    creating nodes for each character.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to represent children nodes.
    Fixed it by using an array of size 26 for lowercase letters.
    Also needed to clearly differentiate between:
        - search() → checks complete word (isEnd must be true)
        - startsWith() → only checks prefix existence
    */

        class Trie {


            class TrieNode {
                boolean isEnd;
                TrieNode[] children;
        
                public TrieNode() {
                    this.children = new TrieNode[26];
                }
            }
        
            private TrieNode root;
        
            public Trie() {
                this.root = new TrieNode();
            }
        
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
        
            public boolean search(String word) {
        
                TrieNode curr = root;
        
                for (int i = 0; i < word.length(); i++) {
        
                    char c = word.charAt(i);
        
                    if (curr.children[c - 'a'] == null) {
                        return false;
                    }
        
                    curr = curr.children[c - 'a'];
                }
        
                return curr.isEnd;
            }
        
            public boolean startsWith(String prefix) {
        
                TrieNode curr = root;
        
                for (int i = 0; i < prefix.length(); i++) {
        
                    char c = prefix.charAt(i);
        
                    if (curr.children[c - 'a'] == null) {
                        return false;
                    }
        
                    curr = curr.children[c - 'a'];
                }
        
                return true;
            }
        }