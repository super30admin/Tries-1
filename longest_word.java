package Fifth_week.longest_word_dictionary;

// Time: O(M*n)
// Space: O(M*n)
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class longest_word {

    class TrieNode{
        String word;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }


    TrieNode root;

    private void insert(String word){
      //  System.out.println(word);
       // System.out.println(root);
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
           // System.out.println(curr.word +" -- "+Arrays.deepToString(curr.children));
            char c = word.charAt(i);

            if(curr.children[c-'a'] == null){ // Check whether charater is present or not
                curr.children[c-'a'] = new TrieNode(); // We are creating new trienode children here
            }
            curr = curr.children[c-'a'];
        }

        curr.word = word;
        //System.out.println(curr.word +" -- "+Arrays.deepToString(curr.children));

    }

    public String longestWord(String[] words){
        if(words == null || words.length == 0) return "";
        root = new TrieNode();
        //System.out.println(root);
        for(String word: words){ // Iterate through the string array to get each word and insert to trie
            insert(word);
        }
        System.out.println(Arrays.deepToString(root.children));

        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        System.out.println(curr.word);
        while (!q.isEmpty()){
            curr = q.poll();
            for (int i = 25;i>=0;i--){

                if(curr.children[i] !=null && curr.children[i].word !=null){
                    System.out.println(curr.children[i]+" "+curr.children[i].word);
                    q.add(curr.children[i]);
                }
            }


        }
        return curr.word;
    }


    public static void main(String[] args) {
        longest_word lw = new longest_word();
        String[] str = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String result = lw.longestWord(str);
        System.out.println(result);
    }
}
