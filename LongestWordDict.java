class Solution {
    TrieNode root;
    String result;

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        this.result = "";
        for(String word : words){
            insert(word);
        }

        dfs(root, new StringBuilder());

        return result;
    }
    private void dfs(TrieNode curr, StringBuilder path){
        // TrieNode curr = root;
        if(result.length()<path.length()){
            result = path.toString();
        }
        for(int i =0; i<26;i++){
            if(curr.children[i] != null && curr.children[i].isEnd){
                int le = path.length();
                //action
                path.append((char)(i+'a'));
                //recurse
                dfs(curr.children[i], path);
                //backtracking
                path.setLength(le);
            }
        }
    }
}