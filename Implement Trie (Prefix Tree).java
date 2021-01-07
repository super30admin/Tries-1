/*
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.islast = False
class Trie:
    
    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        cur = self.root
        for i in range(len(word)):
            if cur.children[ord(word[i]) - ord('a')] is None:
                cur.children[ord(word[i]) - ord('a')] = TrieNode()
            cur = cur.children[ord(word[i]) - ord('a')]
        cur.islast = True
        

    def search(self, word: str) -> bool:
        cur = self.root
        for i in range(len(word)):
            if cur.children[ord(word[i]) - ord('a')] is None:
                return False
            cur = cur.children[ord(word[i]) - ord('a')]
        return cur.islast
        

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for i in range(len(prefix)):
            if cur.children[ord(prefix[i]) - ord('a')] is None:
                return False
            cur = cur.children[ord(prefix[i]) - ord('a')]
        return True
*/

// Time Complexity : O(N) where n is length of word or prefix whichever is greater
// Space Complexity : O(1) as there are 26 alphabets only
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach: I created a new TrieNode of length 26 at every letter and just inserted
// the word by calculating index by c - 'a'

class TrieNode{
    boolean isLast;
    TrieNode[] children;
    
    public TrieNode(){
        children = new TrieNode[26];
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
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isLast = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isLast;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}
        