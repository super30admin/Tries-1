// Time Complexity : O(nklog(n))
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class TrieNode {
public:
    char c;
    TrieNode* arr[26];
    bool isWord;
    bool isValid;

    TrieNode(char c) : c(c), isWord(false), isValid(false) {
        for (int i = 0; i < 26; i++) {
            arr[i] = nullptr;
        }
    }
};

class Solution {
public:
    string longestWord(vector<string>& words) {
        sort(words.begin(), words.end());
        string retWord = "";

        TrieNode* root = new TrieNode('-');
        root->isValid = true;

        for (const string& word : words) {
            if (insert(root, word)) {
                if (word.length() > retWord.length()) {
                    retWord = word;
                }
            }
        }

        return retWord;
    }

    bool insert(TrieNode* root, const string& word) {
        TrieNode* temp = root;
        TrieNode* prev = root;
        int newCount = 0;

        for (char c : word) {
            if (temp->arr[c - 'a'] != nullptr) {
                prev = temp;
                temp = temp->arr[c - 'a'];
            } else {
                newCount++;
                prev = temp;
                temp->arr[c - 'a'] = new TrieNode(c);
                temp = temp->arr[c - 'a'];
            }
        }

        temp->isWord = true;

        if (newCount == 1) {
            if (prev->isValid) {
                temp->isValid = true;
                return true;
            }
            return false;
        }

        return false;
    }
};
