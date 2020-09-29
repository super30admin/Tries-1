class TrieNode{
	
	TrieNode children[];
	String word = "";
	
	TrieNode(){
		children = new TrieNode[26];
	}
}

public class longestWordDict {
	
	TrieNode root;
	String result = "";
	public String longestWord(String[] words) {
		
		root = new TrieNode();
		
		insert(words);
		dfs(root);
		return result;
	}
	
	public void insert(String[] words) {
		
		if( words == null || words.length == 0)
			return;
		for(String word: words) {
			TrieNode curr = root;

			for(char ch: word.toCharArray()) {
				if(curr.children[ch - 'a']==null) {
					curr.children[ch - 'a'] = new TrieNode();
				}
				curr = curr.children[ch-'a'];
			}
			curr.word = word;
		}
	}

	public void dfs(TrieNode root) {
		
		if(root.word.length() > result.length())
			result = root.word;
		
		for(int i =  0; i < 26 ; i++) {
			if(root.children[i] != null && root.children[i].word != "")
			{
				dfs(root.children[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		longestWordDict lw = new longestWordDict();
		String[] words = {"w","wo","wor","worl", "world"};
		System.out.println(
				lw.longestWord(words));
	}
}
