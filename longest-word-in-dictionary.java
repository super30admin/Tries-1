// Run time: O(total chars)
// insert -> O(all chars in array)
// dfs: -> O(total chars)


//Space: O(max depth + total unique prefixes + total unique siffixes)
// dfs: O(max depth)
// trie insert:  O(total unique prefixes + total unique siffixes)



class Solution {
  private TrieNode root;
  private String output = "";
    class TrieNode{
      TrieNode[] children;
      String word;
     TrieNode(){
      children = new TrieNode[26];
      word = "";
    }
  }
  
  private void insert(String[] words){
    for(String word:words){
      TrieNode curr = root;
      for(char ch:word.toCharArray()){
        if(curr.children[ch-'a'] == null){
          curr.children[ch-'a'] = new TrieNode();
        }
        curr = curr.children[ch - 'a'];
      }
      curr.word = word;
    }
  }
    
  private void dfs(TrieNode node){
    
    if(node.word.length() > output.length()){
      output = node.word;
    }
    
    for(int i=0;i<26;i++){
      if(node.children[i] != null && node.children[i].word != ""){
        dfs(node.children[i]);
      }
    }
  }
  public String longestWord(String[] words) {
        
      if(words.length == 0 || words == null) return words[0];
      root = new TrieNode();
      insert(words);
      dfs(root);
      return output;
      
    }
}

