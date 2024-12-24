class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            this.children = new TrieNode[26];
        }        
    }
    
    private TrieNode root;
    private String maxString="";
    
    public void insert(String word) { // O(l)
        TrieNode current = root;
        for(int i=0;i< word.length();i++) {
            int idx = word.charAt(i)- 'a';
            if(current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }
        current.isEnd = true;
        
    }
    

    public String longestWord(String[] words) {
        this.root = new TrieNode();
        // inserted.
        for(String word: words) {
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return maxString;
        
    }
    
    private void backtrack(TrieNode curr, StringBuilder path) {
        if(path.length()> this.maxString.length()) {
            maxString = path.toString();
        }
        for(int i=0;i< 26;i++) {
            if(curr.children[i] != null && curr.children[i].isEnd ) {
                int le = path.length();
                path.append((char)(i+97));
                backtrack(curr.children[i], path);
                path.setLength(le);
            }
        }
        
    }
}