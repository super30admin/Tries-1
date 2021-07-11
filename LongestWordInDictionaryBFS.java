//Time Complexity - O(nl) (n-number of words l-length of the word)
//Space Complexity - 


/** inserting given list of words in trie data structure
    then at the end of the word keep the track of word with the help of variable
    using q we will so BFS traversal on Trie structure. 
    If there is a word at the node then only we will add the node to the queue
    the last word comes out of queue is longest word **/


class Solution {
    class TrieNode{
      TrieNode[] children;
      String word;
      public TrieNode() {
        children = new TrieNode[26];
      }
    }
    TrieNode root;
  //insert word in the trie
    private void insert(String word) {
      TrieNode currNode = root;
      for(int i = 0; i< word.length(); i++) {
        char c = word.charAt(i);
        if(currNode.children[c-'a'] == null) {
          currNode.children[c-'a'] = new TrieNode();
        }
        currNode = currNode.children[c-'a'];
      }
      currNode.word = word;
    }
    public String longestWord(String[] words) {
      root = new TrieNode();
      for(String word : words) {
        insert(word);
      }
        
      Queue<TrieNode> q = new LinkedList<>();
      q.add(root);
      TrieNode curr = root;
      while(!q.isEmpty()) {
        curr = q.poll();
        for(int i =25; i>=0;i--) {
          if(curr.children[i] != null && curr.children[i].word != null) {
            q.add(curr.children[i]);
          }
        }
      }
      if(curr.word == null) {
        return "";
      }
      return curr.word;
    }
  
}