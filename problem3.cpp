class Solution {
public:
    class TrieNode{
        public:
        vector<TrieNode*>children;
        bool isEnd;
        TrieNode(){
            isEnd=false;
            children.resize(26);
        }
    };
    TrieNode* root;
    void insert(string word){
        TrieNode* curr = root;
        for(int i=0;i<word.size();i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr=curr->children[c-'a'];
        }
        curr->isEnd=true;
    }
    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new TrieNode();
        for(string word:dictionary){
            insert(word);
        }
        vector<string>v;
        string s="";
        int f=0;
        for(int i=0;i<sentence.size();i++){
            if(sentence[i]!=' '){
                s+=sentence[i];
                f=0;
            }
            else if(sentence[i]==' '&&f==0)
            {
                v.push_back(s);
                s="";
                f=1;
            }
        }
        if(s!=""){
            v.push_back(s);
        }
        string res="";
        for(int i=0;i<v.size();i++){
            if(i>0){
                res+=" ";
            }
            string word = v[i];
            string rep = "";
            TrieNode* curr=root;
            for(int j=0;j<word.size();j++){
                char c = word[j];
                if(curr->children[c-'a']==NULL||curr->isEnd){
                    break;
                }
                rep+=c;
                curr=curr->children[c-'a'];
            }
            if(curr->isEnd){
                res+=rep;
            }
            else{
                res+=word;
            }
        }
        return res;
    }
};