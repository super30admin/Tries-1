package Tries1;
//TC - o(nk + L) L is length of sentence, nk is for building the trie with k as length of word.
//SC - o(nk + L) same as TC
public class ReplaceWords {
	 class TrieNode{
	        boolean isEnd;
	        TrieNode[] children;
	        
	        public TrieNode(){
	            this.children = new TrieNode[26];
	        }
	    }
	    
	    TrieNode root;
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode curr = root;
	        for(int i=0; i< word.length(); i++){
	            char c = word.charAt(i);
	            if(curr.children[c - 'a'] == null){
	                curr.children[c - 'a'] = new TrieNode();
	            }
	            curr = curr.children[c - 'a'];
	        }
	        curr.isEnd = true;
	    }
	    
	    
	    public String replaceWords(List<String> dictionary, String sentence) {
	        root = new TrieNode();
	        for(String word : dictionary){
	            insert(word);
	        }
	        StringBuilder result = new StringBuilder();
	        String[] splitArray = sentence.split("\\s+");
	        for(int k=0; k< splitArray.length; k++){
	            if(k>0) result.append(" ");
	            String word = splitArray[k];
	            StringBuilder replace = new StringBuilder();
	            TrieNode curr = root;
	            for(int i=0; i<word.length(); i++){
	                char c = word.charAt(i);
	                if(curr.children[c-'a'] == null || curr.isEnd) break;
	                curr = curr.children[c-'a'];
	                replace.append(c);
	            }
	            if(curr.isEnd){ // prefix found
	                result.append(replace);
	            }else{ // corresponding prefix not found
	                result.append(word);
	            }
	        }
	        return result.toString();
	    }
	}
}
