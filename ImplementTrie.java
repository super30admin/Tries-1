class Trie {

    class TrieNode{
        TrieNode[] childrens;
        boolean isWord;

        public TrieNode(){
            childrens = new TrieNode[26];
            isWord = false;
        }
    }


    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new TrieNode();
            }

            curr = curr.childrens[ch-'a'];
        }

        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */


    public boolean search(String word) {
        TrieNode curr = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(curr.childrens[ch-'a'] == null){
                return false;
            }

            curr = curr.childrens[ch-'a'];
        }

        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);

            if(curr.childrens[ch-'a'] == null){
                return false;
            }

            curr = curr.childrens[ch-'a'];
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