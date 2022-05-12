/* 
    Time Complexity                              :  O(Sum of length of all the words) - this is the time
                                                    taken to insert each word in the trie and in
                                                    worst case to search the each word in the words list.
    Space Complexity                             :  O(Sum of length of all the words) - stored in the trie
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/longest-word-in-dictionary/submissions/

class TrieNode {
public:
    bool isEnd;
    vector<TrieNode*> children;
    TrieNode() {
        this->isEnd = false;
        children.resize(26,nullptr);
    }  
};

class Trie {

private:
    TrieNode *root;
    
public: 
    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode *rt = root;
        for(auto ch : word) {
            if(rt->children[ch - 'a'] == nullptr) {
                rt->children[ch - 'a'] = new TrieNode();
            }
            rt = rt->children[ch - 'a'];
        }
        rt->isEnd = true;
    }
    
    bool search(string word) {
        TrieNode *rt = root;
        for(auto ch : word) {
            if(rt->children[ch - 'a'] == nullptr)
                return false;
            rt = rt->children[ch - 'a'];
        }
        return rt->isEnd;
    }
    
    bool hasPrefix(string word) {
        TrieNode *rt = root;
        for(auto ch : word) {
            if(rt == root or rt->isEnd == true) {
                rt = rt->children[ch - 'a'];
                continue;
            }
            return false;
        }
        return true;
    }
};



class Solution {
public:
    string longestWord(vector<string>& words) {
        Trie *trie = new Trie();
        string ans = "";
        int pc = 0;
        for(auto word : words) {
            trie->insert(word);
        }
        
        for(auto word : words) {
            if(word.size() >= ans.size() and trie->hasPrefix(word) == true) {
                if(word.size() > ans.size()) {
                    ans = word;
                } else {
                    ans = min(word,ans);
                }
                
            }
        }
        
        return ans;
    }
};