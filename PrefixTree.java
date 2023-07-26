// Time Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Space Complexity :O(n*l) where n is the number of words and l is the avg length of each word
// Did this code successfully run on Leetcode :yes

class Trie {
    class TrieNode{
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;
        for(int i =0; i< word.length(); i++){
            Character c = word.charAt(i);
            if(current.children[c-'a'] == null){
                TrieNode newNode = new TrieNode();
                current.children[c-'a'] = newNode;
                current = newNode;
            }else{
                current = current.children[c-'a'];
            }
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i =0; i< word.length(); i++){
            Character c = word.charAt(i);
            if(current.children[c-'a'] == null){
                return false;
            }else{
                current = current.children[c-'a'];
            }
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i =0; i< prefix.length(); i++){
            Character c = prefix.charAt(i);
            if(current.children[c-'a'] == null){
                return false;
            }else{
                current = current.children[c-'a'];
            }
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