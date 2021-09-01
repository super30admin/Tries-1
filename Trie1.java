//https://leetcode.com/problems/implement-trie-prefix-tree/
/*
Time: Insert, search, startsWith is O(N)
Space: Insert O(N), Search & startsWith is O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class Trie1 {

    private Node root;

    public Trie() 
    {
        root = new Node('\0'); //empty character
        
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Node(c);

            curr = curr.children[c - 'a']; // if the char exists, keep moving through it's children

        }

        curr.isWord = true; // end of word flag
    }

    public boolean search(String word) {
        Node node = getNode(word);

        return node != null && node.isWord;

    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null)
                return null;

            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    class Node {
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }

}
