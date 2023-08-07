//Problem 1: Trie Prefix Tree
// Time Complexity : O(length of word)
// Space Complexity : 26 O(length of word)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> Form a custom Node class and form Tree for every other letter that has children Nodes for every other letter. This way it is easy for lookup
class Trie {
    //TC: O(Length of word) SC: 26 O(L)
    class TrieNode{ //Custom Trie class
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            this.children=new TrieNode[26];
        }
    }
    private TrieNode root;

    public Trie() { //initiate
        this.root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.children[c-'a'] == null){ //if there is no character present, add a new TrieNode 
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a']; //shift current position
        }
        cur.isEnd=true; //at the end, do endpoint is true
    }
    
    public boolean search(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.children[c-'a'] ==null){ //anywhere we found an empty Trie, means total string isnt present
                return false;
            }
            cur=cur.children[c-'a']; // shift current position
        }
        return cur.isEnd; // if we at end of word, check if the end is 
    }
    
    public boolean startsWith(String prefix) {
       TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(cur.children[c-'a'] ==null){
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return true; 
    }
}



//Problem 3: replace words
// Time Complexity : O(n*l) n=number of words, l=length of longest word
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach-> create custom trie class and insert all dictionary in it for better search. then parse through all words to check if dictionary word exists, if yes, replace
class Solution {
    class TrieNode{ //Custom Trie class
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            this.children=new TrieNode[26];
        }
    }
    private void insert(String word, TrieNode root) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.children[c-'a'] == null){ //if there is no character present, add a new TrieNode 
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a']; //shift current position
        }
        cur.isEnd=true; //at the end, do endpoint is true
    }

    private TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root=new TrieNode();
        StringBuilder res= new StringBuilder();
        String[] strArr= sentence.split(" ");
        for(String str: dictionary){ // TC: n*l SC: n*l
            insert(str, root);
        }
        for(int i=0;i<strArr.length;i++){
            String curStr=strArr[i];
            StringBuilder replace= new StringBuilder(); //string for parsing each word
            if(i>0) res.append(" "); //for space after every word we parse
            TrieNode cur= root;
            for(int k=0;k<curStr.length();k++){
                char c=curStr.charAt(k);
                if(cur.children[c-'a']==null || cur.isEnd) break; //end has arrived, get out of loop or there is no children character c
                cur=cur.children[c-'a']; //increment current
                replace.append(c); //character is present so add in replacement string
            }
            //if whole string exists
            if(cur.isEnd)
                res.append(replace); // part of string exists
            else
                res.append(curStr); //no or whole string exists
            
        }

        return res.toString();
    }

    //hashmap solution
    // public String replaceWords(List<String> dictionary, String sentence) {
    //     HashSet<String> set = new HashSet<>(dictionary);
    //     String[] arr= sentence.split(" ");
    //     StringBuilder res= new StringBuilder();
    //     for(int k=0;k<arr.length;k++){
    //         if(k>0) res.append(" ");
    //         String word= arr[k];
    //         boolean flag=false;
    //         for(int i=0;i<word.length();i++){
    //             String sub= word.substring(0,i+1);
    //             if(set.contains(sub)){
    //                 flag=true;
    //                 res.append(sub);
    //             }
    //             if(flag) break; //shortest replacement found
    //         }
    //         if(!flag) res.append(word); //word not found
    //     }
    //     return res.toString();
    // }
}