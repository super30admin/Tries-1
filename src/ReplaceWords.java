// Time Complexity : n- # wors in dict, m- # words in the sentence, l- avg length of the word , O(nl + ml) - nl for trie creation, ml for finding the replacement
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**create trie of all words from the dict,
 * for each word in the sentence, find the replacement using this trie
 * create new sentence from the replacement words
 * 
 * https://leetcode.com/problems/replace-words/
 *
 */
class Solution {
	TreeNode root;

	class TreeNode{
		char val;
		boolean isEnd;
		TreeNode[] child;

		public TreeNode(){
			child = new TreeNode[26];  
		}
	}
	/** Initialize your data structure here. */
	public Solution() {
		root = new TreeNode();  
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TreeNode prevNode = root;

		//start processing remaining characters
		for(int i = 0 ; i< word.length(); i++) {
			char currChar = word.charAt(i);

			if(prevNode.child[currChar-'a'] == null) {
				TreeNode currNode = new TreeNode();
				currNode.val = currChar;
				prevNode.child[currChar-'a'] = currNode;
				prevNode = currNode;
			}else {
				prevNode = prevNode.child[currChar-'a'];
			}
		}

		//mark end flag true for last character
		prevNode.isEnd = true;
	}

	private String getReplacement(String word, TreeNode root) {
		TreeNode curr = root;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i< word.length(); i++) {
			char currChar = word.charAt(i);

			curr = curr.child[currChar - 'a'];
			//if node found for curr char, append it else return complete word as no matching
			//word found in the dict
			if(curr != null) {
				sb.append(Character.toString(curr.val));

				//if current node is end character, we found our replacement
				if(curr.isEnd){
					return sb.toString();
				}    

			}else {
				return word;
			}
		}
		return word;
	}

	public String replaceWords(List<String> dict, String sentence) {
		if(dict == null || dict.size() == 0) return "";

		Solution sc = new Solution();

		//create trie for all the words in the dict
		for(String word: dict){
			sc.insert(word); 
		}

		String[] words = sentence.split("\\s+");

		StringBuilder sb = null;

		//for each word in the sentence, get replacement word
		for(String word: words){

			if(sb != null) {
				sb.append(" ");
			}else {
				sb = new StringBuilder();
			}
			sb.append(getReplacement(word, sc.root));
		}
		return sb.toString();
	}
}