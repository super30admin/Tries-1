/*
Space Complexity: Space occupied by the Trie
Time Complexity: (m*n) ~ O(n) ~ Linear
where m-> number of words
      n-> length of the words
*/

class Trie {
    //creating TrieNode
    class TrieNode{
        boolean isEnd;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(){};
    }
    /** Initialize your data structure here. */
    //root
    TrieNode root = new TrieNode();
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        //initially curr points to root
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            //if character doesnot exist, create new TrieNode
            if(curr.children[c - 'a'] == null)
            {
                curr.children[c - 'a'] = new TrieNode();
            }
            //increment curr after each iteration
            curr = curr.children[c - 'a'];
        }
        //after inserting the word completely, set isEnd to true
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            //if the character doesnot exist -> return false
            if(curr.children[c-'a'] == null){
                return false;
            }
            else{
                //keep incrementing
                curr = curr.children[c-'a'];
            }
        }
        //return whatever value of isEnd
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            else{
                curr = curr.children[c-'a'];
            }
        }
        //has prefix
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