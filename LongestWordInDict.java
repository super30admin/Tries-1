
//Time Complexity : O((m+n)l)
//Space Complexity : O(nl)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//for every input word, store them in trie. Then using dfs find the longest word in trie.
class LongestWordInDict {
    class TrieNode{
        TrieNode[] tn=new TrieNode[26];
        boolean isEnd;
    }
    
    private void insert(String word,TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.tn[ch-'a']==null){
                curr.tn[ch-'a']=new TrieNode();
            }
            curr=curr.tn[ch-'a'];
        }
        curr.isEnd=true;
    }
    
    //DFS backtrack
    String max="";
    public String longestWord(String[] words) {
        TrieNode root=new TrieNode();
        for(String word:words){
            insert(word,root);
        }
        StringBuilder sb=new StringBuilder();
        dfs(root,sb);
        return max;
    }

    private void dfs(TrieNode root, StringBuilder path){
        //base
        if(path.length()>max.length()){
            max=path.toString();
        }

        //logic
        for(int i=0;i<26;i++){
            
            if(root.tn[i]!=null && root.tn[i].isEnd){
                int len=path.length();
                char ch=(char)(i+'a');
                path.append(ch);
                dfs(root.tn[i],path);
                path.setLength(len);
            }
        }
    }
    
    /*
    //BFS
    public String longestWord(String[] words) {
        TrieNode root=new TrieNode();
        for(String word:words){
            insert(word,root);
        }
        
        Queue<TrieNode> q1=new LinkedList<>();
        Queue<String> q2=new LinkedList<>();
        q1.add(root);
        q2.add("");
        TrieNode curr;
        String currstr="";
        while(!q1.isEmpty()){
            curr=q1.remove();
            currstr=q2.remove();
            for(int i=25;i>=0;i--){
                if(curr.tn[i]!=null && curr.tn[i].isEnd){
                    q1.add(curr.tn[i]);
                    char ch=(char)(i+'a');
                    String ncurr = currstr+ch;
                    q2.add(ncurr);
                }
            }
            
        }
        return currstr;
    }
    */
}