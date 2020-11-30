

class Trie {

    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    
        boolean isEndOfWord;
        char val;
    
        public TrieNode(char val) {
            isEndOfWord = false;
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            this.val = val;
        }
    }

    public TrieNode root;
    
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char index = word.charAt(i);                
            if(curr.children[index-'a'] == null){
                curr.children[index-'a'] = new TrieNode(index);
            }
            curr = curr.children[index-'a'];            
        }

        curr.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        char index; 

        for(int i=0;i<word.length();i++){

            index = word.charAt(i);
            if(curr.children[index -'a'] != null){
                curr = curr.children[index-'a'];
            }
            else{
                return false;
            }
        }

        if(curr.isEndOfWord){
            return true;
        }

        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char index; 

        for(int i=0;i<prefix.length();i++){

            index = prefix.charAt(i);
            if(curr.children[index -'a'] != null){
                curr = curr.children[index-'a'];
            }
            else{
                return false;
            }
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

class Solution {
    public static void main(String[] args){
        System.out.println("Trie implementation");
        Trie trie = new Trie();
        trie.insert("apple");
        //trie.insert("app");
        System.out.println(trie.startsWith("app"));        
    }
}