// TC: O(N*L)
// SC: O(N*L)
public class Problem2 {
    TrieNode root;
    String result;
    StringBuilder path;
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    private void dfs(TrieNode curr){
        //base case
        if(path.length()>result.length()) result = path.toString();

        //logic
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null && curr.children[i].isEnd==true){
                int le = path.length();
                //action
                path.append((char)('a'+i));

                //recurse
                dfs(curr.children[i]);

                //backtrack
                path.setLength(le);
            }
        }

    }
    public String longestWord(String[] words) {
        this.root=new TrieNode();
        this.result="";
        this.path = new StringBuilder();

        for(String word: words){
            insert(word);
        }
        dfs(root);
        return result;
    }

}
