// Time Complexity : insert O(n) n - length of word search O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0;i<word.length();i++){
            char val = word.charAt(i);
            Map<Character, TrieNode> children = current.children;
            if(!children.containsKey(val)){
                current.children.put(val, new TrieNode());
            }
            current = current.children.get(val);
        }
        current.eof = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0;i<word.length();i++){
            char val = word.charAt(i);
            Map<Character, TrieNode> children = current.children;
            if(!children.containsKey(val)){
                return false;
            }
            current = current.children.get(val);
        }
        return current.eof;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0;i<prefix.length();i++){
            char val = prefix.charAt(i);
            Map<Character, TrieNode> children = current.children;
            if(!children.containsKey(val)){
                return false;
            }
            current = current.children.get(val);
        }
        return true;
    }
}
class TrieNode{
    Map<Character, TrieNode> children;
    boolean eof;
    TrieNode(){
        eof = false;
        children = new HashMap<>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
