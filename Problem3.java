class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        StringBuilder sb = new StringBuilder();

        Trie trie = new Trie();

        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] words = (sentence + " ").split(" ");

        for (String word : words) {
            sb.append(trie.findPrefix(word));
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
        
    }
}

class Trie {

    public TrieNode root;

    public Trie () {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currNode = this.root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            currNode.child.putIfAbsent(c, new TrieNode());
            currNode = currNode.child.get(c);
        }

        currNode.word = word;
    }

    public String findPrefix(String word) {

        TrieNode currNode = this.root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if (currNode.word != null) return currNode.word;
            
            if (currNode.child.containsKey(c)) {
                currNode = currNode.child.get(c);
            } else {
                return word;
            }
            
        }
        return word;
    }

}

class TrieNode {

    public Map<Character, TrieNode> child;
    public String word;

    public TrieNode () {
        this.child = new HashMap<>();
        this.word = null;
    }

}