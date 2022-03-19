// Time Complexity : O(sum of wi) where wi is length of ith word 
// Space Complexity : O(sum of wi)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create a Trie, insert all the words in the trie
//now use dfs to traverse through the trie
//Return when end is not true or the node doesn't exist
//Check everytime if the current word is greater than the one stored in ans string
//Keep updating the ans string and finally return the string.
class Solution {
    String ans = "";
    public String longestWord(String[] words) {
        Trie tr = new Trie();
        for(String word: words){
            tr.insert(word);
        }
        dfs(tr.root);
        return ans;
    }
    public void dfs(TrieNode root){
        if(root == null || root.end == false)
            return;
        if(root.word.length() > ans.length())
            ans = root.word;
        for(int i = 0; i < 26; i++){
            dfs(root.children[i]);
        }
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
        root.end = true;
        root.word = "";
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;
        node.word = word;
    }
}

class TrieNode{
    TrieNode children[];
    String word;
    boolean end;
    TrieNode(){
       children = new TrieNode[26];
    }
}