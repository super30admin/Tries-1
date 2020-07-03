/**
 * Time Complexity : O(N) 
 * Space Complexity : O(N)
 */
public class ImplementTrie{
    TrieNode root;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0 ; i < word.length() ; i ++)
        {
            if(temp.children[word.charAt(i) - 'a'] == null)
            {
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i)- 'a'];
        }
        temp.isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0 ; i < word.length() ; i ++)
        {
            if(temp.children[word.charAt(i)-'a'] == null)
            {
                return false;
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        return temp.isEnd;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i = 0 ; i < prefix.length() ; i ++)
        {
            if(temp.children[prefix.charAt(i) - 'a'] == null)
            {
                return false;
            }
            temp = temp.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }

    
    class TrieNode
    {
        boolean isEnd;
        TrieNode[] children;
        TrieNode()
        {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */