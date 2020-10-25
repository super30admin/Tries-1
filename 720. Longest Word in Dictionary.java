class TrieNode{// time of O(total characters) and space of O(max word length.)
    HashMap<Character, TrieNode> links = new HashMap<>();
    char c;
    int word_index ;
    public TrieNode(char c){
        this.c = c;
    }
}
class Trie{
    TrieNode root;
    String[] words ;
    public Trie(){
        root = new TrieNode('0');
    }
    public void insert(String word , int index){
        TrieNode curr = root;
        for(int i = 0; i<word.length() ; i++){
            char ch = word.charAt(i);
            curr.links.putIfAbsent(ch, new TrieNode(ch));
            curr = curr.links.get(ch);
        }
        curr.word_index = index;
    }
    public String dfs(){
        String result = "";
        Stack<TrieNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TrieNode node = stack.pop();
            if(node.word_index > 0 || node == root){
                if(node!=root){
                String word = words[node.word_index-1];
                //find on of valid prefix
                  if(word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)){
                    result = word ;
                }
            }
            for(TrieNode child : node.links.values()){
                stack.push(child) ;
            }
            }
        }
        return result;
    }
}
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word: words)
        {
           trie.insert(word,++index);
        }
        trie.words = words ;
        return trie.dfs() ;
    }
}