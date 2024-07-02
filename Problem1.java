// TC: O(N)
// SC: O(N)
public class Problem1{
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public Problem1() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(current.children[c-'a']==null){
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(current.children[c-'a']==null) return false;
            current = current.children[c-'a'];
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(current.children[c-'a']==null) return false;
            current = current.children[c-'a'];
        }

        return true;
    }
}