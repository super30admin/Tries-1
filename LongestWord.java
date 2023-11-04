
//TC - O(nL) where L is the average length of the string of n words.
//SC -O(nL)
import java.util.LinkedList;
import java.util.Queue;

public class LongestWord {
    class TrieNode{
        String word;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    public String longestWord(String[] words) {

        root = new TrieNode();
        for(String word :words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();


        q.add(root);

        TrieNode curr = root;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i=25;i>=0;i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);

                }
            }

        }
        if(curr.word == null){
            return "";
        }
        return curr.word;


    }
    void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
}
