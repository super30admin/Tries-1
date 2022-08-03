class LongestWord {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    TrieNode root;
    // TC is O(l) where l is the length of word
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    StringBuilder max = new StringBuilder();
    public String longestWord(String[] words) {
        root = new TrieNode();
        int n = words.length;
        for(int i=0; i<n;i++){
            insert(words[i]);
        }
        dfs(root, new StringBuilder());
        return max.toString();
    }
    
    // TC is 26^26
    private void dfs(TrieNode node,StringBuilder currStr){
        // base
        if(currStr.length() > max.length()){
            max = new StringBuilder(currStr);
        }
        
        //logic
        for(int i=0; i<26;i++){
            if(node.children[i] != null && node.children[i].isEnd){
                //action
                int len = currStr.length();
                currStr.append((char)(i+'a'));
                
                //recurse
                dfs(node.children[i], currStr);
                
                //backtrack
                currStr.setLength(len);
            }
        }
    }
}