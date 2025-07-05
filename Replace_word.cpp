
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    struct TrieNode {
        TrieNode* child[26] = {};
        bool isEnd = false;
    };
    TrieNode* root = new TrieNode();
    string helper(const string& word) {
        TrieNode* curr = root;
        string ans = "";
        for (char ch : word) {
            if (!curr->child[ch - 'a'] || curr->isEnd) 
                break;
            curr = curr->child[ch - 'a'];
            ans += ch;
        }
        return curr->isEnd ? ans : word;
    }
    void insert(const string& word) {
        TrieNode* curr = root;
        for (char ch : word) {
            if (!curr->child[ch - 'a']) {
                curr->child[ch - 'a'] = new TrieNode();
            }
            curr = curr->child[ch - 'a'];
        }
        curr->isEnd = true;
    }
    string replaceWords(vector<string>& dictionary, string sentence) {
        for (string& x: dictionary) {
            insert(x);
        }
        stringstream ss(sentence);
        string word,ans;
        bool flag = true;
        while (ss >> word) {
            if (!flag) 
                ans += " ";
            ans += helper(word);
            flag = false;
        }
        return ans;
    }
};