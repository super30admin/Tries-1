/* Time Complexity :  O(L) for insert, search, startswith
   Space Complexity :   O(n*k) where n is no of words and k is avg length
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];            
        }       
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.children[c-'a']==null)
            {
                cur.children[c-'a'] = new TrieNode();              
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            //System.out.println(c-'a');
            if(cur.children[c-'a']==null)
            {
                return false;
            }
             cur= cur.children[c-'a'];
        }
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.children[c-'a']==null)
            {
                return false;
            }
            cur= cur.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */