// Time Complexity: O(sum of length of all words)
// Space Complexity: O(sum of Length of word * 26)
// Write your approach here
// Idea here is to use TrieNodes which have array of 26 as child characters
// Basic insersion code is bootstrapped
// Now we can run dfs on root of trie to check its children,
// if children are not null and have values we check if children's length is greater than current maximum length of result
// in case of greater we arrign result a new word and continue the dfs
class Solution {
    class TrieNode {
        TrieNode[] children;
        String val;
        boolean isEnd;
        
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.val = word;
        curr.isEnd = true;
    }
    
    String result = "";
    
    public String longestWord(String[] words) {
        TrieNode curr = root;
        for(String word: words) {
            insert(word);
        }
        dfs(root);
        return result;
    }
    
    public void dfs(TrieNode root) {
        for(TrieNode child: root.children) {
            if(child!=null && child.val!=null) {
                if(child.val.length() > result.length()) {
                    result = child.val;
                }
                dfs(child);
            }
        }
    }
}