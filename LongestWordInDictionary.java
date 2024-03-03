// Time complexity: O(n * l) where n = number of words and l = average length of each word
// space complexity: O(n * l) for trie

// Approach: Using trie and iterating only if there is a word existing at each level;
// If there is "w, wo, wor" : At each level of the trie there is a word; hence keep iterating
// and match with the result; else stop

class LongestWordInDictionary {
    String res = "";

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.isEnd = false;
            // for 26 letters (lowercase english)
            this.children = new TrieNode[26];
        }
    }

    class Trie {

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
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        TrieNode node = trie.head;
        StringBuilder sb = new StringBuilder();

        dfs(node, sb);
        return res;
    }

    private void dfs(TrieNode node, StringBuilder sb) {
        if (node.isEnd && sb.length() > res.length()) {
            res = sb.toString();
        }

        for (int i = 0; i < 26; i++) {
            // iterating only if word exists in the dictionary
            if (node.children[i] != null && node.children[i].isEnd) {
                char curr = (char) ('a' + i);
                sb.append(curr);
                dfs(node.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}