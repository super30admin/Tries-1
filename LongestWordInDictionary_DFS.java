//Problem 77: Longest Word in Dictionary
//Time Complexity:  O(number of words * average length of word)
//Space Complexity : O(Max len of word), height/depth of tree if consider recursive stack; 

/*
 Can be implemented using BFS or DFS
 DFS: Use for loop pattern. Iterate over children array and make recursive call if children at specific index is not null and children.isEnd = true. While making recursive call just pass children at specific index along with height + 1 and String Builder object appended with (char)(index + ascii of minimum character). While cominng back reverse the action that is backtrack remove the last character from the string builder.

 Once for loop traversal is done, just check if current height is greater than the global height just update the global height along with the result with string builder.toString();

*/

class Solution77DFS {
    
    class TrieNode{
           boolean isEnd; 
           TrieNode[] children;
        
	        TrieNode(){
	            children = new TrieNode[26]; //because there will be only 26 lowercase characters
	        }
    }
    
    TrieNode root;
    private int maxHeight;
    private String result;
    public String longestWord(String[] words) {
        
        if(words== null || words.length==0) return result;
        
        maxHeight = Integer.MIN_VALUE;
        root = new TrieNode();
        
        //create trie;
        //TC/SC: O(number of words * average length of word) 
        for(String s:words){
           buildTrie(s); 
        }
           
        //TC: O(number of words * average length of word) | SC: O(Max len of word), height of tree if consider recursive stack
        findMaxDepth(root,0,new StringBuilder());
        
        return result;
    }
    
    private void buildTrie(String s){
        
        TrieNode curr = root;
        for(char ch:s.toCharArray()){

            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            
            curr = curr.children[ch-'a'];
        }

        curr.isEnd = true;
    }
    
    private void findMaxDepth(TrieNode curr,int h, StringBuilder sb){
        
	        //logic
	        for(int i=0;i<curr.children.length;i++){
	            
	        	if(curr.children[i]!=null && curr.children[i].isEnd) {
                    sb.append((char)(i+'a'));
	        		findMaxDepth(curr.children[i],h+1,sb);
                    sb.setLength(sb.length()-1);
	        	}
	        	      
	        }
        
          if(maxHeight<h) {
	    		result = sb.toString();
	    		maxHeight = h;
	       }
    }
    
}