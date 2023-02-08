// Time Complexity : O(NK)
// Space Complexity : O(NK)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// N is the number of words in dictionary & K is the average length of each word in dictionary

public class LongestWordInDictionary {

    static class LongestWordInDictionaryBFS {

        TrieNode root;

        class TrieNode {
            boolean isEnd;
            TrieNode[] children;
            String word;

            public TrieNode() {
                this.children = new TrieNode[26];
                this.word = "";
            }
        }

        private void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
            curr.word = word;
        }

        public String longestWord(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                insert(word);
            }

            Queue<TrieNode> q = new LinkedList<>();
            q.add(root);

            TrieNode curr = null;
            while (!q.isEmpty()) {
                curr = q.poll();
                for (int i = 25; i >= 0; i--) {
                    if (curr.children[i] != null && curr.children[i].isEnd) {
                        q.add(curr.children[i]);
                    }
                }
            }
            return curr.word;
        }
    }

    static class LongestWordInDictionaryDFS {

        TrieNode root;
        String result;

        class TrieNode {
            boolean isEnd;
            TrieNode[] children;
            char ch;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        private void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
                curr.ch = c;
            }
            curr.isEnd = true;
        }

        public String longestWord(String[] words) {
            result = "";
            root = new TrieNode();
            for (String word : words) {
                insert(word);
            }
            backtrack(root, new StringBuilder());
            return result;
        }

        private void backtrack(TrieNode root, StringBuilder path) {
            if (path.length() > result.length()) {
                result = path.toString();
            }
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null && root.children[i].isEnd) {
                    path.append(root.children[i].ch);
                    backtrack(root.children[i], path);
                    path.setLength(path.length() - 1);
                }
            }
        }
    }
}