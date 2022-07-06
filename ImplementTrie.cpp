// Time Complexity - O(L) for insert(), search(), startsWith().
// Space Complexity - O(1) for insert(), search(), startsWith(). For my constructor -> O(n*l), where, 'n' is number of words and 'l' is the average length of words.
// Problems Faced - No!
// It runs on Leetcode!
class Trie {
    struct TrieNode{
        bool isEnd; 
        TrieNode* children[26] = {NULL};
        public: TrieNode(){
            isEnd = false;
        }
    };
    TrieNode* root;
    
public:
    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode* curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word[i];
            int index = word[i] - 'a';
            if(curr->children[index] == NULL)
                curr->children[c-'a'] = new TrieNode();
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
        
    }
    
    bool search(string word) {
        TrieNode* curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word[i];
            if(curr->children[c-'a'] == NULL)
                return false;
            curr = curr->children[c-'a'];
        }
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix[i];
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