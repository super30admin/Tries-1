//Time Complexity : O(no. of words in dict * avg word length)
//Space Complexity : O(n) stack space

class Solution {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        //we are maintaing an extra char at each node
        char ch;

        public TrieNode()
        {
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String word)
    {
        TrieNode current = root;
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            if(current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode();
            current = current.children[c - 'a'];
            current.ch = c;
        }
        current.isEnd = true;
    }

    //global variable for recursion
    String result;

    public String longestWord(String[] words) {

        result = "";
        root = new TrieNode();

        //insert all words in trie
        for(int i=0; i<words.length; i++)
        {
            insert(words[i]);
        }

        dfs(root, new StringBuilder());

        return result;

    }

    //root is current node here
    private void dfs(TrieNode root, StringBuilder path)
    {
        //base
        if(path.length() > result.length())
        {
            result = path.toString();
        }

        //logic

        //iterate over all the children
        for(int i=0; i<26; i++)
        {
            if(root.children[i] != null && root.children[i].isEnd)
            {
                //action
                path.append(root.children[i].ch);
                //recurse
                dfs(root.children[i], path);
                //backtrack
                path.setLength(path.length() - 1);
            }
        }
    }
}
