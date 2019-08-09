import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];

    boolean isEndOfWord;
    char val;

    public TrieNode(char val) {
        isEndOfWord = false;
        for(int i=0;i<26;i++){
            children[i] = null;
        }
        this.val = val;
    }
}

class ReplaceWords {

    TrieNode root;

    ReplaceWords() {
        root = new TrieNode(' ');
    }
       /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        
        for(int i=0; i<word.length(); i++){
            char index = word.charAt(i);                
            if(curr.children[index-'a'] == null){
                curr.children[index-'a'] = new TrieNode(index);
            }
            curr = curr.children[index-'a'];            
        }

        curr.isEndOfWord = true;
    }

     /** Returns if the word is in the trie. */
     public String searchTrie(String word) {
        TrieNode curr = root;
        char index; 
        String result = "";
        for(int i=0;i<word.length();i++){

            index = word.charAt(i);
            if(curr.children[index -'a'] != null && !curr.isEndOfWord){
                result = result + index;
                curr = curr.children[index-'a'];
            }
            else{
                break;
            }
        }

        if(curr.isEndOfWord){
            return result;
        }

        return word;
    }
    

    public String replaceWords(List<String> dict, String sentence) {
        
        String result = "";
        // insert into trie
        for(int i=0;i<dict.size();i++){
            insert(dict.get(i));
        }

        // get words from sentences
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length;i++){
            TrieNode curr = root;
            words[i] = searchTrie(words[i]);
            result = result + words[i] + " ";
        }

        //add space


        return result.substring(0, result.length()-1);
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("ReplaceWords");

        ReplaceWords obj = new ReplaceWords();
        List<String> dict = new ArrayList<String>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
       
        
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        System.out.println(obj.replaceWords(dict, sentence));
    }
}