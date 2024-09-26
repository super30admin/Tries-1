// Time Complexity : O(n * l)
// Space Complexity : O(n * l )
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. create a trie for all the given words. 
 * 2. do bfs and check at each node is it end of the word or not
 * 3. return the result if null return "".
 */
import java.util.LinkedList;
import java.util.Queue;

public class LongestWordTrieBfs {
	class TrieNode {
		boolean isEnd;
		TrieNode[] childs;
		String word;
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
			cur.word=word;
		}
		String result=null;
		
		Queue<TrieNode> queue=new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TrieNode node=queue.poll();
			for(int i=25;i>=0;i--) {
				char c=(char)(97+i);
				System.out.println(c);
				if(node.childs[i]!=null && node.childs[i].isEnd) {
					queue.add(node.childs[i]);
					result=node.childs[i].word;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestWordTrieBfs().longestWord(new String[] {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"}));
	}
}
