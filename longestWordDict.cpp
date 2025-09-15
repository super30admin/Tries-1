#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We insert all the words into a Trie so we can easily explore valid prefixes.
Then we do a DFS from the root and only go deeper if the path so far forms a valid word.
The longest such path is saved as the result.
*/
class Solution{
    struct TrieNode{
        TrieNode* children[26];
        bool isEnd;

        TrieNode(){
            for(int i=0; i<26; i++) children[i] = nullptr;
            isEnd = false;
        }
    };
    TrieNode* root;
    string result;
public:
    Solution(){
        root = new TrieNode();
        result = "";
    }
    void insert(string word){
        TrieNode* curr = root;
        for(char c : word){
            if(curr->children[c-'a'] == nullptr)
                curr->children[c-'a'] = new TrieNode();
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
    }

    string longestWord(vector<string>& words){
        for(string word : words) insert(word);
        string path;
        dfs(root, path);
        return result;
    }

    void dfs(TrieNode* curr, string& path){
        if(result.length() < path.length()) result = path;
        for(int i=0; i<26; i++){
            if(curr->children[i] != nullptr && curr->children[i]->isEnd){
                int len = path.length();
                path.push_back((char)(i+'a'));
                dfs(curr->children[i], path);
                path.resize(len);
            }
        }
    }

};
