// Time Complexity : O(L) where L is the length of the word
// Space Complexity : O(N*K) where N is length of word and K is space used for building the Trie
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Trie {
public:
    class TrieNode{
        public:
        vector<TrieNode*> child;
        bool isEnd;
        TrieNode(){
            child = vector<TrieNode*>(26, NULL) ;
            isEnd = false;
        }
    };
    TrieNode* root;
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* curr = root;
        for(int i=0; i<word.size(); i++){
            char c = word[i];
            if(curr->child[c - 'a'] == NULL){
                curr->child[c - 'a'] = new TrieNode();
            }
            curr = curr->child[c - 'a'];
        }
        curr->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word[i];
            if(curr->child[c - 'a'] == NULL)
                return false;
            curr = curr->child[c - 'a'];
        }
        return curr->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix[i];
            if(curr->child[c - 'a'] == NULL)
                return false;
            curr = curr->child[c - 'a'];
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
