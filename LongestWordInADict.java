/**

TC - O(N) where N is the length of words array.
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
    
    Trie()
    {
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
}


class Solution {
    
    Trie trie;
    String result = "";
    
    
    public String longestWord(String[] words) {
        
        trie = new Trie();
        
        for (String w : words)
        {
            trie.insert(w);
        }
        
        applyDFS(trie.root, "");
        
        return result;
    }
    
    private void applyDFS(TrieNode current, String word)
    {
        // base case 
        if (current == null)
        {
            return;
        }
        
        if (current != trie.root && !current.isEndOfWord)
        {
            return;
        }
        
        // Traverse to all the children
        for (Map.Entry<Character,TrieNode> entry : current.children.entrySet())
        {   
            TrieNode value = entry.getValue();
            applyDFS(value, word + entry.getKey()); 
        }
        
        if (result.length() == word.length())
        {
            result = word.compareTo(result) > 0 ? result : word;
        }
        else
        {
            result = word.length() > result.length() ? word : result;
        }
    }
}
