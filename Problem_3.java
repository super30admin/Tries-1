// Time Complexity :O(n)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        insert(dictionary);
        String[] arr=sentence.split("\\s+");
        //System.out.println(arr[0]);
        TrieNode curr=null;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            curr=root;
            for(char c:arr[i].toCharArray()){
               if(curr.children[c-'a']==null || curr.isEnd) break;
               str.append(c);
               curr=curr.children[c-'a'];
            }
            
            if(curr.isEnd){
                arr[i]=str.toString();
            }
            str.delete(0,str.length());
        }
        StringBuilder result=new StringBuilder();
        for(String st:arr){
            result.append(st+" ");
        }
        return result.toString().trim();
    }
    
    public void insert(List<String> dictionary){
        TrieNode curr=root;
        for(String st:dictionary){
            curr=root;
            for(int i=0;i<st.length();i++){
                char ch=st.charAt(i);
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']=new TrieNode();
                }
                curr=curr.children[ch-'a'];
            }
            curr.isEnd=true;
        }
    }

}

///////////////////






class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        insert(dictionary);
        String[] arr=sentence.split("\\s+");
        //System.out.println(arr[0]);
        TrieNode curr=null;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            curr=root;
            for(char c:arr[i].toCharArray()){
               if(curr.children[c-'a']==null){
                   break;
               }else{
                   str.append(c);
               }
               curr=curr.children[c-'a'];
            }
            if(curr.isEnd){
              // System.out.println(str); 
               arr[i]=str.toString();
            }
            str.delete(0,str.length());
        }
        StringBuilder result=new StringBuilder();
        for(String st:arr){
            result.append(st+" ");
        }
        return result.toString().trim();
    }
    
    public void insert(List<String> dictionary){
        TrieNode curr=root;
        for(String st:dictionary){
            curr=root;
            for(int i=0;i<st.length();i++){
                char ch=st.charAt(i);
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']=new TrieNode();
                }
                curr=curr.children[ch-'a'];
            }
            curr.isEnd=true;
        }
    }

}