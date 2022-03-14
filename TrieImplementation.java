/**

TC - insert, search , startsWith -> O(N) N is the length of the input string.
SC - O(1)



**/
class TrieNode{
    
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    
    TrieNode()
    {
        children = new HashMap<>();
    }
}


class Trie {
    
    TrieNode root;

    public Trie() {
        
        root = new TrieNode();
    }
    
    public void insert(String word) {
        
        TrieNode current = root;
        
        for (int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            
            TrieNode childNode = current.children.get(c);
            
            if (childNode == null)
            {
                childNode = new TrieNode();
                current.children.put(c, childNode);
            }
            
            current = childNode;
        }

        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        
        
        TrieNode current = root;
        
        for (int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            
            TrieNode childNode = current.children.get(c);
            
            if (childNode == null)
            {
                return false;
            }
            
            current = childNode;
        }

        return current.isEndOfWord;        
    }
    
    public boolean startsWith(String prefix) {
        
        TrieNode current = root;
        
        for (int i=0; i<prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            
            TrieNode child = current.children.get(c);
            
            if (child == null)
            {
                return false;
            }
            
            current = child;
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
