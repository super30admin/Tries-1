class Trie {

    /** Initializing the Trie data structure */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Traverse through the trie starting from root node.
    * 1. Initially let's say the index at given word is zero.
    * 2. If the character at current index is not present at the current Trie node, create a new Trie node for that character. 
    * 3. Next move forward to the TrieNode at current index.
    * 4. Increment the current index of the word.
    * 5. Repeat process from step2 until end of the word is reached.
    * 6. At the end, set the boolean flag, "wordEnd" to true.
    
    * Time complexity - O(N) - N is length of the given word
    * Space complexity - O(1) - constant
    */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                 curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.setWordEnd(true);
    }
    
    /** Check for the presence of each character in the word by traversing through the Trie starting from the root node
    * Return false if any of the characters is not present in the Trie.
    * If all characters are present in the Trie, when we reached the end, return the boolean flag wordEnd corresponding to the last TrieNode. 
    *
    * Time complexity - O(N) - N is length of the given word
    * Space complexity - O(1) - constant 
    */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] != null){
                 curr = curr.children[ch-'a'];
            } else {
                return false;
            }
        }
        
        return curr.getWordEnd();
    }
    
    /** Check for the presence of each character in the word by traversing through the Trie starting from the root node
    * Return false if any of the characters is not present in the Trie.
    * Return true if all the characters are present in the Trie. 
    
    * Time complexity - O(N) - N is length of the given prefix
    * Space complexity - O(1) - constant
    */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return true;
        }
        
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] != null){
                 curr = curr.children[ch-'a'];
            } else {
                return false;
            }
        }
        
        return true;
    }
}

/** Structure of the TrieNode */
class TrieNode{
    TrieNode[] children;
    boolean wordEnd;
    TrieNode(){
        children = new TrieNode[26];
        wordEnd = false;
    }
    public void setWordEnd(boolean value){
        wordEnd = value;
    }
    public boolean getWordEnd(){
        return wordEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */