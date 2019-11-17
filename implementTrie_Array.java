/* 208. Implement Trie (Prefix Tree)
Insert - TC: O(n) where n is the length of the word
        SC : O(n) In the worst case newly inserted key doesn't share a prefix with the the keys already inserted in the trie. We have to add 'n' new nodes, which takes us O(n) space.

Search - TC: O(n) SC: O(1)
StartsWith - TC: O(n) SC: O(1)
*/

class Node{
    private Node[] links;
    private final int R = 26;
    private boolean isEnd;

    public Node(){
        links = new Node[R];
    }

    public void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    public Node get(char ch){ // each char will have a array of 26 nodes a-z
        return links[ch - 'a'];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}

class Trie {

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++){
            char curChar = word.charAt(i);
            if(!temp.containsKey(curChar)){
                temp.put(curChar, new Node());
            }
            temp = temp.get(curChar);
        }
        temp.setEnd();
    }

    // search for a prefix or whole word in the trie and returns the node where search ends
    public Node searchPrefix(String word){
        Node temp = root;

        for(int i=0; i<word.length(); i++){
            char curChar = word.charAt(i);
            if(!temp.containsKey(curChar))
                return null;
            else
                temp = temp.get(curChar);
        }
        return temp;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */