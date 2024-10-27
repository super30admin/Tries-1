class Solution {
    StringBuilder res;
    class TrieNode{
        boolean isEnd;
        TrieNode[] child;
        public TrieNode(){
            child = new TrieNode[26];
        }
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        res=new StringBuilder();
        for(int i=0;i<words.length;i++){
            TrieNode curr = root;
            for(int j=0;j<words[i].length();j++){
                if(curr.child[words[i].charAt(j)-'a']==null){
                    curr.child[words[i].charAt(j)-'a'] = new TrieNode();
                }
                curr = curr.child[words[i].charAt(j)-'a'];
            }
            curr.isEnd=true;
        }

        dfs(root,new StringBuilder());
        return res.toString();
    }
    private void dfs(TrieNode root,StringBuilder path){
        if(path.length()>res.length())
            res=new StringBuilder(path);
        for(int i=0;i<26;i++){
            if(root.child[i]!=null){
                if(root.child[i].isEnd){
                    path.append((char)('a'+i));
                    dfs(root.child[i],path);
                    path.deleteCharAt(path.length()-1);
                }
            }
        }
    }
}
