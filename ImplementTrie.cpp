//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Trie {
public:
    class TreeNode
    {
        public:
        TreeNode* children[26];
        bool isEnd;
        TreeNode()
        {
            for(int i=0;i<26;i++)
            {
                children[i]=NULL;
            }
            isEnd=false;
        }
    };
    TreeNode* root;
    Trie() {
        root=new TreeNode();
    }
    
    void insert(string word) {
        TreeNode* curr=root;
        for(auto &c:word)
        {
            if(curr->children[c-'a']==NULL)
            {
                curr->children[c-'a']=new TreeNode();
            }
            curr=curr->children[c-'a'];
        }
        curr->isEnd=true;
    }
    
    bool search(string word) {
        TreeNode* curr=root;
        for(auto &c : word)
        {
            if(curr->children[c-'a']==NULL)
            {
                return false;
            }
            curr=curr->children[c-'a'];
        }
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        TreeNode* curr=root;
        for(auto& c : prefix)
        {
            if(curr->children[c-'a']==NULL)
            {
                return false;
            }
            curr=curr->children[c-'a'];
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