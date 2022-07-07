/*
This approach uses a Trie to find the words to be replaced. First, we store all the roots in the dictionary into a Trie. Then,
we go over each word in the string, and check to see if there is a corresponding root for that particular word in the Trie,
and then replace that word accordingly

Did this code run on leetcode: Yes
*/
class Solution {
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        
        TrieNode()
        {
            children = new TrieNode[26];
        }
    
 
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++)
        {   
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
        
    }
    }
    
    TrieNode root;
    
    //Time Complexity: O(N*L) N = no. of words in sentence, L = average length of each word
    public String replaceWords(List<String> dictionary, String sentence) {
        
        root = new TrieNode();
        //Adding the roots to the Trie
        for(String str: dictionary)
            root.insert(str);
        
        //Initiating a result string to store the result
        StringBuilder result = new StringBuilder();
        //We split the sentence into an array of words for easier processing
        String[] words = sentence.split(" ");
        StringBuilder replace;
        
        for(int i = 0; i < words.length; i++)
        {
            String word = words[i];
            TrieNode curr = root;
            replace = new StringBuilder();
            //For each word, we check if it has a prefix/root inside the Trie, and we also keep track of it using a variable replace
            for(int j = 0; j < word.length(); j++)
            {
                char c = word.charAt(j);
                // If we reach an end on the Trie for a particular word, or if we go through the Trie and are not able to find an end, we exit the loop.
                if(curr.children[c - 'a'] == null || curr.isEnd)
                    break;
                
                replace.append(c);
                curr = curr.children[c - 'a'];
            }
            //Only if we found an end inside the Trie, we will append the replace variable to replace the word, otherwise we will append the word itself
            if(curr.isEnd)
                result.append(replace);
            else 
                result.append(word);
            
            result.append(" ");
        }
        
        result.deleteCharAt(result.length() - 1);
        
        return result.toString();
    }
}

