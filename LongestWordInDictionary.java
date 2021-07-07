// Time Complexity : O(m) m-> length of the word
// Space Complexity :  O(m*n); m-> average length of each word; n -> no. of words in dictionary 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: A trie datastructure is used to insert and retrieve the words in a fast manner.
// Here, along with the children represented by 26 characters, the word in dictionary is also maintained.
// Queue datastructure is used for processing the branches of trie level by level. Whenever a branch with null word is observed, it is ignored. Otherwise, respective children are added in queue.
// This approach guarantees that the last word obtained will be the longest that can be formed.

class Solution {
    
    class TrieNode {
        String word;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];            
        }
    }
    TrieNode root = new TrieNode();
    public String longestWord(String[] words) {
        
        for(String w : words) {
            insert(w);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = null;
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i = 25; i >= 0; i--) { // for maintaining lexicographical order
                if(curr.children[i] != null && curr.children[i].word != null) {
                    q.offer(curr.children[i]);
                }
            }   
        }
        return curr.word;
    }
    
    public void insert(String word){
        TrieNode curr = root;
        char[] ch = word.toCharArray();
        for(char c : ch) {
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }    
        curr.word = word; // storing the complete word to distinguish incremental words in dictionary
    }
}

