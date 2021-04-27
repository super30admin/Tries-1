//Replace Words
import java.util.*;

//tc - O(m*n) m = sentence length n = number of words 
//sc - O(m*n)

public class Problem3 {
    class TrieNode{
        boolean isEnd;
        TrieNode[]  children;
        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String word){
        TrieNode curr = root;
        
        for(int i = 0;i< word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
        
    }
    public String searchPrefix(String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
       for(int j =0; j< word.length(); j++){
           if(curr.children[word.charAt(j) -'a'] == null || curr.isEnd){
               break;
           }
           sb.append(word.charAt(j));
           curr = curr.children[word.charAt(j) -'a'];
       }
        if(curr.isEnd){
            return sb.toString();
        }
        else{
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        //    "\\s+"
        String[] sent = sentence.split("\\s+");
        //for each word inseet into trie
        for(String each : dictionary){
            insert(each);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i< sent.length; i++){
            String each = sent[i];
            if(i >0){
                sb.append(" ");
            }
            sb.append(searchPrefix(each));
        }
        return sb.toString();
        
    }
    public static void main(String[] args){
        Problem3 p = new Problem3();
        List<String> word = new ArrayList<>();
        word.add("cat");
        word.add("bat");
        word.add("rat");
        System.out.println(p.replaceWords(word, "the cattle was rattled by the battery"));


    }
    
}
