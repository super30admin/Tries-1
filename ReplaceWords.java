package s30Coding;
import java.util.*;

//Time Complexity :- O(N) where n is the length of the sentence
//Space Complexity :- O(k) k is size of the trie
//LeetCode:- yes

public class ReplaceWords {
	TrieNode root= new TrieNode();
    class TrieNode {
    	
        String word;
        TrieNode[] children;
        TrieNode() {
            children=new TrieNode[26];
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        for(String s: dict)
        {
            insert(s);
        }
        StringBuilder sb = new StringBuilder();
        String[] sentenceArr = sentence.split("\\s+");
        for(int k = 0; k < sentenceArr.length;k++){
            String word = sentenceArr[k];
            if(k>0) sb.append(" ");
            TrieNode curr = root;
            for(int i = 0; i < word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.word != null) break;
                curr =curr.children[c - 'a'];
            }
            String replacement;
            if(curr.word == null){
                replacement = word;
            }
            else{
                replacement = curr.word;
            }
            sb.append(replacement);
        }
        return sb.toString();
    }
    public void insert(String word)
    {
        TrieNode curr=root;
        for(int i=0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.word=word;
    }
}
