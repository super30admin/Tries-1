//insert- O(length of word);
//search-O(lenght of search value)
//starts with -O(lenght of search value)

//space complexity: O(length of word )* O(26)

class Trie {
    
    class TrieNode {
    
        // R links to node children
        private TrieNode[] links;
    
        private boolean isEnd;
    
        public TrieNode() {
            links = new TrieNode[26];
        }
    
        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
        
        private final TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                // TrieNode node = curr.map.get(c);
                if(!curr.containsKey(c))
                {
                    curr.put(c, new TrieNode());
                }
                curr = curr.get(c);
            }
            curr.setEnd();
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curr = root;
            for(int i=0; i < word.length(); i++)
            {
                char c = word.charAt(i);
                if(curr.containsKey(c))
                    curr = curr.get(c);
                else
                    return false;
            }
            return curr.isEnd();
            
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(int i=0; i < prefix.length(); i++)
            {
                char c = prefix.charAt(i);
                if(curr.containsKey(c))
                    curr = curr.get(c);
                else
                    return false;
            }
            return true;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */