//TC: O(n*m) for insertion O(num of words without prefix value + num of words with prefix value * max prefix value)
//Space C: O(n*m) at insertion
//Executed on leetcode.
class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode()
        {
            children = new TrieNode[26];		//Designed a DS for Trie Node to store each character level by level.
            isWord = false;
        }
    }
    TrieNode root;
    
    void insert(List<String> dictionary)
    {
        for(String dic : dictionary)
        {
            TrieNode curr = root;
            for(int i=0;i<dic.length();i++)
            {
                if(curr.children[dic.charAt(i)-'a']==null)	//Inserting all the dictionary words in TrieNode character format
                    curr.children[dic.charAt(i)-'a'] = new TrieNode();
                curr = curr.children[dic.charAt(i)-'a'];
            }
            curr.isWord = true;
        }
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {        
        StringBuilder output = new StringBuilder();
        
        if(dictionary.size()==0 || sentence.length()==0)
            return output.toString();
        root = new TrieNode();
        insert(dictionary);
        
        String[] eachWord = sentence.split(" ");		//After that splitting the given sentence to array of Strings
        for(String word: eachWord)
        {
            if(root.children[word.charAt(0)-'a']==null)		//if the first character of the string is not root of the trie node add the string to output.
                if(output.length()==0)
                    output.append(word);
                else
                {
                    output.append(" ");			//if first char is available finding if the prefix is available or not
                    output.append(word);
                }
            else
            {
                if(output.length()==0)
                    output = output.append(successor(word));
                else
                {
                    output.append(" ");
                    output.append(successor(word));
                }
            }
            
        }
        
        return output.toString();
    }
    
    String successor(String word)
    {
        TrieNode curr = root;
        StringBuilder succ = new StringBuilder();
        for(int i=0;i<word.length();i++)			//Checks untill the word length or untill trie node has the char.
        {											//if we found first shortest prefix we return the string.
            if(curr.isWord)
                    return succ.toString();			//if we do not find the prefix string we return the same word.
                else
                    succ = succ.append(word.charAt(i));
            if(curr.children[word.charAt(i)-'a']!=null)
            {
                curr = curr.children[word.charAt(i)-'a'];
            }
            else
            {
                break;
            }        
            
        }
        
        return word;
    }
    
}