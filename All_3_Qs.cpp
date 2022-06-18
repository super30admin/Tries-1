IMPLEMENTING TRIE - PREFIX TREE
-----------------------------------------------------------------
INSERT : TC = O(M), SC = O(M) ==> m = size of key

SEARCH/STARTS with :
TC = O(M), SC = O(1)
  
class Trie {
public:
    class TrieNode{
        public:
            TrieNode* children[26];
            bool isEnd;
    };
    TrieNode* root;
    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode* curr = root;
        for(int i=0;i<word.size();i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
    }
    
    bool search(string word) {
        TrieNode* curr = root;
        for(int i=0;i<word.size();i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL) return false;
            curr = curr->children[c-'a'];
        }
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        for(int i=0;i<prefix.size();i++){
            char c = prefix[i];
            if(curr->children[c-'a']==NULL) return false;
            curr = curr->children[c-'a'];
        }
        return true;
    }
};

-----------------------------------------------------------------
REPLACE WORDS
-----------------------------------------------------------------
SC = O(m*l) worst case

TC =
inserting into dictionary = O(m*l)  { m words, l= avg length of word }
+
Finding replacement = O(n*k). { n words, avg length = k }

  
class Solution {
public:
    
    class TrieNode{
        public:
            TrieNode* children[26];
            bool isEnd;
    };
    TrieNode *root = new TrieNode();
    
    void insert(string word){
        TrieNode *curr = root;
        for(int i=0;i<word.length();i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
                curr->children[c-'a']= new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd=true;
    }
    
    vector<string> stringToVector(string s){
        vector<string> result;
        stringstream ss(s);
        string word;
        while (ss >> word) {
            result.push_back(word);
        }
        return result;
    }
    
    string replaceWords(vector<string>& dictionary, string sentence) {
        vector<string> words = stringToVector(sentence);
        string result;
        for(auto word:dictionary)
            insert(word);
        for(auto word:words){
            result.append(" ");
            string replacement;
            TrieNode *curr = root;
            for(int i=0;i<word.length();i++){
                char c = word[i];
                if(curr->children[c-'a']==NULL || curr->isEnd) break;
                replacement.push_back(c);
                curr = curr->children[c-'a'];
            }
            if(curr->isEnd)
                result.append(replacement); //shorter word is present
            else
                result.append(word); //word is not present in the trie or no shorter word found
        }
        result.erase(0,1);
        return result;
    }
};
-----------------------------------------------------------------
LONGEST WORD IN DICTIONARY - TRIES BFS
-----------------------------------------------------------------
time = O(n*k) 
space = O(n*k)
  
class Solution {
public:
    class TrieNode{
        public:
            TrieNode* children[26];
            bool isEnd;
            string word="";
    };
    TrieNode *root = new TrieNode();
    
    void insert(string word){
        TrieNode *curr = root;
        for(int i=0;i<word.size();i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
                curr->children[c-'a']= new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
        curr->word = word;
    }
    
    string longestWord(vector<string>& words) {
        for(auto word:words)
            insert(word);
        queue<TrieNode*> q;
        q.push(root);
        TrieNode *current;
        while(!q.empty()){
            current = q.front(); q.pop();
            for(int i=25;i>=0;i--){
                if(current->children[i]!=NULL && current->children[i]->isEnd)
                    q.push(current->children[i]);
            }
        }
        return current->word;
    }
};
-----------------------------------------------------------------
LONGEST WORD IN DICTIONARY - TRIES DFS
-----------------------------------------------------------------
TIME = O(NK)
SPACE = O(NK)
  
class Solution {
public:
    class TrieNode{
        public:
            TrieNode* children[26];
            bool isEnd;
            char ch;
    };
    TrieNode *root = new TrieNode();
    
    void insert(string word){
        TrieNode *curr = root;
        for(int i=0;i<word.size();i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
                curr->children[c-'a']= new TrieNode();
            }
            curr = curr->children[c-'a'];
            curr->ch = c;
        }
        curr->isEnd = true;
    }
    
    string result = "";
    string longestWord(vector<string>& words) {
        for(auto word:words)
            insert(word);
        TrieNode *curr = root;
        backtrack(curr,"");
        return result;
    }
    
    void backtrack(TrieNode *curr, string curString){
        //base
        if(result.length()<curString.length()){
            result = string(curString);
        }
        //logic
        for(int i=0;i<26;i++){
            if(curr->children[i]!=NULL && curr->children[i]->isEnd){
                //action
                curString.push_back(curr->children[i]->ch);
                //recurse
                backtrack(curr->children[i],curString);
                //backtrack
                curString.pop_back();                
           }
        }
    }
};
