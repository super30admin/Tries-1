// Time Complexity : Insert O(n) where n is the length of the word
// Search  O(n) where n is the length of the word (worst case if searched and found)
// starts with O(n) where n is the length of the word to be found

// Space Complexity : for each level we create array of 26 so we will create n times such arrays(since n=word length) for m words 
// so O(m*n) n=word length m=words....or O(n) where n = the number of unique trienodes in trie ds 

// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/* 
For trie, remember to have 
TrieNode class which has isEnd(boolean) array of 26 TrieNode called as children for each alphabet

In trie class have a TrieNode head, and TrieNode temp (to traverse)

While inserting abcdef, head->a->b->c->d->e->f->isEnd
for a, b isEnd = false

for search traverse from head->a->b->c->d->e->f->isEnd
return true if isEnd = true
else while checking at a and b if it is null return null straightaway


for startsWith abcd in abcdefg,
while traversing from a->b->c->d if at any point temp.children[ch-'a'] is null return false
if end is reached return true
*/
class Trie {
    TrieNode head;
    TrieNode temp;

    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
        temp = head;
    }

    /** Inserts a word into the trie. */
    // O(n) where n is the length of the word
    public void insert(String word) {
        temp = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode();
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        temp = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.children[ch - 'a'] == null)
                return false;
            temp = temp.children[ch - 'a'];
        }
        return temp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        temp = head;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (temp.children[ch - 'a'] == null)
                return false;
            temp = temp.children[ch - 'a'];
        }

        return true;
    }
}

public class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */