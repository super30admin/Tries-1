/*
Problem: https://leetcode.com/problems/replace-words/
TC:
To build trie: O(n * k)  + O(m, l) where 
    n = size of dictionary and k is the max length of a string in dictionary
    m = number of words in sentence and l is the max length of a word in sentence.

SC: O(26n + m * l) -> 26n for trie nd m*l for storing split array
*/
class TrieNode {
    TrieNode children[];
    boolean isWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void buildTrie(List<String> dictionary) {
        for (String s : dictionary) {
            insert(s);
        }
    }
    
    public void insert(String s) {
        TrieNode cur = root;
        
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }
    
    public String getPrefix(String s) {
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int index = c - 'a';
            
            if (cur.isWord || cur.children[index] == null) {
                break;
            } 
            sb.append(c);
            cur = cur.children[index];
        }
        
        if (cur.isWord) {
            return sb.toString();
        } else {
            return s;
        }
    }
}


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || dictionary.size() == 0) {
            return sentence;
        }
        
        Trie t = new Trie();
        t.buildTrie(dictionary);
        
        StringBuilder result = new StringBuilder();
        String words[] = sentence.split(" ");
        
        for (int i = 0; i < words.length; ++i) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(t.getPrefix(words[i]));
        }
        
        return result.toString();
    }
}