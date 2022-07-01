//****IMPLEMENT TRIES/ PREFIX TREE****
//Time complexity:o(L); l is length of the max word;
//Space complexity:0(1);
//Leetcode runnable: Y;
//Any doubts: N;

class Trie {
    //Creating a node structure
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode()
        {
            children=new TrieNode[26];
        }
    }
    //Making the root node;
    TrieNode root;
    public Trie() //n*l*26 n-number of words//l-length of max word
    { 
        root=new TrieNode();
        
    }
    
    public void insert(String word) { //0(1)
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            //if that character doesnt exists already
            if(curr.children[c-'a']==null)
            {
                //Making a child node
                curr.children[c-'a']=new TrieNode();   
            }
            curr=curr.children[c-'a'];
            
        }
        curr.isEnd=true;
        
    }
    
    public boolean search(String word) {  // o(1);
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            //if that character doesnt exists directly return false
            if(curr.children[c-'a']==null) return false;
            //go for the next if the char exists
            curr=curr.children[c-'a'];
            
        }
        //If we have compleated traversing the word
        //Now check if at the curr isend is true, then the word exists!
        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) { //o(1)
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            char c=prefix.charAt(i);
            //if that character doesnt exists directly return false
            if(curr.children[c-'a']==null) return false;
            //go for the next if the char exists
            curr=curr.children[c-'a'];
        }
        //If it doesnt return false at any instance, The whole prefix exists
        //And hence return true;
        return true;
        
        
    }
}

//****REPLACE WORDS
//Time complexity: o(n*l);
//Space complexity:
//Leetcode runnable: Y;
//Any doubts: N;
class Solution {
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode()
        {
            children=new TrieNode[26];
        }
    }
    TrieNode root;
    
    public void insert(String word) { //0(1)
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            //if that character doesnt exists already
            if(curr.children[c-'a']==null)
            {
                //Making a child node
                curr.children[c-'a']=new TrieNode();   
            }
            curr=curr.children[c-'a'];
            
        }
        curr.isEnd=true;
        
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();
        StringBuilder result=new StringBuilder();
        //1.Adding dictonary words to the trie
        for(String s: dictionary)
        {
            insert(s);
        }
        //2.Convert given sentence to string array
        String[] strarr=sentence.split(" ");
        
        //3.Iterating over strarr
        for(int k=0;k<strarr.length;k++)
        {
            String word=strarr[k];
            if(k!=0) result.append(" "); 
            StringBuilder replacement=new StringBuilder();
            TrieNode curr=root;
            //3.1 Iterating over a particular word
            for(int i=0;i<word.length();i++)
            {
                char c=word.charAt(i);
                if(curr.children[c-'a']==null || curr.isEnd)
                {
                    break;
                }
                replacement.append(c);
                curr=curr.children[c-'a'];
            }
            if(curr.isEnd)
            {
                //replacement is found
                result.append(replacement);
            }
            else
            {
                result.append(word);
            }
        }
        
        return result.toString();
        
    }
}
