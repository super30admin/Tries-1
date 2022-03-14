/**

TC - O(N) where N is the length of the sentence.
SC - O(N) is the size of the Trie.


**/


class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();;
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
    
    public int startsWith(String prefix)
    {
        TrieNode current = root;
        
        for (int i=0; i<prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            
            TrieNode childNode = current.children.get(c);
            
            if (childNode != null && childNode.isEndOfWord)
            {
                return i;
            }
            
            if (childNode == null)
            {
                break;
            }
            
            current = childNode;
        }
        
        return -1;
    }
}


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie trie = new Trie();
        
        for (String dict : dictionary)
        {
            trie.insert(dict);
        }
        
        String splitSentence[] = sentence.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int k=0; k<splitSentence.length; k++)
        {
            int index = trie.startsWith(splitSentence[k]);
            
            if(index != -1)
            {
                splitSentence[k] = splitSentence[k].substring(0,index + 1);
            }
            
            sb.append(splitSentence[k] + " ");
        }
        
        return sb.toString().trim();
    }
}
