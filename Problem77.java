// Time Complexity : O(n*m log n) 
// Space Complexity : O(m*n)

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        String word = null;          
    }

    private TrieNode root = new TrieNode();

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
        node.word = word;
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);

        for (String word : words) {
            insert(word);
        }

        String result = "";
        Queue<TrieNode> queue = new LinkedList<>();

        for (TrieNode child : root.children) {
            if (child != null && child.isEnd) {
                queue.offer(child);
            }
        }

        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
t
            if (node.word.length() > result.length()) {
                result = node.word;
            }
            for (TrieNode child : node.children) {
                if (child != null && child.isEnd) {
                    queue.offer(child);
                }
            }
        }

        return result;
    }
}