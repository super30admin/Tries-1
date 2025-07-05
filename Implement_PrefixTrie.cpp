#include<iostream>
#include<vector>
using namespace std;
class Trie {
    class TrieNode {
    public:
        bool isEnd;
        vector<TrieNode*> children;

        TrieNode() {
            isEnd = false;
            children = vector<TrieNode*>(26, nullptr); 
        }
    };
    TrieNode* root;
public:
    Trie() {
        root = new TrieNode();
    }
    void insert(string word) {
        TrieNode* curr = root;
        for (char c : word) {
            if (curr->children[c - 'a'] == nullptr) {
                curr->children[c - 'a'] = new TrieNode();
            }
            curr = curr->children[c - 'a'];
        }
        curr->isEnd = true;
    }
    bool search(string word) {
        TrieNode* curr = root;
        for (char c : word) {
            if (curr->children[c - 'a'] == nullptr) {
                return false;
            }
            curr = curr->children[c - 'a'];
        }
        return curr->isEnd;
    }
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        for (char c : prefix) {
            if (curr->children[c - 'a'] == nullptr) {
                return false;
            }
            curr = curr->children[c - 'a'];
        }
        return true; 
    }
};
