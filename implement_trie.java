//TC: O(n*l) 
//SC: O(n*l*26)  n- given list of words, l length of each word, 26 array size
//leetcode: successful

//correct me if the above space and time complexities are wrong

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        TrieNode(){
         children = new TrieNode[26];
    }
    }
    
    
    TrieNode root;

    public Trie() {
       root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a']= new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i< word.length();i++){
        char c = word.charAt(i);
            if(curr.children[c-'a'] !=null){
            curr = curr.children[c-'a'];
        }
            else 
                return false;
    }
            return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i< prefix.length();i++){
        char c = prefix.charAt(i);
            if(curr.children[c-'a'] !=null){
            curr = curr.children[c-'a'];
        }
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