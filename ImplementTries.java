class Trie {
 class TrieNode{
            boolean isEnd;
            TrieNode[] children;
         //   int count; // to count repeated words
           
            public TrieNode(){
               children = new TrieNode[26];
            }
        }
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {      
        root = new TrieNode();
    }
   
    /** Inserts a word into the trie. */
    public void insert(String word) {  //inserted length in O(L) 'L' is length of the word
        TrieNode curr = root;
        for(int i = 0 ;i < word.length() ;i++){
            char c = word.charAt(i);
            //children in my current trie node that character is  not present then insert
            if(curr.children[c-'a'] == null ){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'] ; //move the pointer
        }
        curr.isEnd = true; // after the entire word is finished the last node is set to true inorder not to allow partial word be true for example - get apple as true and app as not.
    }
   
    /** Returns if the word is in the trie. */
    public boolean search(String word) {  // O(L)
        TrieNode curr = root;
        for(int i = 0 ; i < word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c- 'a'] == null ) return false; // character not present
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd; // did the word end? if true means yes if false means no
    }
   
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {  // O(L)
      TrieNode curr = root;
        for(int i = 0 ; i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c- 'a'] == null ) return false; // character not present
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

/*
Time complexity: O(L) where L is length of the word
Space complexity: n is no of words in dictionary and L is avg length of the word then space used for computation is Trie hence O(nL)
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
