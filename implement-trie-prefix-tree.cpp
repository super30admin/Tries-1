// TC = Insert - O(L), Search - O(L), startsWith - O(L)
// SC = O(1) for all 3 functions, for C^r O(n * L * 26) ~ O(n * L) n = no. of words, L = length of longest word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Trie {
public:
    class TrieNode {
    public:
        bool isEnd; // end of the word
        vector<TrieNode*> children;
        TrieNode() { // C^r
            isEnd = false;
            children.resize(26); // 1 trie is made up of 25 TrieNodes
        }
    };
    TrieNode* root; // object
    Trie() { // C^r
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode* curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word[i];
            if (curr->children[c - 'a'] == nullptr) { // checking if already exists
                curr->children[c - 'a'] = new TrieNode(); // if not, create
            }
            curr = curr->children[c - 'a']; // moving curr to next curr in children
        }
        curr->isEnd = true; // mark the last char as end
    }
    
    bool search(string word) {
        TrieNode* curr = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word[i];
            if (curr->children[c - 'a'] == nullptr) return false;
            curr = curr->children[c - 'a'];
        }
        if(curr->isEnd == true) return true;
        return false;
    }
    
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        for (int i = 0; i < prefix.length(); i++)
        {
            char c = prefix[i];
            if (curr->children[c - 'a'] == nullptr) return false;
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