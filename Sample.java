## Problem1 
Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

// Time Complexity - time complexity of Trie operations (insert, search, startsWith) is O(n), where n is the length of the word. 
// Space Complexity - 0(n) where n is the length of the word.

class Trie {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}




## Problem2
Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

// Time Complexity - 0(m * n)
// Space Complexity - 0(m * n)

class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    TrieNode root;
    
    private void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        root = new TrieNode();
        for (String word : words) {
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        
        q.add(root);
        TrieNode curr = root;
        
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i = 25; i >= 0; i--) {
                if(curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}




## Problem3
Replace Words (https://leetcode.com/problems/replace-words/)

// Time Complexity - 0(m * n + k * m) time complexity for constructing the Trie is O(m * n) and time complexity for word replacement is O(k * m)
// Space Complexity - 0(m * n + k * m)

class Solution {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;

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
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }
        root = new TrieNode();
        for(String word : dictionary) {
            insert(word);
        }
        String[] strArray = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < strArray.length; i++) {
            if(i != 0) {
                result.append(" ");
            }
            String word = strArray[i];
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if(curr.children[c - 'a'] == null || curr.isEnd) {
                    break;
                }
                replacement.append(c);
                curr = curr.children[c - 'a'];
            }
            if(curr.isEnd) {
                result.append(replacement);
            }
            else {
                result.append(word);
            }
        }
        return result.toString();
    }
}