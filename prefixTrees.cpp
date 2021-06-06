// Time Complexity :O(m) where m is length of word that is being inserted or searched
// Space Complexity : O(n) where n is the size of Trie 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TrieNode {
public:
    bool isEnd;
    //TrieNode *children[26] = {};
    vector<TrieNode*> children;
        
    TrieNode(){
        isEnd = false;
        /*for(int i = 0; i< 26;i++){
            children[i] == NULL;
        }*/
        children.resize(26);
    }
};
class Trie {
    TrieNode *root;
public:
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode *curr = root;
        for(int i = 0;i<word.length();i++){
            char c = word[i];
            if(!curr->children[c - 'a'])
                curr->children[c - 'a'] = new TrieNode();
            curr = curr->children[c - 'a'];
        }
        curr->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode *curr = root;
        for(int i = 0;i<word.length();i++){
            char c = word[i];
            if(!curr->children[c - 'a']) return false;
            curr = curr->children[c - 'a'];
        }
        return curr->isEnd == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode *curr = root;
        for(int i = 0;i<prefix.length();i++){
            char c = prefix[i];
            if(!curr->children[c - 'a']) return false;
            curr = curr->children[c - 'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */