// TC = O(nk)
// SC = O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    class TrieNode {
        public:
            vector<TrieNode*> children;
            bool isEnd;
            TrieNode() {
                this->children.resize(26, NULL);
                this->isEnd = false;
            }
    };
    TrieNode *root;
    string maxStr;
    void insert(string word) {
        TrieNode *curr = root;
        for(char c : word) {
            if(curr->children[c - 'a'] == NULL) 
                curr->children[c - 'a'] = new TrieNode();
            curr = curr->children[c - 'a'];
        }
        curr->isEnd = true;
    }
    string longestWord(vector<string>& words) {
        root = new TrieNode();
        maxStr = "";
        for(string word: words) 
            insert(word);
        backtrack(root, "");
        return maxStr;
    }
    void backtrack(TrieNode *curr, string currStr) {
        // base
        if(currStr.size() > maxStr.size())
            maxStr = currStr;
        // logic
        for(int i = 0; i < 26; i++) {
            if(curr->children[i] != NULL && curr->children[i]->isEnd) {
                int l = currStr.size();
                currStr += (char)i + 'a'; // action
                backtrack(curr->children[i], currStr); // recurse
                currStr.resize(l); // backtrack
            }
        }
    }
};