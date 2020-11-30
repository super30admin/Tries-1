package demo;

class Trie {

    /** Initialize your data structure here. */
	static class TrieNode 
	{ 
		TrieNode[] children = new TrieNode[26]; 
	
		// isEndOfWord is true if the node represents 
		// end of a word 
		boolean isEndOfWord; 
		
		TrieNode(){ 
			isEndOfWord = false; 
			for (int i = 0; i < 26; i++) 
				children[i] = null; 
		} 
	};
    
    static TrieNode root; 
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
         int level; 
        int length = word.length(); 
        int index; 
       
        TrieNode t = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = word.charAt(level) - 'a'; 
            if (t.children[index] == null) 
                t.children[index] = new TrieNode(); 
       
            t = t.children[index]; 
        } 
       
        // mark last node as leaf 
        t.isEndOfWord = true; 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int level; 
		int length = word.length(); 
		int index; 
		TrieNode t = root; 
	
		for (level = 0; level < length; level++) 
		{ 
			index = word.charAt(level) - 'a'; 
	
			if (t.children[index] == null) 
				return false; 
	
			t = t.children[index]; 
		} 
	
		return (t != null && t.isEndOfWord); 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */