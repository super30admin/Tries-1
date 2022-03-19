// Time Complexity : O(m) m is size of word
// Space Complexity : O(1) as we have to return the trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create the  TrieNode class with children array boolean end
//Create constructor of Trie with initializing children of size 25
// Use ascii logic to store the character as indexes in the TrieNode
//Implement the logic for search via traversal and insert via creating TrieNode
class TrieNode{
    TrieNode[] children;
    boolean end;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
      root = new TrieNode(); 
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null)
                node.children[c - 'a'] = new TrieNode();
            node = node.children[c - 'a'];
        }
        node.end = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] != null){
                node = node.children[c - 'a'];
            }
            else{
                return false;
            }
        }
        return node.end; 
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c-'a'] != null){
                node = node.children[c - 'a'];
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
 */