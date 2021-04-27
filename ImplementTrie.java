    /*
     *  Time Complexity: O(N*M) Where N is the number of words and M is the average length of words.
     *  Space Complexity: O(N*M) Where N is the number of words and M is the average length of words.
     *
     *  Did this code successfully run on Leetcode : Yes
     *  Any problem you faced while coding this : None
     *
     *  Explanation: We solve the problem by building a trie datasturcture, which consists of an array of length 26 representing all the lower case alaphabets and a boolean isEnd wihch represents the end of the word. To insert word into trie datastructure, we start with searching the first character in root node children, if it does not exists we create a new node and place it in the children, else if it exists we move our current pointer to that trie node and search for the second character. We repeat this till that last character, and when we reach the last character we make the isEnd boolean true representing the one word has ended at that TrieNode. Now once the word is stored, searching for the word or the prefix would be simple as we keep checking for each character from the root node until we find the last character.
     */

class Trie {

    /** Initialize your data structure here. */
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.isEnd = isEnd;
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a']==null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.isEnd==true? true:false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(node.children[ch-'a']==null){
                return false;
            }
            node = node.children[ch-'a'];
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
