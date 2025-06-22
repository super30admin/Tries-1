/*
 * TC: O(n) for insert,PrefixSearch and search.
 * SC: O(n*m)  n:no of words in the trie, m: avg length of the words in trie.
 * 
 * Approach: WIll create TrieNode class to store each node and associated children.
 * Insertion:  iterate thorugh the char of the word and check of the children is not present then initiate it.
 * Search: Iterate though the char of the word and if at any iteration the elments in the associated index of the charf is null then return false.
 * Prefix: same as search. 
 */

class TrieNode{
    boolean isEndWord;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) { //O(n)
        TrieNode curr = root;

        for(int i = 0; i< word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
      curr.isEndWord = true;
    }
    
    public boolean search(String word) { //O(n)
        TrieNode curr = root;

        for(int i =0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isEndWord;
    }
    
    public boolean startsWith(String prefix) { //O(n)
        TrieNode curr = root;

         for(int i =0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if(curr.children[index] == null) return false;

            curr = curr.children[index];
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