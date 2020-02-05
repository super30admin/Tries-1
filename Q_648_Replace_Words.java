package Q_648_Replace_Words;

//In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
//
//Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
//
//You need to output the sentence after the replacement.
//
//Example 1:
//
//Input: dict = ["cat", "bat", "rat"]
//sentence = "the cattle was rattled by the battery"
//Output: "the cat was rat by the bat"
// 
//
//Note:
//
//The input will only have lower-case letters.
//1 <= dict words number <= 1000
//1 <= sentence words number <= 1000
//1 <= root length <= 100
//1 <= sentence words length <= 1000


//Time Complexity  : O(n)  
//Space Complexity : O(n)  



import java.util.*;

public class Solution {
	
	public  class TrieNode{
		String word;
		TrieNode[] children = new TrieNode[26];
		boolean isEnd;
		char nodeName;
		public TrieNode() {
		}
		
		public TrieNode(char name)
		{
			this.nodeName = name;
		}
	}
	
	TrieNode root = new TrieNode();
	
	public  void insertTrieNode(String word) {
		TrieNode curr = root;
		for(int i =0; i< word.length();i++) {
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null) {
				curr.children[c -'a'] = new TrieNode(c);
			}
			curr = curr.children[c -'a'];
		}
		curr.word = word;
		curr.isEnd = true;
	}

	public   String replaceWords(List<String> dict, String sentence) {
		for(String ele : dict) {
			insertTrieNode(ele);
		}
		
//		sentence.split('//s+');
		StringBuilder sb = new StringBuilder();

//		for(String s : sentence.split(" "))
			for(String s : sentence.split("\\s+"))
		{
			if(sb.length() >0){
	            sb.append(" ");
	        }
			String word = s;
			TrieNode curr = root;
			for(int j=0; j<word.length();j++) {
				char c = word.charAt(j);
				if(curr.children[c - 'a'] == null || curr.word != null) {
					break;
				}
				curr = curr.children[c - 'a'];
			}
			
			if(curr.word != null)
			{
				sb.append(curr.word);
			}else {
				sb.append(word);
			}
//			sb.append(" ");
		}
		
		return sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
//		String sentence = "the cattle was rattled by the battery";
		String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		
		
		
//		["a", "aa", "aaa", "aaaa"]
				
//		TrieNode t = new TrieNode();
		Solution s = new Solution();
		System.out.println(s.replaceWords(dict, sentence));

	}

}
