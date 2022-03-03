/**
 * @Time Complexity: 
 * O(n) where n is the length of the word
 * 
 */

/**
 * @Space Complexity:
 * O(1), for internal stack
 * 
 */

// The code ran perfectly on leetcode

class Trie {
    class TrieNode{
        public:
      bool isEnd;
        vector<TrieNode*> children;
        public:
        TrieNode(){
            children.resize(26);
            isEnd = false;
        }
    };
    
    TrieNode *root;
public:
    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode *curr = root;
        for(char c: word){
            if(curr->children[c-'a'] == NULL)
                curr->children[c - 'a'] = new TrieNode();
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
        
    }
    
    bool search(string word) {
        TrieNode *curr = root;
        for(char c: word){
            if(curr->children[c-'a'] == NULL)
                return false;
            curr = curr->children[c - 'a'];
        }
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        TrieNode *curr = root;
        for(char c: prefix){
            if(curr->children[c-'a'] == NULL)
                return false;
            curr = curr->children[c - 'a'];
        }
        return true;
    }
};