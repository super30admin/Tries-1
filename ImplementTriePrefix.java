/*
Time Complexity : O(N * Avg(length of the word))
Space Complexity : O(N * Avg(length of the word))
Idea : U Maintain a trie node and once reach the end of the word u mark it in a boolean variable.
Each trie Node is group of 26 TrieNodes which are filled according to character-'a' index.
The prefix is search if u don't encounter a null in path
The word is search if u reach isEnd boolean value.
*/
class Trie {
    
    TrieNode head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = head;
        for(char ch : word.toCharArray()){
            if(node.childrens[ch-'a'] == null){
                node.childrens[ch-'a'] = new TrieNode();
            }
            node = node.childrens[ch-'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = head;
        for(char ch : word.toCharArray()){
            if(node == null){
                return false;
            }
            node = node.childrens[ch-'a'];
        }
        return node==null?false:node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = head;
        for(char ch : prefix.toCharArray()){
            if(node == null){
                return false;
            }
            node = node.childrens[ch-'a'];
        }
       return node==null?false:true;
    }
}

class TrieNode {
    public TrieNode[] childrens;
    public boolean isEnd;
    
    public TrieNode(){
        this.childrens = new TrieNode[26];
        this.isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */