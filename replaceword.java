// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
        TrieNode root;
        
        public void insert(String word){
            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(curr.children[c-'a']==null){
                    curr.children[c-'a']= new TrieNode();
                }
                curr=curr.children[c-'a'];
            }
            curr.isEnd=true;
        }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        
        String[] splitString = sentence.split(" ");
        StringBuilder result = new StringBuilder();
      
        
        for(int j=0;j<splitString.length;j++){
            if(j!=0){
                result.append(" ");
            }
            String word=splitString[j];
            TrieNode curr= root;
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(curr.children[c-'a']==null || curr.isEnd==true){
                    break;
                }
                sb.append(c);
                curr=curr.children[c-'a'];
            }
            if(curr.isEnd==true){
                result.append(sb.toString());
            }else{
                result.append(word);
            }
        }
    return result.toString();
    }
}