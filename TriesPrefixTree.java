//idea
//insert word: iterate over all characters in word.if character present in tries then check its child and keep on checking next characters. If child does not contains then create new node.
//search word or prefix: iterate over charcters in word and check is it present ornot if yes then check its child.at the end of all characters compare string that we fetched with word.
//time complexity is (n)
//space complexity is (n)

//run on leet code :yes
public class TriesPrefixTree {

	class TrieNode {
	    private final int R = 26;
	    private final TrieNode[] children;
	    private String item;
	    
	    public TrieNode() {
	        children = new TrieNode[R];
	        item = "";
	    }
	    
	    public String getItem() {
	        return item;
	    }
	    
	    public void setItem(String item) {
	        this.item = item;
	    }
	    
	    public TrieNode[] getChildren() {
	        return children;
	    }
	    
	    public TrieNode getChild(int i) {
	        if (i >= 26 || i < 0) throw new IllegalArgumentException();
	        return children[i];
	    }
	    
	    public void setChild(int i, TrieNode node) {
	        children[i] = node;
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode curr = root;
	        for (char c : word.toCharArray()) {
	            if (curr.getChild(c - 'a') == null) curr.setChild(c - 'a', new TrieNode());
	            curr = curr.getChild(c - 'a');
	        }
	        curr.setItem(word);
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode curr = root;
	        for (char c : word.toCharArray()) {
	            if (curr.getChild(c - 'a') == null) return false;
	            curr = curr.getChild(c - 'a');
	        }
	        return curr.getItem().equals(word);
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode curr = root;
	        for (char c : prefix.toCharArray()) {
	            if (curr.getChild(c - 'a') == null) return false;
	            curr = curr.getChild(c - 'a');
	        }
	        return true;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
