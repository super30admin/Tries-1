// Time Complexity : O(N) N is the length of sentence. we are traversing each char at max once only
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use Trie to compute this. store all the dictionary words in trie first
//Now for each word in the sentence look for its prefix in the trie
//If its there then break at that time and append the answer string
//Else just add the original.

class Solution {
    public String replaceWords(List<String> rootWords, String sentence) {
        //TC: r*list of sentence + words * length of word
        //SC : R* length of root
        Trie trie = new Trie();

        for(String rootWord : rootWords)
        {
            trie.insert(rootWord);
        }

        String[] words= sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(String word : words)
        {
            if(res.length() > 0)
            {
                res.append(" ");
            }
            String prefixWord = trie.getPrefixWord(word);

            if(prefixWord == null)
            {
                res.append(word);
            }
            else
            {
                res.append(prefixWord);
            }
        }
        return res.toString();

    }
}

class TrieNode {

    TrieNode[] children;
    boolean end;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.end = false;
    }
}

class Trie{

    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode node = root;
        for (int i =0; i < word.length(); ++i)
        {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null)
            {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.end= true;
    }

    public String getPrefixWord(String word)
    {
        TrieNode node = root;
        for (int i =0; i < word.length(); ++i)
        {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null)
            {
                return null;
            }
            node= node.children[c-'a'];

            if(node.end)
            {
                return word.substring(0, i+1);
            }
        }
        return null;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0 ; i < prefix.length(); ++i)
        {
            char c = prefix.charAt(i);
            if(node.children[c-'a'] == null)
            {
                return false;
            }
            node = node.children[c-'a'];
        }
        return true;
    }
}