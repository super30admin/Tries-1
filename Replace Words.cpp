//Time Complexity- O(n)
//Space Complexity- O(n)

struct trienode{
    
    trienode* children[26];
    string word;
};

trienode* newnode(){
    
    trienode* temp=new trienode();
    for(int i=0;i<26;i++){
        temp->children[i]=NULL;
        temp->word="";
    }
    return temp;
}

void insert(trienode*& root,string &word){
    
    trienode* curr=root;
    for(int i=0;i<word.size();i++){
        int index=word[i]-'a';
        if(!curr->children[index]){
            curr->children[index]=newnode();
        }
        curr=curr->children[index];
    }
    curr->word=word;
}

string searchTrie(trienode* root,string word){
    
    trienode* curr=root;
    for(int i=0;i<word.size();i++){
        int index=word[i]-'a';
        if(!curr->children[index]){
            return "";
        }
        else if(curr->children[index]->word.size()>0){
            return curr->children[index]->word;
        }
        curr=curr->children[index];
    }
    return "";
}

class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        trienode* root=newnode();
        string ans="";
        for(string w:dictionary){
            insert(root,w);
        }
        
        stringstream ss(sentence);
        string word;
        while(ss>>word){
            string temp=searchTrie(root,word);
            if(temp.size()>0){
                ans+=temp+' ';
            }
            else{
                ans+=word+' ';
            }
        }
        return ans.substr(0,ans.size()-1);
    }
};