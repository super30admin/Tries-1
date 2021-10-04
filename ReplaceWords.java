package Tries1;

// Time Complexity: O(total no of words in dic*L[average length of each word] + length of sentence)
// Space Complexity : O(total no of words in dic*L[average length of each word])
// Did this code successfully run on Leetcode : yes

import java.util.List;

class TrieCustom{
    TrieNode root;
    public TrieCustom(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public String searchRoot(String word){
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            char c  = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return word;
            }
            curr = curr.children[c-'a'];
            if(curr.isEnd){
                return word.substring(0,i+1);
            }
        }
        return word;
    }
}

public class ReplaceWords {
    TrieCustom trie = new TrieCustom();
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String word: dictionary){
            trie.insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(String word : words){
            String res = trie.searchRoot(word);
            sb.append(res);
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();

    }
}
