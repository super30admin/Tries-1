// Time Complexity:O(nk)
// Space Complexity: 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * 1 - Create a Trie DS and insert all the words in the dictionary inside the Trie
 * 2 - Use DFS with backtracking to traverse the Trie
 */
public class Longest {
    class TrieNode{
        boolean isEnd;
        TrieNode children[];
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

TrieNode root;
StringBuilder sb;

public void insert(String word)
{
    TrieNode curr = root;
    for(int i = 0; i < word.length();i++)
    {
        char c = word.charAt(i);
        if(curr.children[c - 'a'] == null){
            curr.children[c - 'a'] = new TrieNode();
        }
        curr = curr.children[c - 'a'];
    }
    curr.isEnd = true;
}

public String longestWord(String[] words) {
    root = new TrieNode();
    sb = new StringBuilder();
    
    for(String word: words)
    {
        insert(word);
    }
    backtrack(root, new StringBuilder());
    return sb.toString();
}

private void backtrack(TrieNode curr,StringBuilder currStr){
    //base
    if(currStr.length() > sb.length())
    {
        sb = new StringBuilder(currStr);
    }
    //logic
    for(int i = 0; i < 26;i++)
    {
        if(curr.children[i] != null && curr.children[i].isEnd)
        {
            int le = currStr.length();
            //action
            currStr.append((char)(i + 'a'));
            //recurse
            backtrack(curr.children[i],currStr);
            //backtrack
            currStr.setLength(le);
        }
    }
}
}
