// Time Complexity : O(n) no of keys in trie
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        
        Trie trie = new Trie();
        for(String word : dictionary) {
            trie.insert(word);
        }
        
        String[] sent = sentence.split(" ");
        for(int i = 0;i<sent.length;i++) {
            sent[i] = trie.replaceWord(sent[i]);
        }
        
        String ans = sent[0];
        for(int i = 1;i<sent.length;i++) {
            ans += " " + sent[i] ;
        }
        
        return ans; 
    }
}

class TrieNode {
    
    String word;
    HashMap<Character, TrieNode> childrens;
    
    public TrieNode() {
        this.childrens = new HashMap(26);
        this.word = "";
    }
    
}

class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            
            if(!curr.childrens.containsKey(c)) {
                curr.childrens.put(c, new TrieNode());
            }
            curr = curr.childrens.get(c);
            
        }
        curr.word = word;
        
    }
    
    /** Returns if the word is in the trie. */
    public String replaceWord(String word) {
        
        TrieNode curr = root;

        
        for(char c : word.toCharArray()) {
            
            if(!curr.childrens.containsKey(c)) break;
            curr = curr.childrens.get(c);
            
            if(!curr.word.equals("")) {
                return curr.word;
            }
            
            
        }
        return curr.word.equals("")?word:curr.word;
    }
    
    
}
