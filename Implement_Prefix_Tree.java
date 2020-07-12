/**
 * Time: O(n) n- length of the input string
 * Space: O(n)
 */
class TNode{
    TNode[] child;
    boolean isEnd;

    public TNode() {
        child = new TNode[26];
        isEnd = false;
    }
}
class Trie {

    /** Initialize your data structure here. */
    TNode obj;
    public Trie() {
        obj = new TNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TNode newobj = obj;
        int size = 0;
        while(size<word.length()){
            if(newobj.child[word.charAt(size)-'a'] == null)
                newobj.child[word.charAt(size)-'a'] = new TNode();
            newobj = newobj.child[word.charAt(size)-'a'];
            size++;
        }
        newobj.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TNode newobj = obj;
        int size = 0;
        while(size<word.length()){
            if(newobj.child[word.charAt(size)-'a'] == null) return false;

            newobj = newobj.child[word.charAt(size)-'a'];
            size++;
        }
        if(newobj.isEnd == false) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TNode newobj = obj;
        int size = 0;
        while(size<word.length()){
            if(newobj.child[word.charAt(size)-'a'] == null) return false;

            newobj = newobj.child[word.charAt(size)-'a'];
            size++;
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