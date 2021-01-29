//time complexiryt: O(L)

//space complexity :O(L)
class TrieNode{
    boolean isEnd;
    TrieNode[]children;
    
    TrieNode(){   
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}


class Trie {
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //take a curr TrieNode ptr
        TrieNode curr = root;
        //iterate the word
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                //if here, then node not present, create new
                curr.children[ch-'a'] = new TrieNode();          
            }
            curr = curr.children[ch - 'a']; //move curr ptr ahead;
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
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