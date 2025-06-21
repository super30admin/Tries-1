// Time Complexity -> O(l) insertion, O(l) search, l is lenght of Word to be inserted or searched
class Trie {
    TrieNode root;
    public class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++){
            // find the place if the node exists or not
            char ch = word.charAt(i);
            if(currNode.children[ch - 'a'] == null){
                currNode.children[ch - 'a'] = new TrieNode();
            }
            currNode = currNode.children[ch - 'a'];
        }
        currNode.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++){
            // find the place if the node exists or not
            char ch = word.charAt(i);
            if(currNode.children[ch - 'a'] == null){
                return false;
            }
            currNode = currNode.children[ch - 'a'];
        }
        return currNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for(int i = 0; i < prefix.length(); i++){
            // find the place if the node exists or not
            char ch = prefix.charAt(i);
            if(currNode.children[ch - 'a'] == null){
                return false;
            }
            currNode = currNode.children[ch - 'a'];
        }
        return true;
    }
}
