class Solution {
    class TrieNode{
        String word;
        TrieNode[] Children;
        
        public TrieNode(){
            Children = new TrieNode[26];
        }
    }
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.Children[c - 'a'] == null){
                System.out.println( c - 'a');
                curr.Children[c - 'a'] = new TrieNode();     
            }
            curr = curr.Children[c - 'a'];
        }
        curr.word = word;
        
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String s : words){
            insert(s);
        }
        TrieNode curr = null;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int j = 25; j >= 0; j--){
                if(curr.Children[j] != null && curr.Children[j].word != null){
                    q.add(curr.Children[j]);
                }
            }
            
        }
        return curr.word;
        
    }
}
