/*
Time Complexity : O(N*avarage length of word)
Space COmplexity : O(Length of word)
Idea : We insert each word in the trie . By construction the trie will be lexographicaly ordered
we do bfs to find the longest word or the word at last level of this trie starting from the first letter
*/
class Solution {
    class TrieNode{
        TrieNode[] childrens;
        String word;
        
        public TrieNode(){
            this.childrens = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word){
        TrieNode node = root;
         for(char ch : word.toCharArray()){
             if(node.childrens[ch-'a'] == null){
                 node.childrens[ch-'a'] = new TrieNode();
             }
             node = node.childrens[ch-'a'];
         }
        node.word = word;
    }
    public String longestWord(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
       for(String word : words){
           insert(word);
       }
       Queue<TrieNode> queue = new LinkedList<>();
       queue.add(root);
       TrieNode curr = queue.peek();
       while(!queue.isEmpty()){
           curr = queue.poll();
           for(int i=25;i>=0;i--){
               if(curr.childrens[i] != null && curr.childrens[i].word != null){
                   queue.add(curr.childrens[i]);
               }
           }
       }
        return curr.word;
    }
}