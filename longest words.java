//Timecomplexity :- O(m*k) for dfs. where m is no of words in array and k is no of letters in a word.
//Spacecomplexity :- O(m*k) 
//Did it run on leetcode:- Yes.
//What was the problem faced:- got many null exceptional errors.
//explanation is given beside in comments.




class Solution {
 

	class TrieNode{
		TrieNode[] children;
		String word;

		public TrieNode(){
			children = new TrieNode[26];
			word = "";
		}
	}

	TrieNode root;
	String result = "";

	public String longestWord(String[] words) {
		// Edge case checking
		if(words == null || words.length == 0)
			return "";

		root = new TrieNode();

		//insert and build trie dictionary
		insert(words);

		//dfs
		dfs(root);

		return result;
	}

	private void insert(String[] words){
		// For every word in words - we construct the trie, character by character also keep the track of word at each point
		for(String s: words){
			TrieNode curr = root;
			for(char c : s.toCharArray()){
				if(curr.children[c - 'a'] == null)
					curr.children[c - 'a'] = new TrieNode();
				curr = curr.children[c - 'a'];
			}
			curr.word = s;
		}
	}

	private void dfs(TrieNode root){
		// If our word length > result length - then update result
		if(root.word.length() > result.length())
			result = root.word;

		/// Traverse the nodes of a trie from left to right (a to z) (No need for sorting)
		for(int i = 0; i < 26; i++){
			if(root.children[i] != null && root.children[i].word != "")
				dfs(root.children[i]);
		}
	}
}
