//T.C - O(L) //for each insert. If m words are there in the dictionary, T.C O(m*L)
//S.C - O(m * L) //if m no. of words of length L
class Trie {

    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) { //O(L)
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {//O(L)
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {//O(L)
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class TriePrefixTree{
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("leet");
        boolean p1 = obj.search("leet");
        boolean p2 = obj.startsWith("la");
        System.out.println(p1 + " " + p2);
    }
}