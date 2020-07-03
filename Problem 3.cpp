//Time Complexity : O(n*l)
// Space Complexity :O(n*l)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class TrieNode{
public:
        bool isEnd=false;;
        vector<TrieNode*> children;
        TrieNode(){
            for(int i=0; i<26; i++){
                children.push_back(NULL);
            }
        }
};
class Solution {
public:
    TrieNode* root = new TrieNode();
    //insert all words in a dictonary 
    void insert(string word) {
        TrieNode* curr = root;
        for(int i=0; i<word.size(); i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
               curr->children[c-'a']=new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd=true;
    }
    
    string replaceWords(vector<string>& dict, string sentence) {
        string res="";
        for(int i=0; i<dict.size(); i++){
            insert(dict[i]);
        }
        
        //split string
        vector<string> substr;
        string token;
        istringstream iss(sentence);
        while(getline(iss, token, ' ')){
            substr.push_back(token);
        }
        
        
        //logic
        
        for(int i=0; i<substr.size(); i++){
            TrieNode* curr=root;
            string temp;
            bool flag = false;
            string s = substr[i];
            if(i>0){
                res+=" ";
            }
            for(int j=0; j<s.size(); j++){
                char c = s[j];
                if(curr->children[c-'a']==NULL || curr->isEnd==true) {
                    flag = true;
                    break;
                }
                temp+=c;
                curr=curr->children[c-'a'];
            }
            
            if(curr->isEnd){
                res+=temp;
            }
            else{
                res+=s;
            }
            
            /*if(flag){
                res+=s;
            }
            else{
                res+=temp;
            }*/
            
        }
        
        return res;
    }
};