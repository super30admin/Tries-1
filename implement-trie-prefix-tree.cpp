// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
  
using namespace std; 

class TrieNode {
public:
    // marker for end of word
    bool isEnd;

    // stores references
    TrieNode* children[26];

    // Constructor
    TrieNode() : isEnd(false) {
        for (int i = 0; i < 26; i++) {
            children[i] = nullptr;
        }
    }
};

class Trie {
private:
    TrieNode* root;

public:
    // Initialize your data structure here.
    Trie() {
        // init empty trie
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    void insert(string word) {
        TrieNode* cursor = root;
        for (char c : word) { // iterate
            if (cursor->children[c - 'a'] == nullptr) { // create if null
                cursor->children[c - 'a'] = new TrieNode();
            }
            cursor = cursor->children[c - 'a']; // update cursor
        }
        cursor->isEnd = true; // mark end
    }

    // Returns if the word is in the trie.
    bool search(string word) {
        TrieNode* cursor = root;
        for (char c : word) { // iterate
            if (cursor->children[c - 'a'] == nullptr) { // miss
                return false;
            }
            cursor = cursor->children[c - 'a']; // update cursor
        }
        return cursor->isEnd;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    bool startsWith(string prefix) {
        TrieNode* cursor = root;
        for (char c : prefix) { // iterate
            if (cursor->children[c - 'a'] == nullptr) { // miss
                return false;
            }
            cursor = cursor->children[c - 'a']; // update cursor
        }
        return true;
    }
};
