// 648. Replace Words

// Time Complexity : O(n*k)[insertion] + (m*k)[checking] where k - length of words

// Space Complexity : O(n*k)

// Did this code successfully run on Leetcode : YES

// Appoarch: Tries - construct a trie and insert the words, check if each word can be replaces, 
// if yes then create a new string, add space and return.

#include <bits/stdc++.h>
using namespace std;

class Trie{
    public:
        bool isEnd;
        vector<Trie*> children; 
        Trie() : children(26,NULL), isEnd(false){}
};
class Solution {
    Trie* newNode;
public:
    Solution() : newNode(new Trie()) {}
    string check(string word){
        Trie* root = newNode;
        string s = "";
        for(auto i : word){
            if (root->isEnd) return s;  // Stop if a valid prefix is found
            if (!root->children[i - 'a']) break;
            s += i;
            root = root->children[i - 'a'];
        }
        return word;
    }
    void insert(string word) {
        Trie* curr = newNode;
        for(int i=0;i<word.length();i++){
            if(curr->children[word[i] - 'a'] == NULL){
                curr->children[word[i] - 'a'] = new Trie();
            }
            curr = curr->children[word[i] - 'a'];
        }
        curr->isEnd = true;
    }
    string replaceWords(vector<string>& dictionary, string sentence) {
        for(auto d:dictionary) insert(d);
        stringstream ss(sentence);
        string word = "",ans="";
        while(ss>>word){
            ans += check(word);
            ans += " ";
        }
        ans.pop_back();
        return ans;
    }
};