
//Time Complexity-O(n)
//Space complexity-O(m) where m is number of characters in tries
class Trie {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        TrieNode()
        {
            children=new TrieNode[26];
            isWord=false;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=root;
        for(Character c:word.toCharArray())
        {
            if(cur.children[c-'a']==null)
            {
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        cur.isWord=true;        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=root;
        for(Character c:word.toCharArray())
        {
            if(cur.children[c-'a']==null)
            {
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode cur=root;
        for(Character c:prefix.toCharArray())
        {
            if(cur.children[c-'a']==null)
            {
                return false;
            }
            cur=cur.children[c-'a'];
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