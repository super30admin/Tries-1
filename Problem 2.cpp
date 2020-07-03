//Time Complexity : O(n*l)
// Space Complexity :O(n*l)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class TrieNode{
public:
        string word="";
        vector<TrieNode*> children;
        TrieNode(){
            for(int i=0; i<26; i++){
                children.push_back(NULL);
            }
        }
};


class Solution {
public:
    void insert(string word) {
        TrieNode* curr = root;
        for(int i=0; i<word.size(); i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
               curr->children[c-'a']=new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
       curr->word = word;
    }
    
    TrieNode* root;
    string longestWord(vector<string>& words) {
       root=new TrieNode();
        //build trie using all words
        for(int i=0;i<words.size(); i++){
            insert(words[i]);
        }
        
        queue<TrieNode*> q;
        q.push(root);
        TrieNode* curr = NULL;
        while(q.empty()==false){
            curr = q.front(); q.pop();
            for(int i=26; i>=0; i--){
                if(curr->children[i]!=NULL && curr->word!=" "){
                    q.push(curr->children[i]);
                }
            }
        }
        
        return curr->word;
        
    }
};