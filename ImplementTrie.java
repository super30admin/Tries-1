// Time Complexity : insert, search and starts with =  O(l) l=avg length of word
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : no
// Approach : create trienode with isEnd flag and children (array of 26 trie nodes representing 26 alphabets)
/// For insert, we add each char to trie and set isEnd as true for last char. In search, we similarly traverse through length
/// of word and if last char has isEnd true then we found it else no/ 

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.children[ch-'a']==null){
                ptr.children[ch-'a'] = new TrieNode();
            }
            ptr = ptr.children[ch-'a'];
        }
        ptr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.children[ch-'a']==null){
                return false;
            }
            ptr = ptr.children[ch-'a'];
        }
        return ptr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(ptr.children[ch-'a']==null){
                return false;
            }
            ptr = ptr.children[ch-'a'];
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