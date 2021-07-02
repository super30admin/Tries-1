// Time Complexity : O(k * L )+ O(K*L(log K + log L))+O(k * L )
// Space Complexity : O(k * L )
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. create a trie for all teh given words. 
 * 2. sort words array.
 * 3. traverse words and find long wword which has isend as true at each node in the path.
 */
import java.util.Arrays;

public class LongestWord {
	class TrieNode {
		boolean isEnd;
		TrieNode[] childs;

		public TrieNode() {
			childs = new TrieNode[26];
		}
	}

	
	public String longestWord(String[] words) {
		TrieNode root= new TrieNode();
		
		for (String word : words) {			
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (cur.childs[c - 'a'] == null) {
					cur.childs[c - 'a'] = new TrieNode();
				}
				cur = cur.childs[c - 'a'];
			}
			cur.isEnd = true;
		}
		String result=null;
		Arrays.sort(words);
		for (String word : words) {			
			TrieNode cur = root;
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (cur.childs[c - 'a'] != null && cur.childs[c - 'a'].isEnd) {
					sb.append(c);
				}else {
					break;
				}
				cur = cur.childs[c - 'a'];
			}
			if(result==null || result.length()<sb.length()) {
				result=sb.toString();
			}
			cur.isEnd = true;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestWord().longestWord(new String[] {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"}));
	}
}
