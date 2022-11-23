package s30.tries;


//Algo: use tries

//TC : O(nl + nl) n being the number of words, and l is length of each word.
// one "nl" for creating the trie and other for iterating through the trie.

//SC: O(l) for recursive stack  + O(26^l) for the arrays in trie in the worst case
public class LongestWord {
    private Trie trie;
    private String res;
    public String longestWord(String[] words) {
        trie = new Trie();
        res = "";

        for(String word: words){
            trie.insert(word);
        }

        longestWord(trie.root);

        return res;
    }


    private void longestWord(TrieNode node){
        //base

        if(node == null || (node != trie.root && node.getWord() == null) ) {
            return;
        }

        if (node != trie.root && node.getWord().length() > res.length()) res = node.getWord();


        //recurse
        TrieNode[] children = node.getChildren();
        for(int i=0; i < 26; i++){
            longestWord(children[i]);
        }


    }



    class Trie{
        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){

            TrieNode node = root;
            for(int i =0; i < word.length(); i++){

                node = node.getorCreateChild(word.charAt(i));

            }

            node.setWord(word);

        }


    }

    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
        }

        public TrieNode getorCreateChild(char cha){
            int ch = cha - 'a';
            if(this.children[ch] == null){
                this.children[ch] = new TrieNode();
            }
            return children[ch];
        }

        public void setWord(String word){
            this.word = word ;
        }

        public TrieNode[] getChildren(){
            return this.children;
        }

        public String getWord(){
            return word;
        }


    }
    public static void main(String[] args) {
         LongestWord l = new LongestWord();
        System.out.println(l.longestWord(new String[]{"w","wo","wor","worl","world"}));
    }
}
