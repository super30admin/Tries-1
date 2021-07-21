// Time Complexity: insert -> O(L) where L is the length of the word
//                  search -> O(L)
//                  prefix -> O(L)
// Space Complexity: insert -> O(L)
//                   search -> O(1)
//                   prefix -> O(1)
// Run on Leetcode: Yes
// Issues faced: Overly complecated the code for insert.

class TrieNode{
        boolean isEnd = false;
        TrieNode[] children = null;
        TrieNode(boolean isEnd){
            this.isEnd = isEnd;
        }
        TrieNode(boolean isEnd, TrieNode[] children){
            this.isEnd = isEnd;
            this.children = children;
        }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode(false, new TrieNode[26]);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                if(i == word.length()-1)
                    node.children[c-'a'] = new TrieNode(true, new TrieNode[26]);
                else
                    node.children[c-'a'] = new TrieNode(false, new TrieNode[26]);
            }
            node = node.children[c-'a']; 
        }
        node.isEnd = true;
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a'] == null)
                return false;
            node = node.children[c-'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c-'a'] == null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}
