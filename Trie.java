//Time Complexity O(N)
//space complexity O(26*M*N)
//leetcode tested

class Trie {
    private Trie children[];
    private boolean isEndOfWord;
    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }

    public void insert(String word) {
        Trie current = this;
        for (char c:word.toCharArray()) {
            if(current.children[c-'a'] == null)
                current.children[c-'a'] = new Trie();
            current = current.children[c-'a'];
        }
        current.isEndOfWord=true;
    }

    public boolean search(String word) {
        Trie current = this;
        for (char c:word.toCharArray()) {
            current = current.children[c-'a'];
            if(current == null) return false;
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (char c:prefix.toCharArray()) {
            current = current.children[c-'a'];
            if(current == null) return false;
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
