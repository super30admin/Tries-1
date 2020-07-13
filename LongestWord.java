// Time Complexity : O(L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes	 	
// Any problem you faced while coding this : no



class Solution {
    
    class TrieNode{
        String word;
        TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
        
        
    }
    TrieNode root ;
    public void insert(String s)
    {
        
        TrieNode cur = root;
        for(int i = 0 ;i < s.length(); i++){
            
            char c = s.charAt(i);
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c -'a'];
            
        }
        
        cur.word = s;
        //System.out.println(cur.word);
        
    }
    
    public String longestWord(String[] words) {
        
        root = new TrieNode();
        for(String s : words){
            insert(s);
        }
        
        Queue<TrieNode> queue  = new LinkedList<>();
        queue.add(root);
         TrieNode cur = null;
        while(!queue.isEmpty()){
               cur = queue.poll();
            for(int  i = 25;  i >=0 ; i--){
              if(cur.children[i] != null && cur.children[i].word != null)
              {
                  queue.add(cur.children[i]);
              } 
            }
            
        }
        
        return cur.word;
        
        
    }
}