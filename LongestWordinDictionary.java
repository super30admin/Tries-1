//Time Complexity :O(N*M) where N: no. of strings and M: length of string
//Space Complexity :O(N*M) 
//Did this code successfully run on Leetcode :yes
class Solution {
    static TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public String longestWord(String[] words) {
        int maxLength = 0;
        String result = "";
        for(String w: words){
            insert(w);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(root);
        TrieNode node = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                node = q.poll();
                for(int j = 25; j >= 0; j--){
                    if(null != node.children[j] && node.children[j].isWord){
                        q.offer(node.children[j]);
                    }
                }
            }
        }
        return node.word;
    }
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
        node.word = word;
    }
}

class TrieNode{
	TrieNode[] children = new TrieNode[26];
	char ch;
	boolean isWord;
    String word;
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