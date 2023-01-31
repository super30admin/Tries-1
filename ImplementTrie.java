//Time Complexity: O(l) , l-> length of the word
//Space Complexity: O(1)

/*
 * In this approach we implement trie, we take trienode of 26. We take a root node. To insert we loop over the charcters of the word and if the node to that particular char
   is not present then we add a trie node. if it is there we just increment the current to next children. Once we insert the whole word we mark the isend as true at that char.
   To search we again loop over the characters of the word, and if it is not present we return false, or we return the isend. To find prefix we saerch the
   prefix and if we find it we return true.

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