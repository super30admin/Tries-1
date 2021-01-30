/**


Leetcode: https://leetcode.com/problems/replace-words/

Collabedit: http://collabedit.com/buupv

In English, we have a concept called root, which can be followed 
by some other word to form another longer word - let's call this word successor. 
For example, when the root "a
n" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words 
separated by spaces, replace all the successors in the sentence with the root forming it.
 If a successor can be replaced by more than one root, replace it with the
  root that has the shortest length.

Return the sentence after the replacement.

Time Complexity : O(N)
Space Complexity : O(N*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
class Solution 
{
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        TrieDataStructure trie = new TrieDataStructure();
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for( String word: dictionary)
        {
            trie.insert(word);
        }
        
        String inputs [] = sentence.split(" ");
        
        for( String current: inputs)
        {
            String replaced = trie.search(current);
            stringBuilder.append(replaced + " ");
        }
        
        return stringBuilder.toString().trim();
    }
}

class TrieNode
{
    public boolean isEnd;
    public TrieNode children[];
    
    public TrieNode()
    {
        this.children = new TrieNode[26];
    }
}

class TrieDataStructure
{
    private TrieNode root;
    
    public TrieDataStructure()
    {
        this.root = new TrieNode();
    }
    
    public void insert( String word)
    {
        TrieNode current = this.root;
        
        for( int i=0; i< word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            
            if(current.children[index] == null)
            {
                current.children[index] = new TrieNode();
            }
        
            current = current.children[index];
        }
        
        current.isEnd = true;
    }
    
    public String search( String word)
    {
        TrieNode current = this.root;
        String replaced = "";
        
        
        for( int i=0; i< word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            
            if(current.children[index] == null)
            {
                return word;
            }
        
            current = current.children[index];
            
            replaced = replaced + word.charAt(i);
            
            if( current.isEnd) break;
        }
        
        return replaced;    
    }
    
}