//Time complexity:O(n*l)
//Space Complexity:O(n*l) - height of trie, the longest word length
//Create a trie datastructure, use dfs to explore
class Solution {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
        private void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    String result ="";
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for(String word: words){ //O(n*l)
            insert(word);
        }
        dfs(root, new StringBuilder()); //O(n*l)
        return result;
    }

    private void dfs(TrieNode curr, StringBuilder s){
        //base case
    if(result.length() < s.length())
        result = s.toString();
    
        for(int l =0;l<26;l++){
            if(curr.children[l]!=null && curr.children[l].isEnd){
                int len = s.length(); 
                s.append((char)(l+'a')); //action: convert trie index to char and add 
                dfs(curr.children[l],s); // recurse
                s.setLength(len) ;//backtrack
            }
            
        }
    }
}