
//Insert
// Time Complexity : O(m)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes	 	
// Any problem you faced while coding this : no


//Search key
//Time Complexity : O(m)
//Space Complexity : O(1)


//Search prefix
//Time Complexity : O(m)
//Space Complexity : O(1)



class Trie {

    
    class TrieNode{
        
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length() ; i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;    
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for( int i = 0 ;i < word.length() ;i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length() ; i++){
            char c = prefix.charAt(i);
            if(cur.children[ c - 'a'] == null)
                return false;
            cur  = cur.children[c - 'a'];
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

