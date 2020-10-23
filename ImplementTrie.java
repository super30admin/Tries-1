/*Time Complexity: O(n)
Space Complexity: O(n)*/

class TrieNode
{
    private TrieNode[] links;
    private final int num_chars = 26;
    private boolean isWord;

    public TrieNode()
    {
        links = new TrieNode[num_chars];
    }

    public void setEnd()
    {
        isWord = true;
    }

    public void put(char ch, TrieNode node)
    {
        links[ch-'a'] = node;
    }

    public boolean containsKey(char ch)
    {
        return links[ch-'a'] != null;
    }

    public TrieNode get(char ch)
    {
        return links[ch-'a'];
    }

    public boolean isEnd()
    {
        return isWord;
    }
}

class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode node = root;
        for(int i = 0 ; i<word.length() ; i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word)
    {
        TrieNode node = root;
        for(int i = 0 ; i<word.length() ; i++)
        {
            char ch = word.charAt(i);
            if(node.containsKey(ch))
            {
                node = node.get(ch);
            }
            else
            {
                return null;
            }
        }

        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;

    }
}
