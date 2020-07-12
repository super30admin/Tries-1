// Time Complexity : inserting : O(nL) (n is number of words , with longest word length = L)
// searching : O(n), Total : O(nL)
// Space Complexity : O(nL)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    class TrieNode {
        //declare array of trieNode (trieChildren)
        TrieNode[] trieChildren; 
        //word upto the node added in each trienode
        String word; 
        
        //constructor
        public TrieNode() {
            //initialize trieChildren array of size 26 (lower case letters)
            trieChildren = new TrieNode[26];
        }
    }

    //declare a TrieNode root globally
    TrieNode root;
    public void insert(String word) {
        //insert func has a curr TrieNode variable pointing to root
        TrieNode curr = root;
        //for each character in word
        for(int i = 0; i < word.length(); i++) {
            //get the ith char
            char c = word.charAt(i);
            //check if that char is in Trie (if trieNode exists at that array position)
            //array[1] = a ; array[2] = b ... so on 
            //array position represents ascii value of letters
            //then the letter is present
            //if null letter does not exist
            //so create a new trieNode at that array position
            if(curr.trieChildren[c - 'a'] == null) {
                curr.trieChildren[c - 'a'] = new TrieNode();
            }
            //move curr pointer to add the. other letters of the word
            curr = curr.trieChildren[c - 'a'];
        } curr.word = word;  //make the word point to entire word in thr trie
    }

    
    public String longestWord(String[] words) {
        //initialize root 
        root = new TrieNode();
        //insert each word to trie
        for(String senWord : words) {
            insert(senWord);
        }
        //declare curr to null outside while to use in return
        TrieNode curr = null;
        //use queue to get longest word of trie
        Queue<TrieNode> q = new LinkedList<>();
        //add root to queue
        q.add(root);
        //while queue is not empty
        while(!q.isEmpty()) {
            //get front of queue
            curr = q.poll();
            //iterate through all the children from end 
            //to get longest word that is lexicographically small 
            //(we return last element of queue )
            for(int i = 25; i >= 0; i--) {   
                //check if curr char (trieNode) is present 
                //and is a word in dictionary by checking if it has a word associated with it
                //using curr.trieChildren[i].word != null
                //if both conditions suffice, add to queue
                if(curr.trieChildren[i] != null && curr.trieChildren[i].word != null) {
                    q.add(curr.trieChildren[i]);
                }
            }
        } return curr.word; //return last TrieNode of queue
        //it is longest and lexicographically smallest
    }
}

