

public class Trie {
	 Node head;
	    class Node{
	        
	        boolean isEnd;
	        Node [] children;
	        
	        Node(){
	            children=new Node[26];
	        }
	    }

	    public Trie() {
	        Node start= new Node();
	            this.head=start;
	    }
	    
	    public void insert(String word) {
	        Node curr=head;
	        
	        for( int i=0;i<word.length();i++){
	            
	            if(curr.children[word.charAt(i)-'a']!=null){
	                curr=curr.children[word.charAt(i)-'a'];
	            }else{
	                curr.children[word.charAt(i)-'a']= new Node();
	                curr=curr.children[word.charAt(i)-'a'];
	            }
	            
	        }
	        curr.isEnd=true;
	        
	    }
	    
	    public boolean search(String word) {
	      Node curr=head;
	        for( int i=0;i<word.length();i++){
	            
	             if(curr.children[word.charAt(i)-'a']!=null){
	                 curr=curr.children[word.charAt(i)-'a'];
	                 if(i==word.length()-1&&curr.isEnd){return true;}
	             }else{
	                 return false;
	             }
	            
	        }
	        
	        return false;
	    }
	    
	    public boolean startsWith(String prefix) {
	        
	         Node curr=head;
	        for( int i=0;i<prefix.length();i++){
	            
	             if(curr.children[prefix.charAt(i)-'a']==null){
	                 
	                return false;
	             }else{
	                 curr=curr.children[prefix.charAt(i)-'a'];
	             }
	        
	        
	    }
	        
	        return true;
	}
}
