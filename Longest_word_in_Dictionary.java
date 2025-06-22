/*
 * TC: O(m*n) (Insertion) + O(n) (Search) + O(n) (dfs), m: no. of words in words[], n: avg length of the word in words[].
 * SC: O(n) n: max length of the word in words[].
 * 
 * Approach: insert words into Trie. Perform DFS on the trie. At each recursive call, i will keep on updating my result if i get 
 * the word longer then the one existing in result
 */

class TrieNode{
    TrieNode[] children;
    String word;

    public TrieNode(){
        this.children = new TrieNode[26];
    }
}


class Solution {
    TrieNode root;
    String result = "";
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for(int i = 0; i< words.length; i++){
            insertWord(words[i]);
        }
        dfs(root);
     return result;
    }


    private void insertWord(String word){
        TrieNode curr = root;
        for(int i = 0; i< word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
      curr.word = word;
    }

    private void dfs(TrieNode node){
        if(node == null) return;

        if(node.word != null){
            if(node.word.length() > result.length()) result = node.word;
        }

        //recurse
        for(TrieNode child: node.children){
            if(child != null && child.word != null) dfs(child);
        }
    }
}