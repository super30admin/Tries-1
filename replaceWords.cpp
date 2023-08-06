//time:O(n) length of sentence
//time:O(n) length of sentence
class TrieNode{
        
    public:
        TrieNode* arr[26];
        bool isEnd=false;
        TrieNode(){
            
            for (int i = 0; i < 26; i++) {
                arr[i] = nullptr;
            }
       
        }
         
        
    
};
class Solution {
    TrieNode* root;
    string result="";string replacement;
    
    
public:
    

    void insert(string word, TrieNode* root) {
        TrieNode* curr = root;

        for(char i:word){
            if(curr->arr[i-'a']==NULL){
                curr->arr[i-'a']=new TrieNode();

            }
            curr = curr->arr[i-'a'];

            
            
        }
        curr->isEnd=true;
    }
    
    
    
    

    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new TrieNode();
        for(string i:dictionary){
            insert(i,root);
        }

        stringstream ss(sentence);
        string word;
        vector<string> words;

        
        while (ss >> word) {
            words.push_back(word);
            
        }
        
        for(int i=0;i<words.size();i++){

            string c = words[i];
            replacement="";
            TrieNode* curr = root;
            if(i>0){
                result.push_back(' ');
            }
            

            for(int k=0;k<c.size();k++){
                char d = c[k];
                if(curr->arr[d-'a']==NULL||curr->isEnd){
                    break;
                }
                curr = curr->arr[d-'a'];
                replacement.push_back(d);
            }

            if(curr->isEnd){
                result+=replacement;
                
            }

            else{
                result+=c;
                
            }

        }
        return result;

        










        
    }
    
};