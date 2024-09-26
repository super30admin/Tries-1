// Time Complexity : O(K * L) + O(N) //for tries it is k*l, N is the length of sentence to replace
// Space Complexity :O(K * L) + O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

	class TrieNode {
		boolean isEnd;
		TrieNode[] childs;

		public TrieNode() {
			childs = new TrieNode[26];
		}
	}

	TrieNode root;

	public void insert(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.childs[c - 'a'] == null) {
				cur.childs[c - 'a'] = new TrieNode();
			}
			if(i!=word.length()-1)
				cur = cur.childs[c - 'a'];
		}
		cur.isEnd = true;
	}

	public String replaceWords(List<String> dictionary, String sentence) {
		root = new TrieNode();
		for (String word : dictionary) {
			insert(word);
		}

		String[] arr = sentence.split("\\s+");

		StringBuilder sj = new StringBuilder();
		StringBuilder sb;
		for (String word : arr) {
			if (sj.length()>0) {
				sj.append(" ");
			}
			
			sb = new StringBuilder();
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				sb.append(c);
				if (cur.childs[c - 'a'] == null || cur.isEnd) {
					break;
				}
				cur = cur.childs[c - 'a'];
			}

			if (cur.isEnd) {
				sj.append(sb);
			} else {
				sj.append(word);
			}
		}
		return sj.toString();
	}

	public static void main(String[] args) {
		List<String> ll=new ArrayList<String>();
		ll.add("cat");
		ll.add("bat");
		ll.add("rat");
		System.out.println(
				new ReplaceWords().replaceWords(ll, "the cattle was rattled by the battery"));
	}
}
