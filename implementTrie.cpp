// Time Complexity : O(L) where L is the length of the word
// Space Complexity : O(L)  
// Did this code successfully run on Leetcode : Yes 

// Creating a TrieNode with a 26 length vector and isEnd to mark the end of a word 
// if a letter is present, the a'th element is linked to another TrieNode which records the next letter or end of word 


//TrieNode to capture the hashset of length 26 and isEnd to mark the end of word
class TrieNode {
public:
    bool isEnd;
    vector<TrieNode*> children;
    TrieNode() {
        isEnd = false;
        children = vector<TrieNode*> (26, NULL);
    }
};

class Trie {
public:
    TrieNode* root;
    Trie() {
        root = new TrieNode();
    }
    
    // [c - 'a'] is updated with a pointer to a new trieNode
    // at the end, add the word end marker 
    void insert(string word) {
        TrieNode* curr = root;
        for(char c: word){
            if(curr->children[c-'a'] == NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
    }
    
    bool search(string word) {
        TrieNode* curr = root;
        for(char c:word){
            if(curr->children[c-'a'] == NULL)
                return false;
            curr = curr->children[c-'a'];
        }
        return(curr->isEnd);
    }
    
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        for(char c:prefix){
            if(curr->children[c-'a'] == NULL)
                return false;
            curr = curr->children[c-'a'];
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