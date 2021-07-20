//Time complexity-O(max length of string)
//Space complexity-O(length of unique prefix + number of suffix)
//Ran on leetcode:Yes
//Solution with comments-
class Trie {
        class TrieNode{
            TrieNode[] children;
            boolean isValid;
            
            public TrieNode(){
                children= new TrieNode[26];
                isValid=false;
            }
           
        }
    
     TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
       root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr= root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){//Index of trie is charcter's numeric value. 
                curr.children[c-'a']=new TrieNode();
            }
            curr= curr.children[c-'a'];
        }
        curr.isValid=true;//valid word only when we are at the end of the word.
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr= root;
         for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
                return false;
            }
            curr=curr.children[c-'a'];
        }
        
        return curr.isValid;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr= root;
        for(char c : prefix.toCharArray()){
            if(curr.children[c-'a']!=null){
                curr=curr.children[c-'a'];
            }
            else{
                return false;
                }
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
 */s