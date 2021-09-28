// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class implementTrie {
    
    class Node {
        Node [] children;
        boolean isEnd;
        
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }
    private Node root;

    public Trie() {
        root = new Node(); //init root
    }
    
    public void insert(String word) {
        Node curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.children[ch - 'a'] == null) return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            
            if(curr.children [ch - 'a'] == null) return false;
            curr = curr.children [ch - 'a'];
        }
        
        return true;
    }
}
