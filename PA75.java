//Leetcode: 208. Implement Trie (Prefix Tree)
//Time Complexity: for each method it is O(n) , n is the length of the word
//Space Complexity: O(m), where m is the no of nodes required to insert a new word. Each node is of fixed size 26. 
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            isEnd=false;
            children= new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
       root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {   //O(n)
        TrieNode n= root;
        for(int i=0; i<word.length();i++){
            if(n.children[word.charAt(i)-'a'] ==null){
                n.children[word.charAt(i)-'a'] = new TrieNode();
            }
            n= n.children[word.charAt(i)-'a'];
        }
        n.isEnd= true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {   // O(n)
        TrieNode n= root;
        for(int i=0; i<word.length();i++){
            if(n.children[word.charAt(i)-'a'] ==null){
                return false;
            }
            n= n.children[word.charAt(i)-'a'];
        }
        return n.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {  //O(n)
        TrieNode n= root;
        for(int i=0; i<prefix.length();i++){
            if(n.children[prefix.charAt(i)-'a'] ==null){
                return false;
            }
            n= n.children[prefix.charAt(i)-'a'];
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