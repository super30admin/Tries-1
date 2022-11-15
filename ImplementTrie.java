//TC: O(length) for insert, search and start with
//SC: O(length) for insert and SC: O(1) for search and start with
//works in leetcode

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i< word.length();i++){
            char ch = word.charAt(i);

            TrieNode child = node.children[ch-'a'] == null? new TrieNode():node.children[ch-'a'];

            node.children[ch-'a'] = child;
            node = child;
        }
        node.isWord=true;
    }

    public boolean search(String word) {
        TrieNode node= root;
        for(int i=0; i< word.length();i++){
            char ch = word.charAt(i);
            if(node.children[ch-'a'] == null)
                return false;
            node = node.children[ch-'a'];
        }

        return node.isWord ? true:false;

    }

    public boolean startsWith(String prefix) {
        TrieNode node= root;
        for(int i=0; i< prefix.length();i++){
            char ch = prefix.charAt(i);
            if(node.children[ch-'a'] == null)
                return false;
            node = node.children[ch-'a'];
        }

        return true;

    }
}

class TrieNode{
    TrieNode [] children;
    boolean isWord;

    public TrieNode (){
        children = new TrieNode[26];
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */