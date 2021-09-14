//Time Complexity - O(nk)
//Space Complexity - O(nk)
class Solution {
public:
    class TrieNode{
        public:
        vector<TrieNode*>children;
        string word;
        TrieNode(){
            word="";
            children.resize(26);
        }
    };
    TrieNode* root;
    void insert(string word){
        TrieNode* curr=root;
        for(int i=0;i<word.size();i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
                curr->children[c-'a']=new TrieNode();
            }
            curr=curr->children[c-'a'];
        }
        curr->word=word;
    }
    
    string longestWord(vector<string>& words) {
        root  =new TrieNode();
        for(string word:words){
            insert(word);
        }
        queue<TrieNode*>q;
        TrieNode* curr=root;
        q.push(root);
        while(!q.empty()){
            curr=q.front();
            q.pop();
            for(int i=25;i>=0;i--){
                if(curr->children[i]!=NULL&&curr->children[i]->word!=""){
                    q.push(curr->children[i]);
                }
            }
        }
        return curr->word;
    }
};