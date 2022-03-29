//tc: insert = o(length of the word)
//sc = o(length of the word)
//find = o(1)

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

    public boolean search(String word) {


        TrieNode node = root;
        for (int i = 0 ; i < word.length(); ++i)
        {
            char c = word.charAt(i);

            if(node.children[c-'a'] == null)
            {
                return false;
            }
            node = node.children[c-'a'];

        }
        if (node.end==true)
            return true;
        else
            return false;
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */