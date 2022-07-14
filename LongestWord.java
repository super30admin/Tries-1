// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class LongestWord {
    class TrieNode {
        String word;
        TrieNode[] children;
        
        public TrieNode() {
            this.word = "";
            this.children = new TrieNode[26];
        }
    }
    
    private void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
        }
        
        curr.word = word;
    }
    
    TrieNode root;
    int maxLen = 0;
    String maxLenWord = "";
    public String longestWord(String[] words) {
        root = new TrieNode();
        
        for(String word : words) {
            insert(word);
        }
        
        getLongestWord(root);
        return maxLenWord;
    }
    
    private void getLongestWord(TrieNode curr) {
        
        for(int c = 0; c<26 ;c++) {
            if(curr.children[c] != null && curr.children[c].word.length()>0)
                getLongestWord(curr.children[c]);
        }
        
        if(curr.word.length()>maxLen){
            maxLen = curr.word.length();
            maxLenWord = curr.word;
        }
    
    }
}










