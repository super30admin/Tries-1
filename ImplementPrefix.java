//Time Complexity:O(n)
//Space Complexity:O(n)

class ImplementPrefix {

    class TrieNode{
        TrieNode child[];
        boolean isEnd;

        public TrieNode(){
            child = new TrieNode[26];
        }
    }

    TrieNode root;
    public ImplementPrefix() {

        root = new TrieNode();
    }
    public void insert(String word) {

        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.child[c-'a'] == null){
                curr.child[c-'a'] = new TrieNode();
            }
            curr = curr.child[c-'a'];
        }
        curr.isEnd = true;

    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(curr.child[c-'a'] == null){
                return false;
            }
            curr = curr.child[c-'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.child[c-'a'] == null){
                return false;
            }
            curr = curr.child[c-'a'];
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