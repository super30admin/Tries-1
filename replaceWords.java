// Time Complexity :O(nl+ml) m-number of strings in the sentence
// Space Complexity :O(nl) n-number of strings in dict, l-average length of each string 
// Did this code successfully run on Leetcode :yes 
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
        /** Initialize your data structure here. */
        public Solution() {
           root=new TrieNode(); 
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode temp=root;
            for(int i=0;i<word.length();i++)
            {
                char c=word.charAt(i);
                if(temp.children[c-'a']==null)
                    temp.children[c-'a']=new TrieNode();
                temp=temp.children[c-'a'];
            }
            temp.isEnd=true;

        }
        
    public String replaceWords(List<String> dict, String sentence) {
        for(String s:dict)
        {
            insert(s);
        }
        
        String[] str=sentence.split("\\s+");
        StringBuilder result=new StringBuilder();
        for(int j=0;j<str.length;j++)
        {
            String word=str[j];
            StringBuilder r=new StringBuilder();
            TrieNode temp=root;
            if(j>0) result.append(" ");
            for(int i=0;i<word.length();i++)
            {
                char c=word.charAt(i);
                
                if(temp.children[c-'a']==null || temp.isEnd) break;
                
                r.append(c);
                
                temp=temp.children[c-'a'];
            }
            if(temp.isEnd)
                result.append(r);
            else
                result.append(word);
            
        }
        return result.toString();
        
    }
}