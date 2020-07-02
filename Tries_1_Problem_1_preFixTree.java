//Time Complexity : O(n) (insertion and searching)
//Space Complexity : O(n) in worst case we might have to create a new node everytime in insertion
//Runs successfully on leetcode
//No problem

//Here we will be generating a tree like structure with 26 character array in each node
//There will also be a boolean variable to show the ending of the word.


public class Tries_1_Problem_1_preFixTree {

    TrieNode root;
    /** Initialize your data structure here. */
    public Tries_1_Problem_1_preFixTree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0 ; i < word.length() ; i ++)
        {
            if(temp.children[word.charAt(i) - 'a'] == null)
            {
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i)- 'a'];
        }
        temp.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0 ; i < word.length() ; i ++)
        {
            if(temp.children[word.charAt(i)-'a'] == null)
            {
                return false;
            }
            else
            {
                temp = temp.children[word.charAt(i)-'a'];
            }
        }

        if(temp.isEnd == true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i = 0 ; i < prefix.length() ; i ++)
        {
            if(temp.children[prefix.charAt(i)-'a'] == null)
            {
                return false;
            }
            else
            {
                temp = temp.children[prefix.charAt(i)-'a'];
            }
        }
        return true;
    }
}

class TrieNode
{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode()
    {
        isEnd = false;
        children = new TrieNode[26];
    }

}