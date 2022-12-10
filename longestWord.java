// Time Complexity : O(n * l) 
//n-> length of dictionary, l-> avg length of words in dic
// Space Complexity : O(n * l) 
class Solution {
    TrieNode root;
    Queue<TrieNode> q;
    
    class TrieNode{
        TrieNode[] children;
        String str;
        
        public TrieNode(){
            children=new TrieNode[26];
        }
        
        
    }
    
    private void insert(String word){
           TrieNode curr= root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a'] = new TrieNode();
                    
                }
                
                curr=curr.children[ch-'a'];
            }
            curr.str=word;
        }
    
    
    public String longestWord(String[] words) {
        if(words==null || words.length==0) return new String();
        q=new LinkedList<>();
        root=new TrieNode();
        q.add(root);
        TrieNode curr=root;
        for(String strs:words){
            insert(strs);
        }
        
       
        while(!q.isEmpty()){
            curr= q.poll();
            for(int i=25;i>=0;i--){
                
                if(curr.children[i]!=null && curr.children[i].str!=null){
                    q.add(curr.children[i]);

                }
               
            }
        }

        if(curr.str==null) return "";
        return curr.str;
    }
}