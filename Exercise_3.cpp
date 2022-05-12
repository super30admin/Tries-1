/* 
    Time Complexity                              :  O(max(M,N)) 
                                                    M -    The time taken to insert
                                                            all the strings (given in the input
                                                            dictionary) character by character 
                                                            in the trie
                                                            
                                                    N  -    Length of the sentence string which is also
                                                            the time taken to split it.
                                                    The time taken in the method replaceWord is a subset
                                                    of M
    Space Complexity                             :  O(M) 
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/replace-words/

class TrieNode {
public:
    bool isWord;
    vector<TrieNode*> children;  
    TrieNode() {
        this->isWord = false;
        this->children.resize(26,nullptr);
    }
};

class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        if(dictionary.size() == 0 or sentence.size() == 0) {
            return sentence;
        }
        
        root = new TrieNode();
        for(auto str : dictionary) {
            insert(str);
        }
        
        vector<string> words = splitSentence(sentence);
        string ans;
        
        for(int i=0;i<words.size();i++) {
            string word = replaceWord(words[i]);
            ans += word;
            if(i != words.size()-1) {
                ans += " ";
            }
        } 
        return ans;
    }
    
private: 
    TrieNode *root;
    
    void insert(string word) {
        TrieNode *rt = root;
        for(char ch : word) {
            if(rt->children[ch - 'a'] == nullptr) {
                rt->children[ch - 'a'] = new TrieNode();
            }
            rt = rt->children[ch - 'a'];
        }
        rt->isWord = true;
    }

    string replaceWord(string word) {
        TrieNode *rt = root;
        string prefix;
        
        for(auto ch : word) {
            if(rt->children[ch - 'a'] == nullptr)
                return word;
            
            prefix += ch;
            rt = rt->children[ch - 'a'];
            if(rt->isWord == true) {
                return prefix;
            }
        }
        
        return prefix;
    }
    
    // do not use this to split a string in a loop. it runs perfect only for once.
    vector<string> splitString(string sentence) {
        vector<string> ans;
        string str;
        getline(cin, sentence); 
        stringstream ss(sentence); 
        while (getline(ss, str, ' ')) {  
            ans.push_back(str);
        }  
        ss.clear();
        ss.str("");
        return ans;
    }
    
    // this is the preferred way to split a string where each word is separated by spaces.
     vector<string> splitSentence(string s) {
        vector<string> words;
        string temp="";
        for(int i=0;i<s.size(); i++){
           if(s[i]==' '&& temp!=""){
               words.push_back(temp);
               temp="";
           }
           else
               temp.push_back(s[i]);                
        }
        if(temp!="") {
           words.push_back(temp);
        }
         
        return words;
    }
    
    bool search(string word) {
        TrieNode *rt = root;
        for(auto ch : word) {
            if(rt->children[ch - 'a'] == nullptr) {
                return false;
            }
            rt = rt->children[ch - 'a'];
        }
        
        return rt->isWord;
    }
};