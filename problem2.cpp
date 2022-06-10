class Solution {
    
    class TreeNode {
        public:
        
        TreeNode *children[26] = {};
        bool isEnd = false;
    };
public:
    TreeNode *root;
    
    void insert(string word){
        TreeNode *curr = root;
        
        for(int i =0;i<word.length();i++) {
            
            if(curr->children[word[i] - 'a'] == NULL) {
                curr->children[word[i] - 'a'] = new TreeNode();
            }
            curr = curr->children[word[i] - 'a'];
        }
        curr->isEnd = true;
    }
    
    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new TreeNode;
        
        //insert into the trie
        for(auto v : dictionary) {
            insert(v);
        }
        
        string result;
        
        //split the sentence.
        string token ;
        vector<string> nsentence;
        stringstream check1(sentence);
        while(getline(check1,token,' ')) {
            nsentence.push_back(token);
        }
        
        //run to the dictionary
        
        for(int i=0;i<nsentence.size();i++) {
           if( i != 0) {
               result += " ";
           }
            
            string curStr = nsentence[i];
            string newString;
            TreeNode *curr = root;
            for(int j =0;j<curStr.size();j++) {
                
                if((curr->children[curStr[j]-'a'] == NULL) || (curr->isEnd == true)) {
                    break;
                }
                
               newString  += curStr[j];
                curr = curr->children[curStr[j]-'a'];
            }
            
            if(curr->isEnd == true) {
                 result += newString;
            } else {
                 result += curStr;
            }
            
        }
        
        return result;
    
    }
};