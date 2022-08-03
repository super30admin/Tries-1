//Time Complexity: O(n*l); where n is no. of final length words & l is their length.
//Space Complexity: O(n*l)
//Code run successfully on LeetCode.


public class Problem2_DFS {

    StringBuilder result = new StringBuilder();
    
    class TrieNode{
        
        TrieNode[] children;
        boolean isWord;
        String word;
        
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    
    private void insert(String word){
        
        TrieNode curr = root;
        
        for(int i =0; i< word.length(); i++){
            
            char c = word.charAt(i);
            
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            
            curr = curr.children[c - 'a'];
            curr.word = String.valueOf(c);
        }
        
        curr.isWord = true;
    }
    
    public String longestWord(String[] words) {
        
        for(String word : words)
            insert(word);
        
        dfs(root, 0, new StringBuilder());
        
        return result.toString();
    }
    
    private void dfs(TrieNode root, int lvl, StringBuilder path){
        
       if(path.length() > result.length())
       {
           result.delete(0, result.length());
           result.append(path);
       }
        
        for( int i =0; i <=25; i++){
            
            if(root.children[i] != null && root.children[i].isWord == true){
                
                path.append(root.children[i].word);
                dfs(root.children[i], lvl +1, path);
                path.delete(path.length() -1, path.length());
            }
        }
        return;
    }
}
