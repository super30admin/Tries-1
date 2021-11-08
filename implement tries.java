//Timecomplexity :- O(m) for inserting,searching because we need to traversal whole world length.
//Spacecomplexity :- O(26) for Trienode at every level.
//Did it run on leetcode:- Yes.
//What was the problem faced while doing this sum:- got some errors.
//explanation is given beside in comments.



class Trie {
    class TrieNode{
            TrieNode[] children;//initially a trienode of itself.
            boolean isword; //flag for word.
        
        public TrieNode(){
            children=new TrieNode[26];
            isword=false;         //constructor for initializing.
        }
    }
    
    TrieNode root; // for initial starting point.

    public Trie() {
        root=new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode current=root;
        for(char ch : word.toCharArray()){
            if(current.children[ch-'a']==null){
                current.children[ch-'a']=new TrieNode(); //checking for every character by converting string to character
                                                         // array and if at first place if it null creating a trienode
                                                         // and changing parent to children
            }
            current=current.children[ch-'a'];
            
        }
        current.isword=true;  // after inserting whole word changing flag to true signifying that word is inserted.
        
    }
    
    public boolean search(String word) {
        TrieNode searchcurrent=root;
        for(char ch:word.toCharArray()){
            if(searchcurrent.children[ch-'a']==null){
                return false;
            }                                      // if there is a null at any character of string false is returned
              searchcurrent=searchcurrent.children[ch-'a'];                                       
                                                      // or after entire traversing of word it simply returns isword;
        }
      
        return searchcurrent.isword;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode searchcurrent=root;
        for(char ch:prefix.toCharArray()){
            if(searchcurrent.children[ch-'a']==null){
                return false;
            }                                      // same as search but after traversing not bothered of whether                    
            searchcurrent=searchcurrent.children[ch-'a'];
                                                          //inserted or not just upto that point returning true;
        }
        
        return true;
        
    }
}