// Time Complexity = nl
// Space Complexity = O(1) 

class Solution {
    private String result;
    private TrieNode root;
    
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public String longestWord(String[] words) {
        root = new TrieNode();
        //result = new StringBuilder();
        result = "";
        for(String word:words){
            insert(word);
        }
        
        dfs(root, new StringBuilder());
        return result;
    }
    
    private void dfs(TrieNode root, StringBuilder sb){
        // base 
        if(sb.length() > result.length()){
            result = sb.toString();
        }
        
        // logic
        for(int i = 0 ; i < 26; i++){
            TrieNode curr = root.children[i];
            if(curr != null){
                char c = (char)('a' + i);
                int le = sb.length();
                sb.append(c);
                
                if(curr.isEnd){
                    dfs(curr, sb);
                }
                    
                sb.setLength(le);
                //sb.remove(sb.length() - 1);
            }
        }
    }
}
    
    
    
    