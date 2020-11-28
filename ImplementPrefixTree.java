// Time Complexity :  O(N) chars in sentencce
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class TrieNode{
    boolean end;
    //char val
    Map<Character, TrieNode> map;//children
    TrieNode(){
        map = new HashMap<>();
        end = false;
    }
    public boolean isEnd(){
        return end;
    }
    public void setEnd(){
        end = true;
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        char[] arr = word.toCharArray();
        for(int i = 0; i< arr.length; i++){
            if(!node.map.containsKey(arr[i]))
               node.map.put(arr[i], new TrieNode());
            node = node.map.get(arr[i]);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        char[] arr = word.toCharArray();
        for(int i = 0; i< arr.length; i++){
            if(!node.map.containsKey(arr[i]))
               return false;
            node = node.map.get(arr[i]);
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] arr = prefix.toCharArray();
        for(int i = 0; i< arr.length; i++){
            if(!node.map.containsKey(arr[i]))
               return false;
            node = node.map.get(arr[i]);
        }
        return node!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */