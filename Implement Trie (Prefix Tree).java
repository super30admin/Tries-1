// Time Complexity : O(m), m is #chars in word for insert,search,startsWith
// Space Complexity : O(C), C is total chars in dictionary for trie, O(m) for insert, O(1) for search and startsWith

// Your code here along with comments explaining your approach
// form trie node using hashmap mapping from Character to TrieNode
// add words to trie, mark end with isEnd
// traverse trie node for search, startsWith, insert new word

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEnd;
    
    public TrieNode(){
        children = new HashMap<>();
        isEnd = false;
    }
}

class Trie {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        
        for(char ch : word.toCharArray()){
            if(!cur.children.containsKey(ch)){
                cur.children.put(ch, new TrieNode());
            }
            
            cur = cur.children.get(ch);    
        }
        
        cur.isEnd = true; 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        
        for(char ch : word.toCharArray()){
            if(!cur.children.containsKey(ch)){
                return false;
            }
            
            cur = cur.children.get(ch);    
        }
        
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for(char ch : prefix.toCharArray()){
            if(!cur.children.containsKey(ch)){
                return false;
            }
            
            cur = cur.children.get(ch);    
        }
        
        return true;
    }
}
