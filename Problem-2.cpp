// 720. Longest Word in Dictionary

// Time Complexity : O(n*k) + (n+k)(checkforprefix) where k - length of words

// Space Complexity : O(n*k)

// Did this code successfully run on Leetcode : YES

// Appoarch: Tries - construct a trie and insert the words, check if each char has an
// isEnd flag, if yes then find the longest word with the smallest lexo order and return.

#include <bits/stdc++.h>
using namespace std;

class Trie{
    public:
    bool isEnd;
    vector<Trie*> child;
    Trie() : child(26,NULL) , isEnd(false) {}
};
class Solution {
    Trie* newNode;
public:
    Solution() : newNode(new Trie()) {}
    bool ifPrefixExists(string word){
        Trie* root = newNode;
        for(auto i : word){
            if(root->child[i - 'a']){
                root = root->child[i - 'a'];
                if(!root->isEnd) return false;
            }
        }
        return true;
    }
    void insert(string word){
        Trie* root = newNode;
        for(auto i : word){
            if(root->child[i - 'a'] == NULL){
                root->child[i - 'a'] = new Trie();
            }
            root = root->child[i - 'a'];
        }
        root->isEnd = true;
    }
    string longestWord(vector<string>& words) {
        for(auto w : words){
            insert(w);
        }
        string longest = "";
        for(auto w : words){
            if(ifPrefixExists(w)){
                if(w.length() > longest.length()){
                    longest = w;
                }
                else if(w.length() == longest.length() && w < longest){
                    longest = w;
                }
            }
        }
        return longest;
    }
};