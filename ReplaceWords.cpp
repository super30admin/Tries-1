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
    vector<string> vecString;
    string replaceWords(vector<string>& dictionary, string sentence) {
        root=new TreeNode();
        
        
        //Split The String
        string word="";
        
        for(auto &c:sentence)
        {
            if(c==' ')
            {
                vecString.push_back(word);
                word="";
            }
            else
            {
                word+=c;
            }
                
        }
        vecString.push_back(word);
        
        
        
        //Insert Into Trie
        for(auto &w: dictionary)
        {
            insert(w);
        }
        
        
        //Generate Result
        string result="";
        int count=0;
        for(auto& vec:vecString)
        {
            if(count!=0)
            {
                result+=" ";
            }
            result+=ReturnShortestString(vec);
            count++;
        }
        return result;
    }
    
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
        current->isEnd=true;
    }
    
    string ReturnShortestString(string word)
    {
        string retWord="";
        TreeNode* current=root;
        for(auto &c:word)
        {
            if(current->children[c-'a']==NULL)
            {
                return word;
            }
            retWord+=c;
            current=current->children[c-'a'];
            if(current->isEnd==true)
            {
                return retWord;
            }
            
        }
        return word;
    }
    
};