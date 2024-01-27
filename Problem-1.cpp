// 208. Implement Trie (Prefix Tree)

// Time Complexity : O(n*k) where k - length of words

// Space Complexity : O(n*k)

// Did this code successfully run on Leetcode : YES

// Appoarch: Tries - construct a trie and insert a word, search for a word or check starts with.

#include <bits/stdc++.h>
using namespace std;

class Trie {
    private:
        bool isEnd;
        vector<Trie*> children;
    public: 
    Trie() : children(26,NULL), isEnd(false)
    { }
    
    void insert(string word) {
        Trie* curr = this;
        for(int i=0;i<word.length();i++){
            if(curr->children[word[i] - 'a'] == NULL){
                curr->children[word[i] - 'a'] = new Trie();
            }
            curr = curr->children[word[i] - 'a'];
        }
        curr->isEnd = true;
    }
    
    bool search(string word) {
        Trie* curr = this;
        for(int i=0;i<word.length();i++){
            if(curr->children[word[i] - 'a'] == NULL) return false;
            curr = curr->children[word[i] - 'a'];
        }
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        Trie* curr = this;
        for(int i=0;i<prefix.length();i++){
            if(curr->children[prefix[i] - 'a'] == NULL) return false;
            curr = curr->children[prefix[i] - 'a'];
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