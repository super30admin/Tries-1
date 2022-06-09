//https://leetcode.com/problems/replace-words/
// Time Complexity :O(words* avglengthofaword)
// Space Complexity :O(words* avglengthofaword)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode(){
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        formdictionary(dictionary);
        StringBuilder result=new StringBuilder();
        String[] words=sentence.split(" ");
        for(int j=0;j<words.length;j++)
        {
             String word=words[j];
            StringBuilder sub=new StringBuilder();
             TrieNode curr=root;        
            for(int i=0;i<word.length();i++)
            {
                   
                    
                        char c=word.charAt(i);
                        if(curr.children[c-'a']==null || curr.isEnd)
                            break;
                        
                            sub.append(c);
                        
                            curr=curr.children[c-'a'];
                  
               
              
            }
            
                     if(curr.isEnd){
                        result.append(sub);
                    }
                     else{
                        result.append(word);
                     }
            if(j!=words.length-1)
            result.append(" ");
        }
        return result.toString();
    }
    private void formdictionary(List<String> dictionary)
    {
        
        for(String word:dictionary)
        {
            TrieNode curr=root;
            for(int i=0;i<word.length();i++)
            {
                char c=word.charAt(i);
                if(curr.children[c-'a']==null)
                    curr.children[c-'a']=new TrieNode();
                curr=curr.children[c-'a'];
            }
            curr.isEnd=true;
        }
    }
}