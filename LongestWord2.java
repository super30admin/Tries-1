/*
algorithm:
create Trie data sturcute for the string given in input

then, do bfs of the Trie by ietrating from right to left and adding nodes to the queue which have children and word is not null

finally return the curr nodes word as it will be the word of longest word with existing prefix

time complexity : O(mn)
space complexity: O(mn)
*/
class TrieNode{
    //boolean isEnd;
    String word;
    TrieNode[]children;
    TrieNode(){
      //  this.isEnd = false;
        this.children = new TrieNode[26];
        this.word = null;
    }
    
}
class LongestWord2 {
    TrieNode root = new TrieNode();
    public String longestWord(String[] words) {
        //base case
        if(words.length == 0){
            return "";
        }
        
        //add all words to Trie
        for(String word : words){
            insertInTrie(word);
        }
        
        //then do bfs start for the root
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        TrieNode curr = root;;
        while(!queue.isEmpty()){
            curr = queue.poll();
            
            for(int i = 25; i >=0 ;i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    queue.add(curr.children[i]);
                }
            }
        }
        
        return curr.word;
    }
    
    
    
    
    
    
    private void insertInTrie(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        
        curr.word = word;
            
    }
}