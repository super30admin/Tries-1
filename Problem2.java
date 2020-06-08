//time o(nk) , n - size of the array, k - avg length, queue will be having at max nk elements
//space o(nk)
class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    /** Inserts a word into the trie. */
    public void insert(String word) { //o(nk)
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        if(words == null || words.length == 0)
            return "";
        for(String word: words) {
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        
        TrieNode curr = null;
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i=25;i>=0;i--) {
                if(curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }
         return curr.word;
    } 
}