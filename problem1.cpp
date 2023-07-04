// Time Complexity : search insert and starts with O(l) // length of the string
// Space Complexity : O(l) length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include<iostream>
#include<vector>
#include<string>
using namespace std;

class Trie {
    
public:
    vector<Trie*> child;
    bool flag;
    Trie() {
        this->child.assign(26,NULL);
        this->flag = false;
    }
    
    void insert(string word) {
        Trie* obj{this};
        int n = word.length();
        for(int i{};i<n;++i){
            int idx = word.at(i) - 'a';
            if(obj->child.at(idx) == NULL){
                obj->child.at(idx) = new Trie();
            }
            obj = obj->child.at(idx);
        }
        obj->flag = true;
    }
    
    bool search(string word) {
        int n = word.length();
        Trie* obj{this};
        for(int i{};i<n;++i){
            int idx = word.at(i) - 'a';
            obj = obj->child.at(idx);
            if(obj == NULL) return false;
        }
        return obj->flag;
    }
    
    bool startsWith(string word) {
        int n = word.length();
        Trie* obj{this};
        for(int i{};i<n;++i){
            int idx = word.at(i) - 'a';
            obj = obj->child.at(idx);
            if(obj == NULL) return false;
        }
        return true;
    }
};