// Time Complexity : O(L*N) where L is the average length of words and N is the total number of words
// Space Complexity : O(L*N) - space consumed by the Trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I add all the words into the trie and perform dfs on the trie as a whole. For each recursive call, I maintain the word that has been formed so far. If the word's length is greater than the resultant, 
replace the resultant with the word formed so far and continue the process until all nodes of the trie are visited
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

    public TrieNode root;

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
}

public class Solution {
    private Trie trie;
    private string result;

    public string LongestWord(string[] words) {
        trie = new();
        TrieNode temp = trie.root;
        result = "";

        foreach(string word in words)
        {
            trie.Insert(word);
        }

        DFS(temp, new StringBuilder());

        return result;
    }

    public void DFS(TrieNode temp, StringBuilder tempWord)
    {
        // Base condition
        if(tempWord.Length > result.Length)
        {
            result = tempWord.ToString();
        }

        for(int i = 0; i < 26; i++)
        {
            if(temp.next[i] != null && temp.next[i].isEnd)
            {
                tempWord.Append((char)('a' + i));
                DFS(temp.next[i], tempWord);
                tempWord.Remove(tempWord.Length-1,1);
            }
        }

    }
}