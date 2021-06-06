// Time Complexity :O(m)  where m is the length of the sentence
// Space Complexity : O(n)  where n is the size of the Trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TrieNode{
    public:
        bool isEnd;
        vector<TrieNode*> children;
        TrieNode(){
            isEnd = false;
            children.resize(26);
        }
};
class Solution {
    TrieNode *root;
public:
    Solution(){
        root = new TrieNode();
    }
    string replaceWords(vector<string>& dictionary, string sentence) {
        vector<string> sen;
        stringstream ss(sentence);
        string word;
        while(ss >> word){
            sen.push_back(word);
        }
        for(auto dict:dictionary){
            insertToTrie(dict);
        }
        string result;
        for(int i = 0;i< sen.size();i++){
            if(i>0) result = result + " ";
            string temp = searchInTrie(sen[i]);
            if(temp.length()) result = result + temp; 
            else result = result + sen[i];
        }
        return result;
    }
    void insertToTrie(string word){
        TrieNode *curr = root;
        for(int i = 0; i< word.length();i++){
            char c =  word[i];
            if(!curr->children[c - 'a'])
                curr->children[c - 'a'] = new TrieNode();
            curr = curr->children[c - 'a'];
        }
        curr->isEnd = true;
    }
    string searchInTrie(string word){
        TrieNode *curr = root;
        string ans;
        for(int i = 0;i< word.length();i++){
            char c = word[i];
            if(!curr->children[c - 'a'] || curr->isEnd) break;
            else ans= ans+c;
            curr= curr->children[c - 'a'];
        }
        if(curr->isEnd) return ans;
        else return "";
    }
};