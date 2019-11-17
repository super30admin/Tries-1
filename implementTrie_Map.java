/* if the longest length of the word is N, the height of the Trie will be N+1.
Therefore, the time complexity of all insert, search and startsWith methods will be O(N).
Space Complexity: M words to insert and N - length of the longest word, at most 
(m*n) nodes worst case. Max of K different characters (26 here). each node will have a map whose size is at most K.

Hence the Space Complexity: O(m*n*K)
*/


class Trie {

    class Node{
        boolean isWord;
        Map<Character, Node> childrenMap = new HashMap<>();
    }

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
            if(temp.childrenMap.get(curChar) == null){
                //insert a new node if the path does not exist
                temp.childrenMap.put(curChar, new Node());
            }
            temp = temp.childrenMap.get(curChar);
        }
        temp.isWord = true;
    }

    public Node searchPrefix(String word){
        Node temp = root;
        for(int i=0; i < word.length(); i++){
            char curChar = word.charAt(i);
            if(temp.childrenMap.containsKey(curChar))
                temp = temp.childrenMap.get(curChar);
            else
                return null;
        }
        return temp;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isWord;
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