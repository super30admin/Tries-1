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

class Solution {
public:
    class TreeNode
    {
        public:
        TreeNode* children[26];
        string word;
        TreeNode()
        {
            for(int i=0;i<26;i++)
            {
                children[i]=NULL;
            }
            word="";
        }
    };
    TreeNode* root;
    void insert(string word)
    {
        TreeNode* current=root;
        for(auto &c : word)
        {
            if(current->children[c-'a']==NULL)
            {
                current->children[c-'a']=new TreeNode();
            }
            current=current->children[c-'a'];
        }
        current->word=word;
    }
    
    
    
    
    
    string longestWord(vector<string>& words) {
        root=new TreeNode();
        for(auto &word:words)
        {
            insert(word);
        }
        queue<TreeNode*> q;
        TreeNode* current;
        q.push(root);
        while(!q.empty())
        {
            current=q.front();
            q.pop();
            for(int i=25;i>=0;i--)
            {
                if(current->children[i]!=NULL && (current->children[i])->word!="")
                {
                    q.push(current->children[i]);
                }
            }
        }
        return current->word;
    }
};