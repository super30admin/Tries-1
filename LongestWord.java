/* Time Complexity : O(nk) where n is no of strings and k is avg length 
   Space Complexity : O(nk)  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Solution {
    class TrieNode{
        TrieNode[] children;
        String s;
        public TrieNode(){
            children = new TrieNode[26];
            
        }
    }
    TrieNode root;
    private void insertWord(String word){
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.children[c-'a']==null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.s=word;
    }
    public String longestWord(String[] words) {
        root= new TrieNode();
        for(String word: words)
            insertWord(word);
        //BFS
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode cur=null;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int i=25;i>=0;i--){
                if(cur.children[i]!=null && cur.children[i].s!=null)
                    q.add(cur.children[i]);
            }
        }
        if(cur.s==null)
            return "";
        return cur.s;
        
    }
}