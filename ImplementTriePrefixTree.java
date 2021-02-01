// Time Complexity : O(m), where m is the length of words
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class ImplementTriePrefixTree {

    class Trie {

        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            //initialize root to any character, root node is a dummy node
            root = new Node('\0');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            //initialize curr to root and then check if node exist else create node and insert character
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null) curr.children[c - 'a'] = new Node(c);// add node with character if it doesn't exist
                curr = curr.children[c-'a']; //set current node value
            }
            curr.isWord=true;//set flag to true to indicate the

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            //use helper method to get to check if returned object is not null and isWord is set to true else return false
            Node node = getNode(word);
            return node != null && node.isWord;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            //use helper method and check if returned object is not null
            return getNode(prefix) != null;
        }

        //helper function to loop trough trie and return last node of string
        private Node getNode(String s){
            Node curr = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(curr.children[c-'a'] == null) return null;
                curr = curr.children[c-'a'];
            }
            return curr;//getting last character
        }
    }

    class Node{
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c){
            this.c = c;
            this.isWord = false;
            children = new Node[26];
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
