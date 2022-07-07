//Time Complexity- O(∑wi)
//Space Complexity- O(∑wi)

struct trie{
    
    trie* children[26];
    string val;
};

trie* newnode(){
    
    trie* curr=new trie();
    for(int i=0;i<26;i++){
        curr->children[i]=NULL;
    }
    curr->val="";
    return curr;
}

void insert(trie *&root,string word){
    
    trie* curr=root;
    for(int i=0;i<word.size();i++){
        int index=word[i]-'a';
        
        if(curr->children[index]==NULL){
            curr->children[index]=newnode();
        }
        curr=curr->children[index];
    }
    curr->val=word;
}

void dfs(trie* root,string &ans){
    
    for(auto child:root->children){
        if(child!=NULL && child->val.size()>0){
            if(child->val.size()>ans.size()){
                ans=child->val;
            }
            dfs(child,ans);
        }
    }
}

class Solution {
public:
    trie* root;
    string ans="";
    string longestWord(vector<string>& words) {
        
        root=newnode();
        for(int i=0;i<words.size();i++){
            insert(root,words[i]);
        }
        
        dfs(root,ans);
        return ans;
    }
};