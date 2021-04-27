//Longest Word in Dictionary

//tc - O(m*n) m = size of array and n = length of word
//sc = O(m*n) for queue
import java.util.*;
public class Problem2 {
    public static void main(String[] args){
        Problem2 p = new Problem2();
        String[] words = {"w","wo","wor","worl","world"};
        String[] words2 = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(p.longestWord(words2));

    }
    
    private class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    //insert method
    public void insert(String wrd){
        TrieNode curr = root;
        for(int i = 0;i< wrd.length();i++){
            char ch = wrd.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch -'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = wrd;
        // curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        for(String word : words){
            insert(word);
        }
        TrieNode curr = root;
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i>=0;i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                   
                }
            }
//                 }

        }
        return curr.word;
        
        
    }
    
}
