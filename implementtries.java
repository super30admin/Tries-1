/*
Tc --> O(n)
Sc --> O(26*L)
 */
class Node {

    Node[] links;
    boolean flag;

    public Node() {
        links = new Node[26];
        flag = false;
    }
}

class Trie {

    Node head;

    public Trie() {

        head = new Node();

    }

    public void insert(String word) {
        int val = 0;
        Node curr = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            val = c - 'a';
            if (curr.links[val] == null) {
                curr.links[val] = new Node();

            }
            curr = curr.links[val];

        }//for
        curr.flag = true;

    }

    public boolean search(String word) {
        Node curr = head;
        int val;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            val = c - 'a';
            if (curr.links[val] == null) {
                return false;
            }
            curr = curr.links[val];
        }//for

        return curr.flag;

    }

    public boolean startsWith(String prefix) {
        Node curr = head;
        int val;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            val = c - 'a';
            if (curr.links[val] == null) {
                return false;
            }
            curr = curr.links[val];
        }//for

        // if(curr.flag==false) {
        //     return true;
        // }
        // return false;
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
