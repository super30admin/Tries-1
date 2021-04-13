// TC - O(n) -> number of words
// LC - 720
class Solution {
    // Create a class TrieNode
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            word = "";
        }
    }
    
    TrieNode root;
    String output = "";
    public String longestWord(String[] words) {
        root = new TrieNode();
        insert(words);
        TrieNode curr = root;
        dfs(curr);
        return output;
    }
    // Insert elements into trie datastructure
    // For every word, convert it to a charArray and check if character is null, if yes, we create a new TrieNode and curr will point there, at end we add true 
    private void insert(String[] words){
        for(String word : words){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.word = word;
        }
    }
    // going through 26 characters, if its a word and character is not null, we will be calling function dfs again and update output if node.word is greater than output.length
    private void dfs(TrieNode node){
        if(node.word.length() > output.length()){
            output = node.word;
        }
        
        for(int i=0; i<26; i++){
            if(node.children[i] != null && node.children[i].word != ""){
                dfs(node.children[i]);
            }
        }
        
    }
    
}