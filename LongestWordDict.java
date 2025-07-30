// Time Complexity : O(nl+nlogn)
// Space Complexity : O(nl)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
// Approach : add all words in dictionary to list. Sort words in descending order by length and lexicographic order
/// if length is same. For each word, check if all of it's substrings starting from index 0 are in the trie. If yes return the word

class Solution {
    public String longestWord(String[] words) {
        String res = "";
        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }
        Arrays.sort(words, (a,b)->{
            if(a.length()==b.length()){
                return a.compareTo(b);
            }
            return b.length()- a.length();
        });
        for(int i=0;i<words.length;i++){
            System.out.println(words[i]);
        }
        for(int i=0;i<words.length;i++){
            String word = words[i];
            boolean flag = true;
            for(int j=0;j<word.length();j++){
                if(!trie.search(word.substring(0,j+1))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res = word;
                break;
            }
        }
        return res;
    }
}
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