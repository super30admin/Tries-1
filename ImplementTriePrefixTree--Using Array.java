//Problem 76: Implement Trie (Prefix Tree)
//Time Complexity: O(Number of words * word length)
//Space Complexity : O(Number of words * word length); 

/*
 Create a Trie Node comprising of isEnd and children array;
 1) Insert: //TC: O(word length) | SC: O(word length) : Keep a current pointer. Iterate over the string to be added into trie. If curr child is null initialise it with trie node. Keep moving the current pointer. Once word traversal is finished set curr pointer isEnd = true;

2) Search  : //TC: O(word length) : Start with root. Iterate over the word and keep moving current pointer. If current pointer becomes null at any point then return false, otherwise at the end return curr.isEnd. It will give what ever the result is 

3) Prefix : //TC: O(word length) : Will compare the whole prefix.  Start with root. Iterate over the word and keep moving current pointer. If current pointer becomes null at any point then return false, otherwise at the end will return true

*/

class Trie {
    //TC: O(Number of words * word length) | SC: O(Number of words * word length)
       class TrieNode{
           boolean isEnd;
           TrieNode[] children;
           
           TrieNode(){
               this.children = new TrieNode[26];
           }
           
       }
       
       /** Initialize your data structure here. */
       TrieNode root;
       public Trie() {
           root = new TrieNode();
       }
       
       /** Inserts a word into the trie. */
       public void insert(String word) {
           //TC: O(word length) | SC: O(word length)
           TrieNode curr = root;
           for(char ch: word.toCharArray()){
               
               if(curr.children[ch-'a']==null){
                   curr.children[ch-'a'] = new TrieNode();
               }
               
               curr = curr.children[ch-'a'];
           }
           
           curr.isEnd = true;
       }
       
       /** Returns if the word is in the trie. */
       public boolean search(String word) {
           //TC: O(word length)
           TrieNode curr = root;
           for(char ch: word.toCharArray()){
               
               if(curr.children[ch-'a']==null) return false;
               
               curr = curr.children[ch-'a'];
           }
           
           return curr.isEnd;
       }
       
       /** Returns if there is any word in the trie that starts with the given prefix. */
       public boolean startsWith(String prefix) {
           //TC: O(word length)
           TrieNode curr = root;
           for(char ch: prefix.toCharArray()){
               
               if(curr.children[ch-'a']==null) return false;
               
               curr = curr.children[ch-'a'];
           }
           
           return true;
       }
   }
   
   /**
    * Your Trie object will be instantiated and called as such:
    * Trie obj = new Trie();
    * obj.insert(word);
    * boolean param_2 = obj.search(word);
    * boolean param_3 = obj.startsWith(prefix);
    */