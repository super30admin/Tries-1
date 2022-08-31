public class TrieNode {
    boolean isEnd;
    TrieNode[] children;
    TrieNode()
    {
        children = new TrieNode[26];
    }
}
