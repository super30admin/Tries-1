// Time Complexity : O(N) length of sentence
// Space Complexity : O(n*k)
// Any problem you faced while coding this : No

class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        
        TrieNode(){
            this.children=new TrieNode[26];
            this.word="";
        }
    }
    
    TrieNode root;
    public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.word=word;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        for(String word:dictionary){
            insert(word);
        }
        StringBuilder result=new StringBuilder();
        String[] arr=sentence.split(" ");
        for(int j=0;j<arr.length;j++){
            String word=arr[j];
            TrieNode curr=root;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(curr.children[c-'a']!=null && curr.children[c-'a'].word.length()>0){
                    result.append(curr.children[c-'a'].word);
                    break;
                }else if(curr.children[c-'a']==null || i==word.length()-1){
                     result.append(word);
                    break;
                } 
                
                curr=curr.children[c-'a'];
            }
            if(j<arr.length-1)
            result.append(" ");
        }
        
        return result.toString();
    }
}