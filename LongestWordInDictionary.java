// Time Complexity : O(n*c)
// Space Complexity : O(n*c)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We create a class TrieNode to keep track of the different possible words.
    We do a BFS search in the reverse lexicographical order.
    Thereby the last word would be the largest word with the smallest lexicographical order. 
*/

class Solution {
    
    class TrieNode{
        TrieNode [] children;
        boolean isEnd;
        String path;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    public void insert(String word){
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++){
            if (curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
        curr.path = word;
    }
    
    public String longestWord(String[] words) {
        
        root = new TrieNode();
        
        for (String word : words) insert(word);
        
        Queue<TrieNode> q = new LinkedList<>();
        
        q.add(root);
        
        String result = "";
        
        while (!q.isEmpty()){
            
            TrieNode node = q.poll();
            for (int i=25; i>=0; i--){
                if (node.children[i] != null && node.children[i].isEnd){
                    q.add(node.children[i]);
                }       
            }
            if (node.isEnd && node.path.length() >= result.length()) result = node.path;
        }
        
        return result;
    }
}