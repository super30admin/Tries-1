//solved successfully on leetcode and faced no issues
//TC for insert and search : O(L) //lgt of word
//TC for startswith :O(P) //lgt of prefix
//SC :O(L) //for insert worst case
//SC :O(1) //for search and startswith


class Trie {
    class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
    }
    private TrieNode root;


    public Trie() {
        this.root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode curr = root; //curr is used to traverse down trie paths
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch-'a'] =new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true; //when word finishes , curr will be at last node , make there trure

        
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;

            }
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd; //if word finishes return what is the boolean value present there
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0 ; i < prefix.length() ; i++){
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