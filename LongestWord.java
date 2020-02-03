/*
 * Time Complexity : O(m * n) for inserting and iterating through the characters
 * Space Complexity : O(m * n) where m is number of words and n is number of characters 
 */
class Solution {
    
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    
    TrieNode root = new TrieNode();
    
    public void insertNode(String s){
        TrieNode curr = root;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
                
               
            }
            curr = curr.children[c-'a'];
        }
        
        curr.word = s;
    }
    
    public String longestWord(String[] words) {
        
        for(String s : words){
            insertNode(s);
        }
        
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        
        TrieNode temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            
            for(int i = 25; i>= 0; i--){
                if(temp.children[i] != null && temp.children[i].word != null){
                    queue.add(temp.children[i]);
                }
            }
        }
        
        return temp.word;
        
    }
    
    
}