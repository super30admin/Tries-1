class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        String finalWord;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
        curr.finalWord = word; // maintain word in TrieNode after inserting letter by letter
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        String result = "";
        for(String word: words){
            insert(word); // insert all the words in TrieNode
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()){  //BFS
            curr = q.poll();
            for(int i=25; i>=0; i--){
                if(curr.children[i]!= null && curr.children[i].isEnd){  // break when its not end; its not going to be longest word
                    q.add(curr.children[i]);
                }
            }
        }
        
        if(curr.finalWord == null) return "";
        
        return result = curr.finalWord;  //return last traversal's word
    }
    
}
