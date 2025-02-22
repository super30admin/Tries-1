public class Trie {
    static class Node {
        Node[] children = new Node[26];
        boolean eow;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) { // O(n)
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) { // O(n)
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public boolean startsWith(String prefix) { // O(n)
        int level = 0;
        int len = prefix.length();
        int idx = 0;

        Node curr = root;
        for (; level < len; level++) {
            idx = prefix.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String args[]) {
        Trie trie = new Trie();
        String words[] = {"the", "a", "there", "their", "any", "thee"};
        for (String word : words) {
            trie.insert(word);
            System.out.println("inserted " + word);
        }

        System.out.println("thee -> " + trie.search("thee")); // Should return true
        System.out.println("thor -> " + trie.search("thor")); // Should return false

        System.out.println(trie.startsWith("the")); // Should return true
        System.out.println(trie.startsWith("thi")); // Should return false
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */