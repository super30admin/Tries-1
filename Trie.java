// Time Complexity : O(n * w) [w: number of characters in each word;]
// Space Complexity : O(n * w)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Trie {
    TrieNode parent;

    public Trie() {
        parent = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.parent;
        char a = 'a';
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (null == curr.children[ch - a]) {
                curr.children[ch - a] = new TrieNode();
            }

            curr = curr.children[ch - a];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.parent;
        char a = 'a';
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (null == curr.children[ch - a]) {
                return false;
            }
            curr = curr.children[ch - a];
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.parent;
        char a = 'a';
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(null == curr.children[ch-a]) {
                return false;
            }

            curr = curr.children[ch - a];
        }

        return true;
    }
}

class TrieNode {
    boolean end;
    TrieNode[] children;

    TrieNode() {
        this.children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */