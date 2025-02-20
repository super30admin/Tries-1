class Trie {
    class Node {
        boolean isEnd;
        Node[] arr;
        
        public Node() {
            isEnd = false;
            arr = new Node[26];
        }
    }
    
    Node rootN;

    public Trie() {
        rootN = new Node();
    }
    
    public void insert(String word) {
        Node curNode = rootN;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.arr[c - 'a'] == null) {
                curNode.arr[c - 'a'] = new Node();
            }
            curNode = curNode.arr[c - 'a'];
        }
        curNode.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curNode = rootN;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.arr[c - 'a'] == null) {
                return false;
            }
            curNode = curNode.arr[c - 'a'];
        }
        return curNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curNode = rootN;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curNode.arr[c - 'a'] == null) {
                return false;
            }
            curNode = curNode.arr[c - 'a'];
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
 *
