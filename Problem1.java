// Time Complexity :
//   insert - O(L)
//   search - O(L)
//   startswith - O(m)
//      L: length of the word
//      m: length of the prefix
// Space Complexity :
//   insert - O(L)
//   search - O(1)
//   startswith - O(1)
//      L: length of word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Trie {
    // class defintion
    class TrieNode{
        
        // significes end of the word
        boolean isEnd;
        TrieNode[] children;
        
        TrieNode(){
            // for a-z
            children = new TrieNode[26];
        }
    }

    // root of the trie
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {

        // initialize
        TrieNode current = root;
        // iterate word
        for(int i=0; i<word.length(); i++){
            // Mapping index:[a-z] -> [0-25]
            int index = word.charAt(i) - 'a';
            // not present
            if(current.children[index] == null)
                current.children[index] =  new TrieNode();
            // next 
            current = current.children[index];
        }
        // end of word
        current.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        // initialize
        TrieNode current = root;
        // iterate length
        for(int i=0; i<word.length(); i++){

            // Mapping index:[a-z] -> [0-25]
            int index = word.charAt(i) - 'a';
            // not present
            if(current.children[index] == null) return false;   
            current = current.children[index];
        }
        // all are present and also is end of word
        return current.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        // initialize
        TrieNode current = root;

        // iterate prefix
        for(int i=0; i<prefix.length(); i++){
            // Mapping index:[a-z] -> [0-25]
            int index = prefix.charAt(i) - 'a';

            // not present
            if(current.children[index] == null) return false; 
            current = current.children[index];
        }
        // all are present
        return true;
    }
    public static void main() {
        //Your Trie object will be instantiated and called as such:
        Trie obj = new Trie();
        String word = "apple";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        System.out.println("Searched for word "+word+" :"+ param_2);
        String prefix = "app";
        boolean param_3 = obj.startsWith(prefix);
        System.out.println("Searched for prefix "+prefix+" :"+ param_3);

    }
}

