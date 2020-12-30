//Time - O(len(sentence))
//Space - O(sum(len(words in dictonary)))

class TrieNode{
public:
    vector<TrieNode*> child;
    bool isEnd;
    
    TrieNode(){
        child = vector<TrieNode*> (26,NULL);         
        isEnd = false;
    }
};

class Trie {
    public:
    TrieNode* root;
    
    Trie(){
        root = new TrieNode();
    }
   
    void insert(string word) {
        
       TrieNode* node = this->root;
       for(auto c:word){
           if(node->child[c-'a'] == NULL){
               node->child[c-'a'] = new TrieNode();
           }
           node = node->child[c-'a'];
       }
       
       node->isEnd = true;
    }
    
     string searchPrefix(string word) {
        
        TrieNode* node = this->root;
        string str = "";
        for(auto c:word){
            if(node->child[c-'a'] == NULL){
                return word;
            }
            str = str+c;
            node = node->child[c-'a'];
            if(node->isEnd) break; 
        }
        
        return str;
    }
    
};

class Solution {
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        
        Trie* trie = new Trie();
        
        for(auto word:dictionary){
            trie->insert(word);
        }
        
        sentence = sentence + " ";
        int beg = 0; 
        string ret = "";
        for(auto end = 0; (end = sentence.find(" ",end)) != string::npos; end++){
            ret = ret + trie->searchPrefix(sentence.substr(beg,end-beg)) + " ";
            beg = end+1;
        }
        ret.pop_back();
        cout<<ret;
        return ret;
        
    }
};