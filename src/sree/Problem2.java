package sree;

class Problem2 {

    TrieNode root;
    String result;

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        this.root= new TrieNode();
        this.result= "";
        for(String word: words){
            insert(word);
        }
        dfs(root, new StringBuilder());
        return result;
    }

    public void dfs(TrieNode curr, StringBuilder path){
        //base
        if(result.length()< path.length()){
            result= path.toString();
        }

        //logic
        for(int i=0; i<26; i++){
            if(curr.children[i]!= null && curr.children[i].isEnd){
                int length= path.length();
                path.append((char)(i+'a'));
                dfs(curr.children[i],path);
                path.setLength(length);
            }
        }
    }
}