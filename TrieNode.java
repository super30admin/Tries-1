//Time Complexity :O(N)
//Space Complexity :O(N*M)
//Did this code successfully run on Leetcode :Yes


//Your code here along with comments explaining your approach
class TrieNode{
	TrieNode[] children = new TrieNode[26];
	char ch;
	boolean isWord;
	public TrieNode(){}
	public TrieNode(char ch){
		this.ch = ch;
		this.isWord = false;
	}
	public TrieNode(char ch, boolean isWord){
		this.ch = ch;
		this.isWord = isWord;
	}
}

class Trie {
    static TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        char c[] = word.toCharArray();
        for(char ch: c){
            if(null != node.children[ch-'a']){
                node.children[ch-'a'].ch = ch;
            }else{
                node.children[ch-'a'] = new TrieNode(ch,false);
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        char c[] = word.toCharArray();
        for(char ch: c){
            if(null != node.children[ch-'a']){
                node = node.children[ch-'a'];
            }else{
                return false;
            }

        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char c[] = prefix.toCharArray();
        for(char ch: c){
            if(null != node.children[ch-'a']){
                node = node.children[ch-'a'];
            }else{
                return false;
            }

        }
        return true;
    }
}