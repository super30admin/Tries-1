#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We create each Trie node with a 26-sized array for all lowercase letters.
While inserting or searching, we index using c - 'a' to navigate the array.
The isEnd flag helps us check if it's an exact word or just a path prefix.
*/
class Trie{
    struct TrieNode{
        TrieNode* children[26];
        bool isEnd;
        TrieNode(){
            for(int i=0; i<26; i++){
                children[i] = nullptr;
            }
            isEnd = false;
        }
    };
    TrieNode* root;
public:
    Trie(){
        root = new TrieNode();
    }
    void insert(string word){
        TrieNode* curr = root;
        for(char c : word){
            int index = c - 'a';
            if(curr->children[index] == nullptr) 
                curr->children[index] = new TrieNode();
            curr->children[index];
        }
        curr->isEnd = true;
    }

    bool search(string word){
        TrieNode* curr = root;
        for(char c : word){
            int index = c - 'a';
            if(curr->children[index] == nullptr)
                return false;
            curr = curr->children[index];    
        }
        return curr->isEnd;
    }

    bool startsWith(string prefix){
        TrieNode* curr = root;
        for(char c : prefix){
            int index = c -'a';
            if(curr->children[index] == nullptr)
                return false;
            curr = curr->children[index];
        }
        return true;
    }

};
