//
// Created by shazm on 8/8/2019.
//

#include <iostream>
#include <algorithm>
#include <array>

using namespace std;

class TrieNode{
    array<TrieNode*,26> links;
    bool isEnd = false;

public:
    TrieNode(){
        for(int i = 0; i<links.size(); i++){
            links[i] = NULL;
        }
    }
    void put(char ch, TrieNode* node){
        links[ch-'a'] = node;
    }
    bool contains(char ch){
        return links[ch-'a']!=NULL;
    }
    TrieNode* get(char ch){
        return links[ch-'a'];
    }
    bool getEnd(){
        return isEnd;
    }
    void setEnd(){
        isEnd = true;
    }

};
class Trie {
public:
    TrieNode* root;
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode;
    }

    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* node = root;
        for(int i = 0; i<word.size(); i++){
            char curr = word[i];
            if(!node->contains(curr)){
                node->put(curr, new TrieNode);
            }
            node = node->get(curr);
        }
        node->setEnd();
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* node = searchPrefix(word);
        return node!=NULL && node->getEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        return searchPrefix(prefix)!=NULL;
    }
private:
    TrieNode* searchPrefix(string word){
        TrieNode* node = root;
        for(int i = 0; i<word.size(); i++){
            char curr = word[i];
            if(node->contains(curr)){
                node = node->get(curr);
            }else{return NULL;}
        }
        return node;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */