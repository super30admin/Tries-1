class TrieNode{
    private TrieNode[] links ;
    private final int num_chars = 26;
    private boolean isWord ;
    
    public TrieNode(){
        links = new TrieNode[num_chars] ; // hashmap can be used
    }
    public void setEnd(){
        isWord = true ;
    }
    public void put(char c , TrieNode node){
        links[c - 'a'] = node;
    }
    public boolean containsKey(char c){
        return links[c-'a'] != null ;
    }
    public TrieNode get(char c){
        return links[c-'a'];
    }
    public boolean isEnd(){
        return isWord;
    }
}
class Trie {
    private TrieNode root ;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */ // O(n)
    public void insert(String word) {
        TrieNode node = root ;
        for(int i = 0 ; i< word.length() ; i++){
            char cur = word.charAt(i);
            //first time for this char
            if(!node.containsKey(cur)){
                node.put(cur, new TrieNode());
            }
            // if char exist
            node = node.get(cur);
        }
        node.setEnd();
    }
    
    /** Returns if the prefix is in the trie. */
    public TrieNode searchPrefix(String word) {
        TrieNode node = root ;
        for(int i = 0 ; i< word.length() ; i++){
            char cur = word.charAt(i);
            //first time for this char
            if(node.containsKey(cur)){
                node = node.get(cur);
            }else{
                return null;
            }
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       TrieNode node = searchPrefix(prefix);
       return node!=null ; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */