public class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode root;
    public TrieNode() {
        children = new TrieNode[26];
    }
}
