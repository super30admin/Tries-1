class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length() || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                StringBuilder sb = new StringBuilder();
                for (char ch : word.toCharArray()) {
                    sb.append(ch);
                    if (!trie.search(sb.toString())) {
                        break;
                    }
                } 
                if(sb.toString().equals(word)) {
                    if(sb.length() > longestWord.length()) {
                        longestWord = sb.toString();
                    }
                    else if(sb.length() == longestWord.length() && sb.toString().compareTo(longestWord) < 0) {
                        longestWord = sb.toString();   
                    }
                }
            }
        }
        return longestWord;
    }
    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for(char ch : word.toCharArray()) {
                if(curr.nodes[ch-'a'] == null) {
                    curr.nodes[ch-'a'] = new TrieNode();
                }
                curr = curr.nodes[ch-'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for(char ch : word.toCharArray()) {
                if(curr.nodes[ch-'a'] == null) {
                    return false;
                }
                curr = curr.nodes[ch-'a'];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(char ch : prefix.toCharArray()) {
                if(curr.nodes[ch-'a'] == null) {
                    return false;
                }
                curr = curr.nodes[ch-'a'];
            }
            return true;
        }

        class TrieNode{
            boolean isEnd;
            TrieNode[] nodes;
            public TrieNode() {
                isEnd = false;
                nodes = new TrieNode[26];
            }
        }
    }
}
