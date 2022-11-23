package s30.tries;

import java.util.List;

//Algo : Use Tries and add all the words to the trie.
// iterate through the words array and replace with short prefix;

//TC: O(N) N ==> number od characters in the sentence.
// SC: O(N) for Trie;
public class ReplaceWords {
    private Trie trie;

    public String replaceWords(List<String> dictionary, String sentence) {
        trie  = new Trie();

        for(String word : dictionary){
            trie.insert(word);
        }

        String[] res = sentence.split(" ");

        for(int i =0; i < res.length; i++){

            String prefix = trie.getPrefix(res[i]);
            if(prefix != null){
                res [i] = prefix;
            }
        }

        return String.join( " ", res);

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



        public String getPrefix(String word){


            TrieNode node = root;
            for(int i=0; i< word.length(); i++){

                node = node.getChild(word.charAt(i));
                if(node == null) break;

                if(node.getWord() != null) return node.getWord();
            }

            return  null;
        }
    }


    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
        }

        public TrieNode getChild(char ch){
            return this.children[ch - 'a'];
        }

        public TrieNode getorCreateChild(char cha){
            int ch = cha - 'a';
            if(this.children[ch] == null){
                this.children[ch] = new TrieNode();
            }
            return children[ch];
        }

        public void setWord(String word){
            this.word = word;
        }

        public String getWord(){
            return this.word;
        }
    }
    public static void main(String[] args) {

    }
}
