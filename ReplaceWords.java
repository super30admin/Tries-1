

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No



import java.util.*;

public class ReplaceWords {
	
	
	TrieNode root ;
	
	class TrieNode{
		TrieNode[] children;
		String word;
		TrieNode(){
			children = new TrieNode[26];
		}
	}
	
	
	private void insert(String word) {
		
		TrieNode curr = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(curr.children[c-'a'] == null) {
				curr.children[c-'a'] = new TrieNode();
			}
			curr = curr.children[c-'a'];
			
		}
		curr.word = word;
	}
	

	private String replaceWords(List<String> dict, String sentence) {
		root = new TrieNode();
		StringBuilder res = new StringBuilder();
		
	
		for(String word: dict) {
			insert(word);
		}
		
		String[] arr = sentence.split("\\s+");
		
		for(String word: arr) {
			TrieNode curr = root;
			if(res.length() > 0)
				res.append(" ");
			
			for(int i=0; i<word.length(); i++) {
				
			
				char c = word.charAt(i);
				if(curr.children[c-'a'] == null   ||   curr.word != null)
					break;
				
				curr = curr.children[c-'a'];
				
			}
			
			String replace = curr.word;
			if(replace != null) {
				res.append(replace);
			}else {
				res.append(word);
			}
			
		}
		
		
		


		return res.toString();
	}

	public static void main(String[] args) {
		ReplaceWords r = new ReplaceWords();

		String res = r.replaceWords(new ArrayList<>(Arrays.asList("cat", "bat", "rat")), "the cattle was rattled by the battery");
		System.out.println(res);

	}

}
