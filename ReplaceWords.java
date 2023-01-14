import java.util.List;
//Time Complexity : worst O(H), average O(1) where H is the number of nested lists
//Space Complexity :O(H) where H is the number of nested lists
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :
public class ReplaceWords {
	 class TrieNode{
	        boolean isEnd;
	        TrieNode[] childrens;
	        public TrieNode(){
	            childrens = new TrieNode[26];
	        }
	    }
	    TrieNode root;
	    
	    public void insert(String word) {
	        char[] arr = word.toCharArray();
	        TrieNode curr = root;
	        for(char c:arr){
	            int index = c-'a';
	            if(curr.childrens[index]==null){
	                curr.childrens[index] = new TrieNode();
	            }
	                curr = curr.childrens[index];
	            
	        }
	        curr.isEnd=true;
	    }
	    
	    public String replaceWords(List<String> dictionary, String sentence) {
	        this.root = new TrieNode();
	        
	        for(String word:dictionary){
	             insert(word);
	         }
	        
	        StringBuilder result = new StringBuilder();
	        
	        String[] words = sentence.split(" ");
	        
	        for(String word:words){
	            
	            char[] arr = word.toCharArray();
	            StringBuilder sb = new StringBuilder();
	            TrieNode curr = this.root;
	            
	            for(int i=0;i<arr.length;i++){
	                char c = arr[i];
	                if(curr.childrens[c - 'a']==null  || curr.isEnd ==true)   
	                    break;
	                sb.append(c);
	                curr = curr.childrens[c-'a']; 
	                   
	                }
	            if(curr.isEnd){
	                result.append(sb.toString());
	            }
	            else{
	                result.append(word);
	            }
	            result.append(" ");
	        }
	        return result.toString().trim();
	    }
}
