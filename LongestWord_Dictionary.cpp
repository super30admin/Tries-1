#include<iostream>
#include<vector>
using namespace std;
class Solution {
    struct TrieNode {
        TrieNode* child[26];
        bool isEnd;
        TrieNode() {
            for(int i = 0; i < 26; i++) 
                child[i] = nullptr;
            isEnd = false;
        }
    };
    TrieNode* root;
    string ans;
public:
    Solution() {
        root = new TrieNode();
        ans = "";
    }
    void dfs(TrieNode* curr, string& path) {
        if(ans.length() < path.length()) {
            ans = path;
        }
        for(int i = 0; i < 26; i++) {
            if(curr->child[i] != nullptr && curr->child[i]->isEnd) {
                int size = path.length();
                path.push_back((char)(i + 'a'));
                dfs(curr->child[i], path);
                path.resize(size);
            }
        }
    }
    void insert(string word) {
        TrieNode* curr = root;
        for(char ch : word) {
            if(curr->child[ch - 'a'] == nullptr) {
                curr->child[ch - 'a'] = new TrieNode();
            }
            curr = curr->child[ch - 'a'];
        }
        curr->isEnd = true;
    }
    string longestWord(vector<string>& words) {
        for(string x : words) {
            insert(x);
        }
        string path;
        dfs(root, path);
        return ans;
    }
    
};