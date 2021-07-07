// Trie+Backtracking solution without word stored at each node
// Time Complexity : O(nk) n=number of words; k=avg length of words
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create a trie out of the dictionary. In the recursion function, pass temp and longest string as reference
// 2. Iterate through all 26 children and add next char child to temp and add to longest if conditions are satisfied
// 3. Recursively call the function to traverse with the base condition being the trie node has isEnd set to true

class TrieNode{
public:
    bool isEnd;
    vector<TrieNode*> children;
    
    TrieNode(){
        isEnd=false;
        children.resize(26);
        for(auto child: children)
            child=nullptr;            
    }
    
    void createTrie(vector<string> words){
        for(string word: words){
            TrieNode* root = this;
            cout<<"inserting word: "<<word<<endl;
            for(char c: word){         
                if(root->children[c-'a']==nullptr){
                    cout<<"inserting char: "<<c<<endl;
                    root->children[c-'a'] = new TrieNode();
                }
                root = root->children[c-'a'];
            }
            root->isEnd = true;
        }
    }
};

class Solution {
public:
    string longestWord(vector<string>& words) {
        TrieNode* root = new TrieNode();
        root->isEnd = true;
        root->createTrie(words);
        string temp, longest="";
        dfs(root, temp, longest);
        return longest;
    }
    
    void dfs(TrieNode* root, string& temp, string& longest){
        // base
        if(root->isEnd == false)
            return;
        // logic
        for(int i=0;i<26;i++){
            if(root->children[i]!=nullptr){
                // action
                char c = 97+i;
                temp += c;
                if(root->children[i]->isEnd != false){
                    if(temp.size()>longest.size())
                        longest.assign(temp);
                    if(temp.size()==longest.size() && temp.compare(longest)<0)
                        longest.assign(temp);
                }
                // recurse
                dfs(root->children[i],temp,longest);
                // backtrack
                temp.pop_back();
            }
        }   
    }
};