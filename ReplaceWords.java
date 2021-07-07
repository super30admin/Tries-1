// 648.
//approach - build a trie with words in dict.
//for each word in sentence, try all prefixes of that word and check if one prefix exists

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode(boolean isWord, TrieNode[] children) {
        this.isWord = isWord;
        this.children = children;
    }
}



class Solution {
    TrieNode root;
    
    public String replaceWords(List<String> dict, String sentence) {
    
        root = new TrieNode(false, new TrieNode[26]);
        
        //time - O(length of dict)
        //space - O(length of largest word in dict)
        //build trie
        for(String word : dict)
        {
            buildTrie(word);
        }
        
        //time - O(length of sentence * length of largest word in sentence)
        //space - O(1)
        String[] words = sentence.split(" ");
        String result = "";
        for(String word : words)
        {
            int i = 0;
            int j = 1;
            boolean foundPrefix = false;
            //for each word, # of prefixes = word length
            //foe each word this while() runs length of word times
            //try all possible prefixes if not replace the word with word itself
            while(j <= word.length())
            {
                String prefix = word.substring(i, j);
                if(findPrefix(prefix))
                {
                    result = result + prefix + " ";
                    foundPrefix = true;
                    break;
                }
                j++;
            }
            if(!foundPrefix)
            {
                result = result + word + " ";
            }
        }
        
        return result.substring(0, result.length() - 1); //remove the last space
    }
    
    //time - O(length of word)
    //space - O(length of largest word in the trie)
    private void buildTrie(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++)
        {
            char current = word.charAt(i);
            if(temp.children[current - 'a'] == null)
            {
                temp.children[current - 'a'] = new TrieNode(false, new TrieNode[26]);
            }
            temp = temp.children[current - 'a'];
        }
        temp.isWord = true;
        return;
    }
    
    //time - O(length of prefix)
    //space - O(1)
    private boolean findPrefix(String prefix) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char current = prefix.charAt(i);
            if(temp.children[current - 'a'] == null)
            {
                return false;
            }
            temp = temp.children[current - 'a'];
        }
        return temp.isWord;
    }
}
