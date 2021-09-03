
// Time Complexity : O(1)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach:
1) In this question we implement the trieNode
2) in trieNode every trieNode will have 26 characters array and null assigned initially.
3) as we fill characters, we check if it exists or not, if already exists, then we just start from that characters and go check another character.
4) If not, we first create a trieNode each time we find the children are null(no characters exists till now)

-> for search
1) we start our search from rootNode.
2) if the children exists then we can search them, if not we know it does not exist, we return false.
3) we keep moving the current to the children

-> for startsWith
1) point to root Node
2) if we dont find children of the node present, we just return false
3) we keep moving the pointer to the children.
4) if we reach till the end, we return true
*/

import java.util.*;
class ImplementTrie {
    
    class TrieNode{
        
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode()
        {
            // initialize the Node with capacity 26
            children = new TrieNode[26];
            
            
        }
        
    }
    TrieNode root;
    
    
    /** Initialize your data structure here. */
    public ImplementTrie() {
        
        root = new TrieNode();// root node is created with capacity 26
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        // place the current pointer at the root level
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            // select every character
            char c = word.charAt(i);
            // if the children of the character does not exist
            if(curr.children[c-'a']==null)
            {
                // we create another trieNode for that children
                curr.children[c-'a'] = new TrieNode();
            }
            // shift our pointers to the current Node
            curr= curr.children[c-'a'];
                
            
        }
        // when we have reached to the end, we mark isEnd as true
        curr.isEnd=true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        // we start along the start Node
        TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            
            // if the children exists then we can search them, if not we know it does not exist, we return false.
            if(curr.children[c-'a']==null)
            {
                return false;
            }
            
            // we keep moving the current to the children
            curr = curr.children[c-'a'];
        }
        
        // we return isEnd is true or false.
        return curr.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        // point to the root Node 
        TrieNode curr = root;
        
        for(int i=0;i<prefix.length();i++)
        {
            char c = prefix.charAt(i);
            
            if(curr.children[c-'a']==null)
            {
                return false;
            }
            
            //keep moving the curr pointer
            curr = curr.children[c-'a'];
        }
        
        // return true as we have managed to reach the end.
        
        return true;
    }
}
