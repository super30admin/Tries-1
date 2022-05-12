/* 
    Time Complexity                              :  Insert, Search, StartsWith - O(N) where N is the
                                                    length of the word
    Space Complexity                             :  O(1) - Since this is what is expected as a result
                                                    In general it should be m*n*27 where m is the number
                                                    of strings stored, n is the average size of each string
                                                    and 27 is the total size per node of the trie
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode {
 public:
    bool isEnd;
    vector<TrieNode*> children;
    
    TrieNode() {
        isEnd = false;
        children.resize(26,nullptr);
    }
};

class Trie {
public:
    TrieNode *root;
    Trie() {
       root = new TrieNode(); 
    }
    
    void insert(string word) {
        TrieNode *rt = root;
        for(char ch : word) {
            if(rt->children[ch - 'a'] == nullptr) {
                rt->children[ch - 'a'] = new TrieNode();
            }
            rt = rt->children[ch - 'a'];
        }
        rt->isEnd = true;
    }
    
    bool search(string word) {
        TrieNode *rt = root;
        for(char ch : word) {
            if(rt->children[ch - 'a'] == nullptr) return false;
            rt = rt->children[ch - 'a'];
        }
        
        return rt->isEnd;
    }
    
    bool startsWith(string prefix) {
        TrieNode *rt = root;
        for(char ch : prefix) {
            if(rt->children[ch - 'a'] == nullptr) return false;
            rt = rt->children[ch - 'a'];
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