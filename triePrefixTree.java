//Time Complexity: O(nk) where k is the length of the string
//Space Complexity: (nk)  where k is the length of the string

class Trie {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
   
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
       TrieNode curr = root;

       for(int i = 0; i < word.length(); i++) {
           char ch = word.charAt(i);
           if(curr.children[ch - 'a'] == null) {
               return false;
           }
           curr = curr.children[ch - 'a'];
       }
       if(curr.isEnd == true) {
           return true;
       }
       else {
           return false;
       }
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}