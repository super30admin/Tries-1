// Time Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Space Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Did this code successfully run on Leetcode :yes

import java.util.List;

class ReplaceWords {
    class TrieNode{
        TrieNode[] children;
        boolean isPrefixEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    private void insert(String word){
        TrieNode current = root;
        for(int i=0; i< word.length(); i++){
            Character c = word.charAt(i);
            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new TrieNode();
            }
            current = current.children[c-'a'];
        }
        current.isPrefixEnd = true;
    }

    private String getPrefix(String word){
        TrieNode current = root;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< word.length(); i++){
            Character c = word.charAt(i);
            if(current.isPrefixEnd || current.children[c-'a'] == null){
                break;
            }
            current = current.children[c-'a'];
            sb.append(c);
        }
        return current.isPrefixEnd ? sb.toString() : word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();

        //create a Trie with the dictionary
        for(String word: dictionary){
            insert(word);
        }

        String[] wordsArray = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< wordsArray.length; i++){
            String word = wordsArray[i];
            sb.append(getPrefix(word));
            if(i != wordsArray.length -1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}