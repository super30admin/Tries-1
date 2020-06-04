// Time Complexity : Insert -> O(n), search -> O(n), StartWith -> O(n) where n is the number of length of the string
// Space Complexity : O(n) where  n is the number of Trie Nodes 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Implement using an Array. Create a Trie Node with isEnd variable to mark the existance
of a word and children array to mark the child nodes of the parent node (the word will be structured in a heirarchical way). For the Insert operation,
goto the appropriate index of the array and create a new trienode there to store the next letters of the word. If the letter already exists in form of a node,
you need to traverse through the prefix, and create the node where the letter node hasn't been created. For the search and StartsWith function, they
work in the same way where you have to start searching from the root to the depth by traversing the non null nodes and matching the characters, if not
matching => return falese else true.
*/
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){                                                                                     // Creating a Trie Node
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
    TrieNode head;
    public Trie() {
        root = new TrieNode();                                                                          // Root of the trie node
        head = root;
        }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = head;
        for(int i = 0; i < word.length(); i++){                                                                 // Traverse the word
            if(root.children[word.charAt(i) - 'a'] == null){
            root.children[word.charAt(i) - 'a'] = new TrieNode();                                           // Create a node of the letter if non existing
            }
            root = root.children[word.charAt(i) - 'a'];                                                 // Move to the newly created letter to create further nodes for non exitent letters
        }
        root.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        root = head;
        for(int i = 0; i < word.length();i++){
            if(root.children[word.charAt(i) - 'a'] == null){return false;}                              // Search for the letter node, if it is null. return false
            root = root.children[word.charAt(i) - 'a'];
        }
        if(root.isEnd == true){                                                                     // As you reach end of the word, check if isEnd is true => word is existant
        return true;
        } else {
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        root = head;
        for(int i = 0; i < prefix.length(); i++){
            if(root.children[prefix.charAt(i) - 'a'] == null){                                      // If prefix is non existant, return false
                return false;
            }
            root = root.children[prefix.charAt(i) - 'a'];                                       // Traversing the trie nodes
        }
        return true;
    }
}
