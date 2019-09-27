/*
The time complexity for every insertion, search or startsWith is O(len) where len is the length of the word.
The space complexity in the worst case is O(sum of length of all words)

The intuition here is to traverse through the each charater of the string. When the character is present move to next else insert the char
and move.

Yes, the solution passed all the test cases in leetcode.
 */
class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode('1');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;

        for(int i=0;i<word.length();i++){
            if(temp.map.containsKey(word.charAt(i))){
                temp = temp.map.get(word.charAt(i));
            }
            else{
                temp.map.put(word.charAt(i),new TrieNode(word.charAt(i)));
                temp = temp.map.get(word.charAt(i));
            }
        }

        temp.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode node = searchNode(word);
        if(node!=null && node.isWord){
            return true;
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        TrieNode node = searchNode(prefix);
        if(node!=null){
            return true;
        }

        return false;
    }

    public TrieNode searchNode(String word){
        TrieNode ret = root;
        for(int i=0;i<word.length();i++){
            if(ret.map.containsKey(word.charAt(i))){
                ret = ret.map.get(word.charAt(i));
            }
            else{
                return null;
            }
        }

        return ret;
    }

}

class TrieNode {
    char c;
    HashMap<Character,TrieNode> map;
    boolean isWord;

    TrieNode(char c){
        this.c = c;
        map = new HashMap<>();
        isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */