import java.util.LinkedList;
import java.util.Queue;


//TC will be O(M * N), where N is the number of words in the array and M is the avg length of the word in array.
//SC will be O(M), M is the avg length of the word in array.
class LongestWordInDic {
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }

        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        TrieNode curr = root;
        q.add(root);
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i>=0; i--){
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

    public static void main(String[] args){
        String[] words = {"w","wo","wor","worl","world"};
        LongestWordInDic obj = new LongestWordInDic();
        System.out.println(obj.longestWord(words));

        String[] word = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(obj.longestWord(word));

    }
}