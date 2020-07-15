//Time Complexity:O(n) - n length of the word
//Space Complexity: O(n) - n length of the word

class TrieNode {
    
    public TrieNode[] ch = new TrieNode[26];
    public boolean isEnd;
    public TrieNode() {
        
    }
}

class Trie {
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() { 
        root = new TrieNode();   
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode wRoot = root;
        for(int i = 0 ; i < word.length();i++) {
            char c = word.charAt(i);
            if(wRoot.ch[c - 'a'] == null)
                wRoot.ch[c - 'a'] = new TrieNode();
             wRoot = wRoot.ch[c-'a']; 
        }
            wRoot.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode wRoot = root;
        for(int i = 0 ; i < word.length();i++)          {
            char c = word.charAt(i);
            if(wRoot.ch[c-'a'] == null)
                    return false;
             wRoot = wRoot.ch[c-'a']; 
        }
            return wRoot.isEnd;
    }
    
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode wRoot = root;
        for(int i = 0 ; i < prefix.length();i++) {
            char c = prefix.charAt(i);
            if(wRoot.ch[c-'a'] == null)
                    return false;
            wRoot = wRoot.ch[c-'a']; 
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
