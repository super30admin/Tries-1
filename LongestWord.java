import java.util.*;

class LongestWord {

    /**
     * Time complexity: O(N) where N is the prefix length
     * Space complecity: O(1)
     * 
     * Approach:
     * 1. Store all words in a trie structure.
     * 2. To find out the longest words, we can perform breadth wise search, 
     */

    class TrieNode {
        
        String word;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
        
    }
    
    TrieNode root = new TrieNode();
    
    private void insert(String word) {
        TrieNode curr = root;
        
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    
    public String longestWord(String[] words) {
        
        if(words == null || words.length == 0) {
            return "";
        }
        
        for(String w : words) { //O(N*L) where N is number of words and L is max length of the words 
            insert(w);
        }
        
        Queue<TrieNode> q = new LinkedList<>();
        
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()) {
            curr = q.poll();
            
            for(int i=25; i>=0; i--) {
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        
        return curr.word;
        
    }
}