// Time Complexity : O(n*m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] child;
        public TrieNode(){
            this.isEnd = false;
            this.child = new TrieNode[256];
        }
    }
    TrieNode root; 
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.child[c-'a']==null)
                curr.child[c-'a']=new TrieNode();
            curr = curr.child[c-'a'];
            }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.child[c-'a']==null)
                return false;;
            curr = curr.child[c-'a'];
            }
        return curr.isEnd==true;
    }
    
    public boolean startsWith(String prefix) {
       TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.child[c-'a']==null)
                return false;;
            curr = curr.child[c-'a'];
            }
        return true; 
    }
}