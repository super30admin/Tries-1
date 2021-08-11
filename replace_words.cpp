// Time complexity- O(n)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// put all the roots in a prefix tree 
// for each word seach the trie for the smallest root


#include<algorithm>
#include<iostream>
#include <sstream>
#include<vector>
#include<stack>

using namespace std;
class Solution {
    
    class Trie{
            
            public:
            Trie(){}
            //private:
                Trie * child[26]={};
                bool isEnd=false;
            
            void insert(string word){
                Trie* node = this;
                for( char ch : word){
                    ch -= 'a';
                    if(!node->child[ch]){
                        node->child[ch] = new Trie();
                    }
                    node =node->child[ch];
                }
                 node->isEnd = true;
            }
        
        
    };
public:
     Trie* root = new Trie();
    string replaceWords(vector<string>& dictionary, string sentence) {
          
            for(string word : dictionary){
                root->insert(word);
            }
            stringstream ss(sentence);
            string str,result;
            vector<string> temp;
            while(ss >> str){
                temp.push_back(str); 
            }
            Trie* curr;
            for(auto word : temp){
                string replacement;
                curr =root;
                for(int i=0;i<word.size();i++){
                     char c = word[i];
                    if(curr->child[c-'a'] == nullptr || curr->isEnd) break;
                    curr = curr->child[c-'a'];
                    replacement += c;
                }
                if(curr->isEnd){
                    result+=replacement;
                    result+=" ";
                }else{
                    result+=word;
                    result+=" ";
                }
                
            }
        result.pop_back();
        return result;
    }
};