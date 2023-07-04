// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include<vector>
#include<string>

using namespace std;

class TrieNode{
    public:
        vector<TrieNode*> children;
        bool flag;

        TrieNode(){
            children.assign(26,nullptr);
            flag = false;
        }

        void insert(string s){
            TrieNode* obj{this};
            for(auto& c:s){
                int idx = c - 'a';
                if(obj->children[idx] == nullptr) obj->children[idx] = new TrieNode();
                obj = obj->children[idx];
            }
            obj->flag = true;
        }
        void replace(string &word){
            TrieNode* obj{this};
            string to_send{};
            for(auto& c:word){
                int idx = c - 'a';
                if(obj->children[idx] == nullptr) return;
                else{
                    to_send.push_back(c);
                    obj = obj->children[idx];
                    if(obj->flag == true){
                        word = to_send;
                        return;
                    }
                }
            }
        }
};

class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        string sol{};
        TrieNode* root = new TrieNode();
        for(auto& s:dictionary){
            root->insert(s);
        }
        string word{};
        for(auto& c:sentence){
            if(c == ' '){
                root->replace(word);
                sol = sol+word+c;
                word = "";

            }
            else{
                word.push_back(c);
            }
        }
        root->replace(word);
        sol = sol+word;
        return sol;
    }
};