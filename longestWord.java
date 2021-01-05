// Time Complexity : O(N * avarage length of word)
// Space COmplexity : O(length of word)
class Solution {
    class TrieNode{
        String word;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        if(words == null || words.length == 0)
            return "";
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        TrieNode curr = root;
        while(!queue.isEmpty()){
            curr = queue.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    queue.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}