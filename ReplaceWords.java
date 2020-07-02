//Time Complexity :O(N*M) for insert Strings, O(N*M) for searching strings
//Space Complexity :O(N*M) N - no. of strings and M - length of string
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class Solution {
    static TrieNode root;
    public Solution(){
        root = new TrieNode();
    }
    public String replaceWords(List<String> dict, String sentence) {
        for(String d : dict){
            insert(d);
        }
        String word[] = sentence.split("\\s+");
        Map<String,String> map = new HashMap<>();
        for(String w: word){
            search(w,map);
        }
        StringBuilder result = new StringBuilder("");
        for(int i = 0; i < word.length; i++){
            if(map.containsKey(word[i])){
                result.append(map.get(word[i]));
            }else{
                result.append(word[i]);
            }
            if(i != word.length-1){
                result.append(" ");
            }
        }
        return result.toString();
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word,Map<String,String> map) {
        TrieNode node = root;
        char c[] = word.toCharArray();
        boolean found = false;
        for(char ch: c){
            if(!found && node.isWord){
                map.put(word,node.word);
                found = true;
                return true;
            }
            if(null != node.children[ch-'a']){
                node = node.children[ch-'a'];
            }else{
                return false;
            }
            
        }
        return node.isWord;
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