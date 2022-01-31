//TC: O(1) -- Avg TC
//SC: O(n) 
//Did it run on leetcode: Yes
//Faced any problems: No
class Trie {
    //constructor
    class TrieNode{
        boolean isEnd; //flag to check end of word
        TrieNode [] children; //arr to store children nodes a-z
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public Trie() { 
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        //keeing a pointer to add elements in TrieNode
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr =root;
        for(int i = 0; i< word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) return false;
            curr =curr.children[ch - 'a']; 
        }
       return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i< prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
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