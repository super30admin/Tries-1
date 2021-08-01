// Time Complexity : O(NK + L) [N: words, K: characters]
// Space Complexity : O(NK +L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    
     class TrieNode {
         boolean isEnd;
        TrieNode[] children;
        
        public TrieNode()
        {
            children=new TrieNode[26];
        }
        
    }
    
    TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
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
    
    public String replaceWords(List<String> dictionary, String sentence) {
        
        if(dictionary==null || dictionary.size()==0)
            return sentence;
        
        root=new TrieNode();
        
        for(String word:dictionary)
        {
            insert(word);
        }
        
        String[] splitArray=sentence.split("\\s");
        
        StringBuilder result=new StringBuilder();
        
        
        
        for(int j=0;j<splitArray.length;j++)
        {
            if(j>0)
                result.append(' ');
         
            TrieNode curr=root;
            String word=splitArray[j];
            StringBuilder replacement=new StringBuilder();
            for(int k=0;k<word.length();k++)
            {
                      char c=word.charAt(k);
                
                if(curr.children[c-'a']==null || curr.isEnd)
                    break;
                curr=curr.children[c-'a'];
                replacement.append(c);
            }
            if(curr.isEnd)
            {
                // reached end of word did find prefix
                result.append(replacement.toString());
            }
            else
            {
                //if we dont find
                result.append(word);
                
            }
        }
        
        
        return result.toString();
    }
}