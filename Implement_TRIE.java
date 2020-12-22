class Trie {
    class Node{
        boolean end;
        Node [] children;
        
        public Node(){
            children=new Node [26];
        }
    }
    /** Initialize your data structure here. */
    Node root;
    public Trie() {
        root=new Node();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char c =word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new Node();
            }
            curr=curr.children[c-'a'];
        }
        curr.end=true;
        
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr=root;
        for (int i=0;i<word.length();i++){
        char c =word.charAt(i);
            if (curr.children[c-'a']!=null){
                curr=curr.children[c-'a'];
            }else{
                return false;
            }
            
        }
        
        return curr.end;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr =root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if (curr.children[c-'a']!=null){
                curr=curr.children[c-'a'];
            }else{
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
 */
