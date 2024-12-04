// Time Complexity :insert :O((n*l)+(m*l))
// Space Complexity :insert :O((n*l)+(m*l))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing


import java.util.List;

public class ReplaceWords {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children= new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd=true;
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        this.root = new TrieNode();
        for(String word : dictionary){
            insert(word);
        }

        String[] splitsWords = sentence.split(" ");
        for(int i=0; i<splitsWords.length; i++){
            if(i>0) result.append(" ");
            result.append(getShortenString(splitsWords[i]));
        }
        return result.toString();
    }

    private String getShortenString(String word){
        StringBuilder result = new StringBuilder();
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null || curr.isEnd){
                break;
            }
            curr = curr.children[c-'a'];
            result.append(c);
        }
        if(curr.isEnd){
            return result.toString();
        }
        return word;
    }
}
