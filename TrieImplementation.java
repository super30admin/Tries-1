// Time Complexity: O(L) for both insert and search where L is on average number of characters in word, if we add many words => O(W*L)
// Space Complexity: This is an optimization of space Worst case is Length of key or O(num of words * Length of word * 26)
// Write your approach here
// Idea here is to use TrieNodes which have array of 26 as child characters
// For inserting we check if for first character of word exists on root's first child,
// if not, we need to add a new TrieNode and make new node current
// and continue until the word is not parsed, at the end we make current's end true
// to search we traverse through word and check if at each level the character exists
// for parent TrieNode, if not we return false else on traversal completion if end
// is true return true, else false
// for prefix search, we traverse through prefix and check if trie contains those characters, if not return false else return true
class Trie {
    
    class TrieNode {
        TrieNode [] children;
        boolean endOfWord;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i< prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c-'a']==null) return false;
            curr = curr.children[c-'a'];
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