// Time Complexity : O(NL) where n is the size of words and L is the length of word
// Space Complexity : O(NL) where n is the size of words and L is the length of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    class TrieNode{
        String word;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word){
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
            for(int i = 25; i >= 0; i--){
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
}
