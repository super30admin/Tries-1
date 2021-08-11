// Time complexity- insert(O(word-length)) search(O(n)) startswith-O(n)
// space complexity O(n*k*n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// create a class with array of size 26 to store each character of a word
// have a variable to help keep track of when the word ends
// the array helps to enable a constant look up for each alphabet


#include<algorithm>
#include<iostream>
#include <sstream>
#include<vector>
#include<stack>

using namespace std;
class Trie {
public:
    
    /** Initialize your data structure here. */
    Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie* node =this;
        for(auto ch : word){
            ch -='a';
            if(node->child[ch]== nullptr){
                node->child[ch] = new Trie();
            }
            node = node->child[ch];
        }
        node->isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie* node = this;
        for(auto ch : word){
            ch -= 'a';
            if(node->child[ch]== nullptr){
                return false;
            }
            node = node->child[ch];
        }
        return node->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie*node =this;
        for(auto ch : prefix){
            ch-='a';
            if(node->child[ch]== nullptr){
                return false;
            }
            node = node->child[ch];
        }
        return true;
    }
private:
    Trie* child[26]={};       
    bool isEnd = false;
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */