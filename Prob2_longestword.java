// n - words in disctionary, k = Avg. Length of words in disctionary, 

// Time Complexity : O(N*K)
// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        String w;
        public TrieNode(){
            children = new TrieNode[26];
            w = new String();
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root; 
        for(int c = 0; c< word.length(); c++){
            char ch = word.charAt(c);
            if(curr.children[ch - 'a'] == null){ 
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.w = word; // at every end of word, we set the value of TrieNode's word variable
        curr.isEnd = true; 
    }
    
    //BFS Solution
    public String longestWord(String[] words) {
        root = new TrieNode();
        Queue<TrieNode> queue = new LinkedList<>();
        
        for(String s : words){ // Inserted words in Dictionary first
            insert(s);
        }
        
        TrieNode curr = null;
        queue.add(root);
        while(!queue.isEmpty()){ //Start exploring children from root 
            curr = queue.poll();
            //Traversing from z to a for lexicographical order  
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].isEnd ){ // If children is not null and isEnd is true for that children, add it into the queue
                    queue.add(curr.children[i]);
                }
            }
        }
        
       
        return curr.w;       //Return the word of last current node       
    }
    
   
}


/*
//DFS


class Solution {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        char ch;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root; 
        for(int c = 0; c< word.length(); c++){
            char ch = word.charAt(c);
            if(curr.children[ch - 'a'] == null){ 
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
            curr.ch = ch;    
        }
        curr.isEnd = true; 
    }
    int max;
    String result;
    public String longestWord(String[] words) {
        root = new TrieNode();
        result = new String();
        
        for(String s : words){ // Inserted words in Dictionary first
            insert(s);
        }
        backtrack(root, new StringBuilder()); // Calling DFS on root
        return result;              
    }
    
    public void backtrack(TrieNode root, StringBuilder path){
        
        if(path.length() > max){ //When we get string of length > max then update the result string
            max = path.length();
            result = path.toString();
        }
        
        
        for(int i = 0; i < 26; i++){ // For each children
            if( root.children[i] != null && root.children[i].isEnd ){ // If children is not null and isEnd is true for that children
                //Action 
                path.append(root.children[i].ch);   //append cuurent node's character to result
                
                //Recursion
                backtrack(root.children[i], path); // call recursively for that children
                
                //Backtrack
                path.setLength(path.length() - 1); //Then Remove char from string 
            } 
        }
    }
}

*/