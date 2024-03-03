// Time complexity: Insert - O(l), search - O(l), startsWith - O(l) where l = length of string
// Space: no aux space used

// Approach: Creating a TrieNode class which stores if string is ending there and it's children

class Trie {
    private class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.isEnd = isEnd;
            // for 26 letters (lowercase english)
            this.children = new TrieNode[26];
        }
    }

    TrieNode head;

    public Trie() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = head;

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            // if character is not present in the Trie
            if (currentNode.children[current - 'a'] == null) {
                currentNode.children[current - 'a'] = new TrieNode();
            }
            currentNode = currentNode.children[current - 'a'];
        }

        // currentNode is pointing to the last element
        currentNode.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = head;

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (currentNode.children[current - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.children[current - 'a'];
        }

        return currentNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = head;

        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            if (currentNode.children[current - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.children[current - 'a'];
        }

        return true;
    }
}
