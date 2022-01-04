// Time Complexity : O(N*M)for inserting into trie + O(N) for splitting words into tokens + 0(KM) for searching k words of length M in trie.
// Space Complexity :  O(K*M) for storing results + split sentence to tokens + O(N*M) to build a trie from dictionary.
// where N is dictionary size and M is length of each string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
1. Build a trie using words given in dictionary
2. split the words in sentence and search if the part of it exists as a word (not prefix) in trie.
3. Add it to result if exists, otherwise add same word.
*/

class TrieNode
{
    public:
    char data;
    map<char, TrieNode*> children;
    bool isTerminal = false;
    
    TrieNode(char c)
    {
        data = c;
    }
    
    void insert(string& str)
    {
        TrieNode* temp = this;
        for(int i=0;i<str.size(); i++)
        {
            if(temp->children.count(str[i]))
                temp = temp->children[str[i]];
            else
            {
                TrieNode* newNode = new TrieNode(str[i]);
                temp->children[str[i]] = newNode;
                temp = newNode;
            }
        }
        temp->isTerminal = true;
    }
    
    void searchRoot(string& str, string& res)
    {
        bool exists = false;
        TrieNode* temp = this;
    
        for(int i=0;i<str.size();i++)
        {
            if(!temp->children.count(str[i]))
                break;
            else
            {
                temp = temp->children[str[i]];
                res+=str[i];
                if(temp->isTerminal)
                    return;
            }
        }
        
        res = str;
    }
    
};

class Solution 
{
    void splitIntoTokens(string& str, vector<string>& tokens)
    {
        stringstream ss(str);
        string token;
        
        while(getline(ss, token, ' '))
        {
            tokens.push_back(token);
        }
    }
    public:
    TrieNode* root;
    
    Solution()
    {
        root = new TrieNode('#');
    }
    
    string replaceWords(vector<string>& dictionary, string sentence) 
    {
        int len = sentence.size();
        if(len==0)
            return "";
        
        insertIntoTrie(dictionary);
        
        string result;
        vector<string> tokens;
        splitIntoTokens(sentence,tokens);
        
        int token;
        for(token=0;token<tokens.size(); token++)
        {
            // search for root in trie for every 
            string temp;
            root->searchRoot(tokens[token], temp);
            
            if(token==tokens.size()-1)
                result+=temp;
            else
                result+=temp+ " ";
            
        }
        return result;
    }
    
    // Insert every root into Trie
    void insertIntoTrie(vector<string>& dictionary)
    {
        for(auto str: dictionary)
            root->insert(str);
    }
    
    
    ~Solution()
    {
        delete root;
    }
};