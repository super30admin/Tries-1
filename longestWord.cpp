// Time Complexity :O(n) n is average word length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TrieNode{
public:
    string word;
    vector<TrieNode*> children;
    TrieNode(){
        word = "";
        children.resize(26,nullptr);
    }
};
class Solution {
    TrieNode *root;
    //string longestWord;
public:
    Solution(){
        root = new TrieNode();
        //longestWord = "";
    }
    void insertToTrie(string word){
        TrieNode *curr = root;
        for(int i =0; i<word.length();i++){
            char c = word[i];
            if(!curr->children[c - 'a'])
                curr->children[c - 'a'] = new TrieNode();
            curr = curr->children[c - 'a'];
        }
        curr->word = word;
    }
    string longestWord(vector<string>& words) {
        for(auto word : words){
            insertToTrie(word);
        }
        queue<TrieNode*> q;
        
        TrieNode *curr = root;
        q.push(curr);
        while(!q.empty()){
            curr = q.front();
            q.pop();
            for(int i = 25;i>=0;i--){
                if(curr->children[i] && curr->children[i]->word != ""){
                    q.push(curr->children[i]);
                }   
            }
        }
        return curr->word;
    }
};