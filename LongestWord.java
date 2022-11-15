//TC: O(number-of-words * avg len of word)
//SC: O(number-of-words * avg len of word)
//works in leetcode
class Solution {
    public String longestWord(String[] words) {
        String result = "";
        Trie trie = new Trie();

        //insert all words
        for(int i=0; i<words.length; i++){
            trie.insert(words[i]);
        }

        for(String word: words){


            if((word.length() > result.length()) || (word.length() == result.length() &&   word.compareTo(result) < 0 )){

                if(trie.allPrefixIsWord(word)){
                    result = word;
                }

            }


        }

        return result;
    }
}

class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i< word.length();i++){
            char ch = word.charAt(i);

            TrieNode child = node.children[ch-'a'] == null? new TrieNode():node.children[ch-'a'];

            node.children[ch-'a'] = child;
            node = child;
        }
        node.isWord=true;
    }

    public boolean search(String word) {
        TrieNode node= root;
        for(int i=0; i< word.length();i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] == null)
                return false;
            node = node.children[ch-'a'];
        }

        return node.isWord ? true:false;

    }

    public boolean allPrefixIsWord(String word){
        TrieNode node = root;
        for(int i=0;i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] == null || node.children[ch-'a'].isWord==false)
                return false;
            node = node.children[ch-'a'];

        }
        return true;
    }


}

class TrieNode{
    TrieNode [] children;
    boolean isWord;

    public TrieNode(){
        children = new TrieNode[26];
    }

}