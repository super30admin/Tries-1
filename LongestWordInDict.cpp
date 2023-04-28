// Time Complexity - O(n*k), where there are 'n' words of 'k' length. This is true for both BFS and DFS.
// Space Complexity - O(n*k) for BFS and O(1) for DFS

// DFS
// Attempt 3 - Only putting words in the Trie that need to be put in i.e. only worlds that can be built by adding successive letters in the dictionary are added to the Trie.
class Solution {
    struct TrieNode{
        bool isEnd;
        TrieNode* children[26];
        public: TrieNode(): children{NULL}{
            isEnd = false;
        }
    };
    
    void insert(string word, TrieNode* root){
        TrieNode* curr = root;
        
        if(word.length() == 1){
            char c = word[0];
            curr->children[c - 'a'] = new TrieNode();
            curr->children[c - 'a']->isEnd = true;
        }
        else{
            for(int i = 0; i < word.length(); i++){
                char c = word[i];
                if(!curr->children[c - 'a']){
                    if(i != word.length() - 1)
                        break;
                    else{
                        curr->children[c - 'a'] = new TrieNode();
                        curr = curr->children[c - 'a'];
                        curr->isEnd = true;
                    }
                }
                else if(curr->children[c - 'a'] && curr->children[c - 'a']->isEnd)
                    curr = curr->children[c - 'a'];
            }
        }
    }
    
    void dfs(TrieNode* root, string answer){
        // base
        if(answer.length() > realA.length())
            realA = answer;
        // logic
        for(int i = 0; i < 26; i++){
            if(root->children[i]){
                answer += char(i + 'a');
                dfs(root->children[i], answer);
                answer.pop_back();
            }
        }
    }
    string realA = "";
public:
    string longestWord(vector<string>& words) {
        TrieNode* root = new TrieNode();
        sort(words.begin(), words.end());
        for(string word : words){
            insert(word, root);
        }
        
        string answer = "";
        dfs(root, answer);
        return realA;
    }
};

// Attempt 2 - DFS
class Solution {
    struct TrieNode{
        bool isEnd;
        TrieNode* children[26];
        public: TrieNode(): children{NULL}{
            isEnd = false;
        }
    };
    
    void insert(string word, TrieNode* root){
        TrieNode* curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word[i];
            if(!curr->children[c - 'a'])
                curr->children[c - 'a'] = new TrieNode();
            curr = curr->children[c - 'a'];
        }
        curr->isEnd = true;
    }
    
    void dfs(TrieNode* root, string answer){
        // base
        if(answer.length() > realA.length())
            realA = answer;
        // logic
        for(int i = 0; i < 26; i++){
            if(root->children[i] && root->children[i]->isEnd){
                answer += char(i + 'a');
                dfs(root->children[i], answer);
                answer.pop_back();
            }
        }
    }
    string realA = "";
public:
    string longestWord(vector<string>& words) {
        TrieNode* root = new TrieNode();
        for(string word : words){
            insert(word, root);
        }
        
        string answer = "";
        dfs(root, answer);
        return realA;
    }
};

// Attempt 1 - DFS
class Solution {
    struct TrieNode{
        bool isEnd;
        TrieNode* children[26] = {NULL};
        public: TrieNode(){
            isEnd = false;
        }
    };

    TrieNode* root;

    public:
    void insert(string word){
        TrieNode* curr = root;
        for(int i = 0; i < word.length(); i++){
            //char c = word[i];
            int index = word[i]-'a';
            if(curr->children[index] == NULL)
                curr->children[index] = new TrieNode();
            curr = curr->children[index];
        }
        curr->isEnd = true;
    }
    string maxStr;
public:
    string longestWord(vector<string>& words) {
        root = new TrieNode();
        
        for(string word:words)
            insert(word);
        backtrack(root, "");
        return maxStr;
    }
    
    private:
    void backtrack(TrieNode* curr, string currStr){
        if(currStr.length() > maxStr.length()){
            maxStr = currStr;
        }
        for(int i = 0; i < 26; i++){
            if(curr->children[i] && curr->children[i]->isEnd){
                int length = currStr.length();
                //action
                
                char ch = i+'a';
                currStr += ch;
                
                //recurse
                backtrack(curr->children[i], currStr);
                
                //backtrack
                currStr.resize(length);
            }
        }
    }
};






//##############################################################################################//

// BFS
class Solution {
    struct TrieNode{
        bool isEnd;
        TrieNode* children[26];
        string word;
        public: TrieNode(): children{NULL}{
            isEnd = false;
            word = "";
        }
    };
    
    void insert(string word, TrieNode* root){
        TrieNode* curr = root;
        int l = word.length();
        for(int i = 0; i < l; i++){
            char c = word[i];
            if(!curr->children[c - 'a'])
                curr->children[c - 'a'] = new TrieNode();
            curr = curr->children[c - 'a'];
        }
        curr->isEnd = true;
        curr->word = word;
    }
    
public:
    string longestWord(vector<string>& words) {
        TrieNode* root = new TrieNode();
        for(string word : words){
            insert(word, root);
        }
        
        queue<TrieNode*> q;
        q.push(root);
        TrieNode* curr = root;
        while(!q.empty()){
            curr = q.front(); q.pop();
            for(int i = 25; i >= 0; i--){
                if(curr->children[i] && curr->children[i]->isEnd)
                    q.push(curr->children[i]);
            }
        }
        return curr->word;
    }
};



// BFS
// Approach - Only putting words in the Trie that need to be put in i.e. only worlds that can be built by adding successive letters in the dictionary are added to the Trie.
class Solution {
    struct TrieNode{
        bool isEnd;
        TrieNode* children[26];
        string word;
        public: TrieNode(): children{NULL}{
            isEnd = false;
            word = "";
        }
    };
    
    void insert(string word, TrieNode* root){
        TrieNode* curr = root;
        
        if(word.length() == 1){
            char c = word[0];
            curr->children[c - 'a'] = new TrieNode();
            curr->children[c - 'a']->isEnd = true;
            curr->children[c - 'a']->word = word;
        }
        else{
            for(int i = 0; i < word.length(); i++){
                char c = word[i];
                if(!curr->children[c - 'a']){
                    if(i != word.length() - 1)
                        break;
                    else{
                        curr->children[c - 'a'] = new TrieNode();
                        curr = curr->children[c - 'a'];
                        curr->isEnd = true;
                        curr->word = word;
                    }
                }
                else if(curr->children[c - 'a'] && curr->children[c - 'a']->isEnd)
                    curr = curr->children[c - 'a'];
            }
        }
    }
    
    string realA = "";
public:
    string longestWord(vector<string>& words) {
        TrieNode* root = new TrieNode();
        sort(words.begin(), words.end());
        for(string word : words){
            insert(word, root);
        }
        
        string answer = "";
        queue<TrieNode*> q;
        q.push(root);
        TrieNode* curr = root;
        while(!q.empty()){
            curr = q.front(); q.pop();
            for(int i = 25; i >= 0; i--){
                if(curr->children[i] && curr->children[i]->isEnd)
                    q.push(curr->children[i]);
            }
        }
        return curr->word;
    }
};

