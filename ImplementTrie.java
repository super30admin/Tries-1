class Trie {
    class Node{
        Node links[]= new Node[26];
        boolean flag=false;
    } 

    private Node root;

    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(char c: word.toCharArray()){
            int idx= c-'a';
            if(node.links[idx]==null){
                node.links[idx]=new Node();
            }
            node=node.links[idx];
        }
        node.flag=true;
    }
    
    public boolean search(String word) {
        Node node=root;
        for(char c:word.toCharArray()){
            int idx= c-'a';
            if(node.links[idx]==null){
                return false;
            }
            node=node.links[idx];
        }
        return node!=null && node.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(char c:prefix.toCharArray()){
            int idx= c-'a';
            if(node.links[idx]==null){
                return false;
            }
            node=node.links[idx];
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