// Time Complexity : O(M*N + L*N)
// Space Complexity : O(M*N + L*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I insert all the words of the dictionary into the trie. I then go across each word in the sentence and check one by one if their characters are present in the trie, if any of the character has an associated
isEnd = true, this indicates the end of the word of the dictionary and I replace it with the equivalent word in the sentence. If not, I leave the word in the sentence as it is.
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
    public Trie trie;
    public TrieNode temp;

    public string ReplaceWords(IList<string> dictionary, string sentence) {
        trie = new();
        temp = trie.root;

        foreach(string word in dictionary)
        {
            trie.Insert(word);
        }

        string[] words = sentence.Split(' ');

        for(int i = 0; i < words.Length; i++)
        {
            string replacement = DFS(temp, words[i], 0, "");
            words[i] = replacement;
        }

        string originalSentence = string.Join(" ", words);

        return originalSentence;
    }

    public String DFS(TrieNode temp, string word, int i, string replacement)
    {
        if(temp == null)
        {
            return word;
        }

        if(temp.isEnd)
        {
            return replacement;
        }

        if (i >= word.Length)
        {
            return word;
        }

        int index = word[i] - 'a';
        
        if (temp.next[index] == null)
        {
            return word;
        }

        replacement += word[i];
        return DFS(temp.next[index], word, i + 1, replacement);

    }
}