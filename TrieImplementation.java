class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean exist;
    public TrieNode() {}
}
class Trie {
    TrieNode trie;
    public Trie() {
        trie = new TrieNode();
    }
    //Time complexity is O(N) N is length of word
    //Space complexity is O(N)
    public void insert(String word) {
        TrieNode node = trie;
        for(Character ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node=node.children.get(ch);
        }
        node.exist=true;
    }
    //Time complexity is O(N) N is length of word
    //Space complexity is O(1)
    public boolean search(String word) {
        TrieNode node = trie;
        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            if(!node.children.containsKey(ch)){
                return false;
            }
            else{
                node=node.children.get(ch);
            }
        }
        return node.exist;
    }
    //Time complexity is O(N) N is length of word
    //Space complexity is O(1)
    public boolean startsWith(String word) {
        TrieNode node = trie;
        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            if(!node.children.containsKey(ch)){
                return false;
            }
            else{
                node=node.children.get(ch);
            }
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
 */