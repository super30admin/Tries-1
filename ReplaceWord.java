//TC: O(number-of-dictionary-words * avg len of word + total_words_in_sentence * avg_length_of_word)
//SC: O(number-of-dictionary-words * avg len of word)
//works in leetcode

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        Trie trie = new Trie();
        for(String word: dictionary){
            trie.insert(word);
        }

        String[] wordsInSentence = sentence.split(" ");

        for(int i=0; i< wordsInSentence.length;i++){
            String prefixWord = trie.shortestPrefix(wordsInSentence[i]);
            wordsInSentence[i] = prefixWord;
        }

        return String.join(" ", wordsInSentence);

    }
}

class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){

        TrieNode node = root;
        for(int i=0;i<word.length();i++){

            char ch = word.charAt(i);
            TrieNode child = node.children[ch-'a'] == null ?  new TrieNode():node.children[ch-'a'];
            node.children[ch-'a'] = child;
            node = child;
        }
        node.isWord=true;

    }



    public String shortestPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] ==null){
                break;
            }
            if(node.children[ch-'a'].isWord())
                return word.substring(0,i+1);

            node = node.children[ch-'a'];
        }
        return word;

    }


}

class TrieNode{
    TrieNode [] children;
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26];
    }
    public boolean isWord(){
        return this.isWord;
    }

}