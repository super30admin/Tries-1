#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
First we build a Trie using all the words from the dictionary.
Then we go word by word in the sentence and check for the shortest prefix match in the Trie.
If a match is found, we use that word; if not, we keep the original word.
*/
class Solution{
    struct TrieNode{
        TrieNode* children[26];
        bool isEnd = false;
    };
    TrieNode* root = new TrieNode();
    void insert(const string& word){
        TrieNode* curr = root;
        for(char c : word){
            if(!curr->children[c - 'a'])
                curr->children[c-'a'] = new TrieNode();
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
    }

    string getShortestVersion(const string& word){
        TrieNode* curr = root;
        string result = "";
        for(char c : word){
            if(!curr->children[c-'a'] || curr->isEnd) break;
            curr = curr->children[c-'a'];
            result += c;
        }
        return curr->isEnd ? result : word;
    }
public:
    string replaceWord(vector<string>& dictionary, string sentence){
        for(const string& word : dictionary) insert(word);
        stringstream ss(sentence);
        string word, result;
        bool first = true;
        while(ss << word){
            if(!first) result += " ";
            result += getShortestVersion(word);
            first = false;
        }
        return result;
    }
};
