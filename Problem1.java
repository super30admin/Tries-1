//Time Complexity : O(n*l) + O(n*p); where n is the no. of insertions/operations, l is the length of the word, p is the length of the prefix.
//Space Complexity: O(n*l)
//Code run successfully on LeetCode.

public class Problem1 {

	class Trie {
	    
	    class TrieNode{
	        
	        TrieNode[] children;
	        boolean isEnd;  
	        
	        public TrieNode(){
	            children = new TrieNode[26];
	        }
	    }
	    
	    TrieNode root;

	    public Trie() {
	        
	        root = new TrieNode(); 
	    }
	    
	    public void insert(String word) {
	        
	        TrieNode curr = root;
	        
	        for(int i =0; i < word.length(); i++){
	            
	            char c = word.charAt(i);
	            
	            if(curr.children[c - 'a'] == null)
	                curr.children[c - 'a'] = new TrieNode();
	            
	            curr = curr.children[c - 'a'];
	        }
	        curr.isEnd = true;
	        
	    }
	    
	    public boolean search(String word) {
	        
	        TrieNode curr = root;
	        
	        for(int i =0; i < word.length(); i++){
	            
	            char c = word.charAt(i);
	            
	            if(curr.children[c - 'a'] == null)
	                return false;
	            
	            curr = curr.children[c - 'a'];
	        }
	        
	        return curr.isEnd;
	    }
	    
	    public boolean startsWith(String prefix) {
	        
	        TrieNode curr = root;
	        
	        for(int i =0; i < prefix.length(); i++){
	            
	            char c = prefix.charAt(i);
	            
	            if(curr.children[c - 'a'] == null)
	                return false;
	            
	            curr = curr.children[c - 'a'];
	        }
	        
	        return true;
	    }
	}
}
