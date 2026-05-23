// Time Complexity : O(l) where l is the length of the word(for Insert, Search and StartsWith)
// Space Complexity : O(L*n) where is the L is the average length of words and n is the total number of words
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I implement the Trie by creating a TrieNode class. For inserting a word into the trie, I get the root of the TrieNode and check one by one if each character of the word is present in the Trie, if not 
I add it to it. At the end, I mark the last character isEnd = true to signify the end of the word. 

For searching and starts with, I check if the input word provided is present in the Trie. If not I return false. In case of searching, I additionally also check if the last character's isEnd = true, 
which signifies that the word is present in the trie.
*/

public class TrieNode
{
    public bool isEnd;

    public TrieNode[] next;

    public TrieNode()
    {
        next = new TrieNode[26];
        isEnd = false;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new();
    }
    
    public void Insert(string word) {
        
        TrieNode temp = root;
        
        for(int i = 0; i < word.Length; i++)
        {
            int index = word[i] - 'a';
            
            if(temp.next[index] == null)
            {
                temp.next[index] = new TrieNode();
            }

            temp = temp.next[index];
        }

        temp.isEnd = true;
    }
    
    public bool Search(string word) {
        
        TrieNode temp = LastLetter(word);
        
        return temp!=null && temp.isEnd;
    }
    
    public bool StartsWith(string prefix) {
        
        TrieNode temp = LastLetter(prefix);

        return temp!=null;
    }

    private TrieNode LastLetter(string word)
    {
        TrieNode temp = root;

        for(int i = 0; i < word.Length; i++)
        {
            int index = word[i] - 'a';
            
            if(temp.next[index] == null)
            {
                return null;
            }

            temp = temp.next[index];
        }

        return temp;
    }
}