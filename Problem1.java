/*

Big O: Time -> O(N) for insert and search, where N is length of the word
Space-> O(N), where N is # of characters in the word

Passed All Test Cases 

Implementation using HashMap
*/

public class TrieNode {
    public char label ;   //for storing characters
    public HashMap<Character, TrieNode> child ;  //each node char maps another node
    public boolean isLeaf ;                  //to determine when we reach the end of the Trie
    
    TrieNode() {
        this.label = label ; 
        this.child = new HashMap<>() ; 
        this.isLeaf = false ; 
    }
}

class Trie {
    
    //the root of the tree
    public TrieNode root ; 
    /** Initialize your data structure here. */
    public Trie() {
        //initializing the root
        this.root = new TrieNode() ; 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //getting the root's child
        HashMap<Character, TrieNode> kid = root.child ; 
        for(int i = 0 ; i < word.length() ; i++) {
            char add = word.charAt(i) ;
            TrieNode wordNode = new TrieNode(); 
            if(!kid.containsKey(add)) {
                wordNode.label = add ; 
                kid.put(add, wordNode) ; 
            }else
            {
               wordNode = kid.get(add) ; 
            }
            
            //to mark the end of the trie
            if(i == word.length() - 1)
                wordNode.isLeaf = true ; 
            kid = wordNode.child ; 
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        HashMap<Character, TrieNode> kid = root.child ; 
        for(int i = 0 ; i < word.length() ; i++) {
            char check = word.charAt(i) ;
            TrieNode s = new TrieNode() ; 
            if(kid.containsKey(check)) {
                s = kid.get(check) ; 
            } else
                return false ; 
            kid = s.child ; 
            if(i == word.length() - 1 && (s.isLeaf))
                return true ; 
        }
        
        return false ; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
           HashMap<Character, TrieNode> kid = root.child ; 
        for(int i = 0 ; i < prefix.length() ; i++) {
            char check = prefix.charAt(i) ;
            TrieNode s ; 
            if(kid.containsKey(check)) {
                s = kid.get(check) ; 
            } else
                return false ; 
            kid = s.child ; 
    }
        return true ; 
}
}



/*

Big O:
Time -> Search and Insert O(N), N is # of characters in a word
Space -> O(1)

Passed All Test Cases 

Implementation with Array 
More Space Efficient than the one with hashmap.

*/





class Trie {
    class TrieNode {
        boolean isLeaf ; 
        TrieNode [] kid ; 
        TrieNode() {
            this.isLeaf = false ; 
            kid = new TrieNode [26] ; 
        }
    }
    /** Initialize your data structure here. */
        TrieNode root ; 
        Trie() {
            root = new TrieNode() ; 
        }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root ;
        for(int i = 0 ; i < word.length() ; i++) {
            char add = word.charAt(i) ; 
            if(curr.kid[add - 'a'] == null)
                curr.kid[add - 'a'] = new TrieNode() ; 
             curr = curr.kid[add - 'a'] ; 
        }
                curr.isLeaf = true ; 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode  t = root ; 
        for (int i = 0 ; i < word.length() ; i++) {
            char check = word.charAt(i) ; 
            if(t.kid[check - 'a'] == null) return false ; 
            t = t.kid[check - 'a'] ; 
        }
        
        if(t.isLeaf) return true ; 
        else
            return false ; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
           TrieNode  t = root ; 
        for (int i = 0 ; i < prefix.length() ; i++) {
            char check = prefix.charAt(i) ; 
            if(t.kid[check - 'a'] == null) return false ; 
            
            t = t.kid[check - 'a'] ; 
        }
         return true ; 
    }
}