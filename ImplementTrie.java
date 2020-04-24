// 208.

class TrieNode {
        boolean isWord; //set to true to mark end of word
        TrieNode[] children;
        
        public TrieNode(boolean isWord, TrieNode[] children) {
            this.isWord = isWord;
            this.children = children;
        }
}
    

class Trie {
        
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(false, new TrieNode[26]);
    }
    
    //time - O(length of word)
    //space - O(length of largest word that is in the dict)
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root; 
        for(int i = 0; i < word.length(); i++)
        {
            char current = word.charAt(i); //get the current char and check if it has an entry
            if(temp.children[current - 'a'] == null)
            {
                temp.children[current - 'a'] = new TrieNode(false, new TrieNode[26]); //if not create one
            }
            temp = temp.children[current - 'a']; //move to the next layer
        }
        temp.isWord = true;
        return;
    }
    
    //time - O(length of word)
    //space - O(1)
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++)
        {
            char current = word.charAt(i); //get the current char and check if it has an entry
            if(temp.children[current - 'a'] == null)
            {
                return false; //if not return false
            } 
            temp = temp.children[current - 'a']; //move to the next layer
        }
        return temp.isWord; //check and return true if the current node is a word
    }
    
    //time - O(length of prefix)
    //space - O(1)
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char current = prefix.charAt(i); //get the current char and check if it has an entry
            if(temp.children[current - 'a'] == null)
            {
                return false; //if not return false
            }
            temp = temp.children[current - 'a']; //move to the next layer
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
