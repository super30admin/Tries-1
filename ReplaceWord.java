//T.C O(m*l) or O(n*l) which ever is bigger where m-> number of words in dictionary, n-> number of words in sentence l -> length of the word
//S.C O(n*l) n-> num of words in dict l-> length of each word
//Successful executed in leetcode : yes
//Solution: Use Tries to store dictionary words. For each word in given sentence, go through tries arrays to replace with corresponding root.
import java.util.*;

class ReplaceWord {
    TrieNode root;

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public String replaceWords(List<String> dictionary, String sentence){
        this.root = new TrieNode();

        //insert dictionary to the trie
        for(String w: dictionary){
            insert(w);
        }

        String[] words = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String w: words){
            sb = sb.append(getRoot(w)+" ");

        }
        return sb.toString();
    }

    private String getRoot(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null || curr.isEnd){
                break;
            }
            curr = curr.children[c-'a'];
            sb.append(c);
        }
        if(curr.isEnd)
            return sb.toString();
        else
            return word;
    }
    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']==null) {
                curr.children[c - 'a'] = new TrieNode();
                curr = curr.children[c - 'a'];
            }
        }
        curr.isEnd = true;
    }

    public static void main(String[] args) {
        List<String> dict = List.of("cat","bat","rat");
        String sentence = "the cattle was rattled by the battle";

        ReplaceWord rw = new ReplaceWord();
        String s = rw.replaceWords(dict,sentence);
        System.out.println(s);
    }
}