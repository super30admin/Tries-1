/* Time Complexity : O(N*M) for search and insert operations where M is length of string.
 Space Complexity :  O(N*M)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */
class Trie {
    class TrieNode{
        TrieNode children[];
        boolean is_end;
        TrieNode(){
            children = new TrieNode[26];
            is_end = false;
            
        }
    }
    
    TrieNode root;
    public Trie() {
       root = new TrieNode();      
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        if(word.length() > 0){
            for(int i=0 ;i<word.length() ; i++){
                int index = word.charAt(i) - 'a';
                if(curr.children[index] == null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.is_end =true;
        }
    }
    
    public boolean search(String word) {
        TrieNode curr = root ;
        if(word.length() > 0){
            for(int i = 0 ; i<word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(curr.children[index] == null){
                    return false;
                }
                curr = curr.children[index];
            }
            return curr.is_end;
        }
        return false;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        if(prefix.length()>0){
            for(int i = 0 ; i<prefix.length() ; i++){
                int index = prefix.charAt(i) - 'a';
                if(curr.children[index] == null){
                    return false;
                }
                curr = curr.children[index];
            }
            return true;
            
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
