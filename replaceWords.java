// TC: O(N) where N is length of the String sentence
// SC : O(N) where N is length of dictionary which is stored in trienode

import java.util.*;
class TrieNode{
	
	TrieNode[] children;
	boolean isWordEnd;
	
	TrieNode(){
		children = new TrieNode[26];
		isWordEnd = false;
	}
}

public class replaceWords {

	TrieNode root = new TrieNode();
	
	public String replaceWord(List<String> dictionary, String sentence) {
		
		for(String words: dictionary) {
			insert(words);
		}
		
		String[] Splstr = sentence.split(" ");
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < Splstr.length; i++) {
			if(i > 0) {
				res.append(" ");
			}
			
			String word = Splstr[i];
			StringBuilder temp = new StringBuilder();
			TrieNode curr = root;
			for(char ch: word.toCharArray()) {
				if(curr.children[ch-'a'] == null || curr.isWordEnd) {
					break;
				}
				temp.append(ch);
				curr = curr.children[ch -'a'];
			}
			if(curr.isWordEnd) {
				res.append(temp);
			}else {
				res.append(word);
			}
		}
		return res.toString();
	}
	
	public void insert(String words) {
		
		TrieNode curr = root;
		for(char ch: words.toCharArray()){
			if(curr.children[ch-'a'] == null) {
				curr.children[ch - 'a'] = new TrieNode();
			}
			
			curr = curr.children[ch - 'a'];
		}
		
		curr.isWordEnd = true;
	}
	
	public static void main(String[] args) {
		
		replaceWords rw = new replaceWords();
		List<String> dictionary = new ArrayList<>();
		String sentence = "the cattle was rattled by the battery";
		dictionary.add("cat");
		dictionary.add("rat");
		dictionary.add("bat");
		System.out.println(rw.replaceWord(dictionary, sentence));
		
	}
}
