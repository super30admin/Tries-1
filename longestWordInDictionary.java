/*
Problem: https://leetcode.com/problems/longest-word-in-dictionary/
*/
class TrieNode {
    TrieNode children[] = null;
    boolean isEndOfWord = false;
    
    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root = null;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void buildTrie(String words[]) {
        for (String word : words) {
            insert(word);
        }
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEndOfWord = true;
    }
    
    public TrieNode getRoot() {
        return root;
    }
}

class Solution {
    Trie trie = null;
    
    public String longestWord(String[] words) {
        trie = new Trie();
        trie.buildTrie(words);
        String answer = "";
        
        for (String word : words) {
            TrieNode cur = trie.getRoot();
            boolean foundWord = true;
            
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                
                if (cur.children[index] == null) {
                    foundWord = false;
                    break;
                }
                cur = cur.children[index];
                if (!cur.isEndOfWord) {
                    foundWord = false;
                    break;
                }
            }
            
            if (foundWord) {
                if (word.length() > answer.length() || (word.length() == answer.length() && answer.compareTo(word) > 0)) {
                    answer = word;
                }
            }
        }
        
        return answer;
    }
}


// BFS Solution
class TrieNode {
    TrieNode children[] = null;
    String word;
    
    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }
}

class Trie {
    TrieNode root = null;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void buildTrie(String words[]) {
        for (String word : words) {
            insert(word);
        }
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.word = word;
    }
    
    public TrieNode getRoot() {
        return root;
    }
}

class Solution {
    Trie trie = null;
    
    public String longestWord(String[] words) {
        trie = new Trie();
        trie.buildTrie(words);
        TrieNode cur = trie.getRoot();
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(cur);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int i = 25; i >= 0; --i) {
                if (cur.children[i] != null && cur.children[i].word != null) {
                    queue.offer(cur.children[i]);
                }
            }
        }
        
        if (cur.word == null) return "";
        return cur.word;
    }
}