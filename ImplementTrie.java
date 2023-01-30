//Time Complexity: O(l) , l-> length of the word
//Space Complexity: O(l), l-> length of the word

/*
 * In this approach we iterate over the board and if can find the word we return true or else false. For finding the word we check if a particular char is equal to 
 * the same index of the word. If not we return false. If it does we mark that as visited and move on, we check all the neighbors and do same thing again. If we dont
 * find char at the word index from all the neighbors we mark it as unvisited.

*/
class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode(); 
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return false; 
            }
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null){
                return false; 
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}