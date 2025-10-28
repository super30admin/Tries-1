class Solution {

    Trie trie;

    public String longestWord(String[] words) {

        this.trie = new Trie();

        Arrays.sort(words, (a, b) -> a.compareTo(b));

        String longestWord = "";

        for (String word : words) {
            boolean isIncrementPresent = trie.insert(word);
            if (isIncrementPresent && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
        
    }
}

class Trie {

    TrieNode root;

    public Trie () {
        this.root = new TrieNode();
    }

    public boolean insert(String word) {

        boolean isIncrementPresent = true;

        TrieNode currNode = this.root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if ((!currNode.child.containsKey(c) || currNode.child.get(c).isEnd != true) && i < (word.length()-1)) {
                isIncrementPresent = false;
            } 

            currNode.child.putIfAbsent(c, new TrieNode());
            currNode = currNode.child.get(c);
        }

        currNode.isEnd = true;

        return isIncrementPresent;
    }

}

class TrieNode {
    public Map<Character, TrieNode> child;
    public boolean isEnd;

    public TrieNode () {
        this.child = new HashMap<>();
        this.isEnd = false;
    }
}