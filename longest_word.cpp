// Time complexity- O(length of longest word)
// space complexity O(lenght of longest word * n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// put all the words into the trie
// traverse the tree using bfs until you reach the leaf nodes
// lloop over the tree in reverse order so as to get the result in lexicographical order


#include<algorithm>
#include<iostream>
#include <sstream>
#include<vector>
#include<stack>

using namespace std;

class Trie{
    public:
        Trie(){}
        Trie * child[26]={};
        bool isEnd = false;
        string word;
    void insert(string word){
        Trie* root = this;
        for(auto ch : word){
            ch-= 'a';
            if(root->child[ch] == nullptr  ){
                root->child[ch]= new Trie();
            }
            root=root->child[ch];
        }
        root->isEnd = true;
        root->word = word;
    }
    string getLongestWord(){
        string res="";
        Trie* root = this;
        queue<Trie*>q;
        q.push(root);
        while(!q.empty()){
            Trie* curr = q.front();q.pop();
            for(int i =25;i>=0;i--){
                if(curr->child[i] != nullptr && curr->child[i]->isEnd==true){
                    q.push(curr->child[i]);
                    res = curr->child[i]->word;
                }
            }
        }
        return res;
    }
};



class Solution {
public:
    
    string longestWord(vector<string>& words) {
        Trie* root= new Trie();
        for(auto word: words){
            root->insert(word);
        }
        return root->getLongestWord();
    }
};