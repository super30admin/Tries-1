/*
TC: Insert into Trie + Replace
O(N * L) {N - number of words in dictionary, L - avg length of words in dictionary} + O(L) {L - length of sentence}

SC: To construct a trie
O(N * L) N - number of words in dictionary, L - avg length of words in dictionary

1. A trie is constructed for the words in dictionary. 
2. The words in sentence are traversed, if the word prefix is found in trie, it is updated in the sentence.
3. We always update the shortest word by setting word variable in TrieNode.

*/

import java.util.*;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrNode trie = new TrNode();
        
        for(String word : dictionary){
           TrNode cur = trie;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.list[c - 'a'] == null){
                    cur.list[c - 'a'] = new TrNode();
                }
                cur = cur.list[c - 'a'];
            }
            cur.word = word;
        }
        
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        
        for(String str : words){
            if(sb.length() > 0)
                sb.append(" ");
            
            TrNode cur = trie;
            for(char c : str.toCharArray()){
                if(cur.list[c - 'a'] == null || cur.word != null)
                    break;
                cur = cur.list[c - 'a'];
            }
            sb.append(cur.word != null ? cur.word : str);
        }
        
        return sb.toString();
    }

    public static void main(String[] args){
        ReplaceWords rw = new ReplaceWords();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("catt");
        dictionary.add("ratt");
        String sentence = "the cat was rattled by the battle";

        System.out.println(rw.replaceWords(dictionary, sentence));

    }
}

class TrNode{
    
    TrNode[] list;
    String word;
    
    public TrNode(){
        this.list = new TrNode[26];
    }
}

