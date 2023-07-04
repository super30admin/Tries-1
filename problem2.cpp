// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//attempt - 1

#include<iostream>
#include<vector>
#include<stack>

using namespace std;

class TrieNode{
    
    public:
        vector<TrieNode*>child;
        bool flag;
        TrieNode(){
            child.assign(26,nullptr);
            flag = false;
        }
};

typedef struct gg{
    string str;
    int len{};
    gg():str(""),len(0){}
}gg;

class Solution {
public:
    string longestWord(vector<string>& words) {
        TrieNode* root = new TrieNode();
        gg res;
        for(string s: words){
            TrieNode* obj = root;
            gg temp;
            for(char c:s){
                int idx = c - 'a';
                if(obj->child.at(idx) == nullptr){
                    obj->child.at(idx) = new TrieNode();
                }
                if(obj->child.at(idx)->flag == true){
                    temp.len++;
                }
                obj = obj->child.at(idx);
            }
            obj->flag = true;
            temp.len++;
            temp.str = s;
            //cout<<temp.str<<" ";
            //cout<<temp.len<<" ";
            
            if(temp.len>res.len){
                res.len = temp.len;
                res.str = temp.str;
            }
            else if(temp.len == res.len){
                int m = temp.str.length();
                int n = temp.str.length();
                if(m>n){
                    res.str = temp.str;
                }
                else if(m == n){
                    for(int i{};i<n;++i){
                        //out<<temp.str.at(i)<<" "<<res.str.at(i)<<"\t";
                        if(temp.str.at(i)>res.str.at(i)){
                            break;
                        }
                        else if(temp.str.at(i)<res.str.at(i)){
                            res.str = temp.str;
                            break;
                        }
                    }
                }
            }
            //cout<<res.str<<" ";
            //cout<<res.len<<" "<<endl;
        }
        return res.str;
    }
};

// attempt - 2

class Solution {
public:
    string longestWord(vector<string>& words) {
        TrieNode* root = new TrieNode();
        vector<int> hash_len(26,0);
        vector<string> hash_str(26,"");
        int m_len{0};
        string m_str{""};
        for(string s: words){
            int hash_id = s.at(0) - 'a';
            TrieNode* obj = root;
            for(char c:s){
                int idx = c - 'a';
                if(obj->child.at(idx) == nullptr){
                    obj->child.at(idx) = new TrieNode();
                }
                obj = obj->child.at(idx);
            }
            //obj->flag = true;
            hash_len[hash_id]++;
            //below code is to store the maximum length string for the starting alphabet
            int m = s.length();
            int n = hash_str[hash_id].length();
            if(m>n){
                hash_str[hash_id] = s;
            }
            else if(m == n){
                for(int i{};i<n;++i){
                    //out<<temp.str.at(i)<<" "<<res.str.at(i)<<"\t";
                    if(s.at(i)>hash_str[hash_id].at(i)){
                        break;
                    }
                    else if(s.at(i)<hash_str[hash_id].at(i)){
                        hash_str[hash_id] = s;
                        break;
                    }
                }
            }
            // here we try to find the one with maximum level
            // if level are same then we see if they are lexicographically big or small
            if(hash_len[hash_id]>m_len){
                m_len = hash_len[hash_id];
                m_str = hash_str[hash_id];
            }
            else if(hash_len[hash_id] == m_len){
                int l1 = hash_str[hash_id].length();
                int l2 = m_str.length();
                
                if(l1>l2){
                    m_str = hash_str[hash_id];
                }
                else if(l1 == l2){
                    for(int i{};i<l1;++i){
                        if(hash_str[hash_id].at(i)>m_str.at(i)){
                            break;
                        }
                        else if(hash_str[hash_id].at(i)<m_str.at(i)){
                            m_str = hash_str[hash_id];
                            break;
                        }
                    }
                }
            }
        }
        return m_str;
    }
};

//above attemps are wrong becasue didnt consider one character at a time.

//attempt - 3 google

class TrieNode_2{
    public:
    vector<TrieNode_2*> children;
    bool flag;
    string word;

    TrieNode_2(){
        children.assign(26,nullptr);
        string word{};
        flag = false;
    }
};

class Trie{
    public:
    TrieNode_2* root;
    Trie(){
        root = new TrieNode_2();
    }
    void insert(string word){
        TrieNode_2* obj{root};
        for(const auto& c:word){
            int idx = c - 'a';
            if(obj->children.at(idx) == nullptr) obj->children.at(idx) = new TrieNode_2();
            obj = obj->children.at(idx);
        }
        obj->flag = true;
        obj->word = word;
    }
};

string dfs(TrieNode_2* node){
    string res{};
    stack<TrieNode_2*> st;
    st.push(node);
    while(!st.empty()){
        TrieNode_2* obj = st.top();
        st.pop();
        if(obj == nullptr)continue;
        if(obj->flag || obj == node){
            if(obj!=node){
                if(obj->word.length()>res.length() ||
                (obj->word.length() == res.length() && obj->word.compare(res)<0)) res = obj->word;
            }
            for(TrieNode_2* gg:obj->children) st.push(gg);
        }
    }
    return res;
}

class Solution {
public:
    string longestWord(vector<string>& words) {
        Trie Tree;
        for(string& s:words) Tree.insert(s);
        return dfs(Tree.root);
    }
};