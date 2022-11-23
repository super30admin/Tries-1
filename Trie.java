package s30.tries;

// Insert: TC O(l) l is the length of the word
// Search: TC O(l)
// SearchPrefix: TC O(l)
// SC : O(26^l)
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    //TC : O(l) l being the length of the word.
    public void insert(String word) {

        TrieNode node = root;
        for(int i =0 ; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }

        node.isWord = true;
    }


    public boolean search(String word) {

        TrieNode node = root;

        for(int i =0 ; i < word.length(); i++){

            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                return false;
            }

            node = node.children[index];
        }

        return node.isWord;

    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for(int i =0 ; i < prefix.length() ; i++){

            int index = prefix.charAt(i) - 'a';
            if(node.children[index] == null){
                return false;
            }

            node = node.children[index];
        }

        return true;
    }
}


class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode(){
        children = new TrieNode[26];
    }
    public static void main(String[] args) {


         String s = "wdvjd";
         s =  s + (char)('a' + 3);

        System.out.println(s);
    }
}
