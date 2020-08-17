//Time Complexity O(n)
//Space Complexity O(1) since number of alphabets is constant in Trie. i.e. each TrieNode can have only 26 children

class TrieNode {
    boolean isEnd; //end of string
    TrieNode[] children; 
    
    public TrieNode() {
        children = new TrieNode[26];
    }
}
public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);            //get the the position to insert char
            if(cur.children[c - 'a'] == null){  //Check if there is already a character in the Trie
                cur.children[c - 'a'] = new TrieNode(); //If not, create a new node and insert the char
            }
            cur = cur.children[c - 'a']; // continue to next node
        }
        cur.isEnd = true;       //Mark last character as true after inserting string. We know that it is a word and not a prefix 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                return false;
            } 
            cur = cur.children[c - 'a'];
        }
        return cur != null && cur.isEnd;   //Check if we found word and not a prefix: Return last marked character
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c - 'a'] == null){  
                return false;       
            } 
            cur = cur.children[c - 'a'];
        }
        return true;	//No need to search for end flag.
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */