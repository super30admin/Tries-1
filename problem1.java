class TrieNode{
    boolean isEnd;
  TrieNode [] children = new TrieNode[26]; 
 
 public TrieNode(){
     
 }
}

class Trie {

 TrieNode root;
 
 public Trie() {
  root=new TrieNode();
 }

 
 // Inserts a word into the trie.
 public void insert(String word) {
     TrieNode node=root;
     for(int i=0; i<word.length(); i++){
         char c= word.charAt(i);
     if(node.children[c-'a']==null){
         node.children[c-'a']=new TrieNode();
     }
         node=node.children[c-'a'];
     }
     
     node.isEnd=true;

         }
         
 
 //Returns if the word is in the trie
 public boolean search(String word) {
       TrieNode node= root;
     for(int i=0; i<word.length(); i++){
         char curr= word.charAt(i);
         
         if(node.children[curr-'a']!=null){
             node=node.children[curr-'a'];
         }
         else return false;
     }
     return node.isEnd;
     
 }
 
 /** Returns if there is any word in the trie that starts with the given prefix. */
 public boolean startsWith(String prefix) {
   //  boolean flag=true;
     TrieNode node= root;
     for(int i=0; i<prefix.length(); i++){
         char curr= prefix.charAt(i);
         
         if(node.children[curr-'a']!=null){
             node=node.children[curr-'a'];
         }
         else return false;
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