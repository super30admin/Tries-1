
// Time Complexity: O(N) for insert, search and startsWith where N is the length of the word or prefix.
// Space Complexity: O(1) as the size of the children array is constant (26 for lowercase English letters).


// We create a TrieNode class to represent each node in the Trie. 
// Each node contains an array of children nodes and a boolean flag to indicate if it marks the end of a word.

//to insert a word, we traverse the Trie according to the characters in the word, creating new nodes as necessary and marking the end of the word to true.
// To search for a word, we traverse the Trie according to the characters in the word and check if we reach a node that marks the end of a word.
// To check if a prefix exists, we traverse the Trie according to the characters in the prefix and check if we can reach the end of the prefix.

class Trie {
    TrieNode root;
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        TrieNode(){
            this.children=new TrieNode[26];
        }
    }

    public Trie() {
        this.root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a']==null)
                return false;
            curr=curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char c:prefix.toCharArray()){
            if(curr.children[c-'a']==null)
                return false;
            curr=curr.children[c-'a'];
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