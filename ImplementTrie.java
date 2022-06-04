// Time Complexity : insert O(L), search O(L), startsWith(L') , word= length, L' prfix length
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ImplementTrie {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children  = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        //point curr to parent/root
        TrieNode  curr = root;
        //traverse the word character by character
        for(int i=0; i<word.length(); i++) {
            //calculate the index to add TrieNode
            char c = word.charAt(i);
            //check for the index if it  has TriieNode or it is null
            //if it is null then create TrieNode
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            //updatee curr to that TrieNode
            curr = curr.children[c - 'a'];
        }
        curr.isEnd  = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
