class Solution {
    
    class TrieNode{
        public:
            bool isEnd;
            TrieNode* children[26];
        
            TrieNode()
            {
                for (int i = 0; i < 26; i++)
                {
                    children[i] = nullptr;
                }
                
                isEnd = false;
            }
            
    };
    
public:
    TrieNode* root;
    
    void insert(string& word)
    {
        TrieNode* curr = root;
        
        for (char& c : word)
        {
            if (curr->children[c - 'a'] == nullptr)
            {
                curr->children[c - 'a'] = new TrieNode();
            }
            
            curr = curr->children[c - 'a']; 
        }
        curr->isEnd = true;
    }
    
    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new TrieNode();
        
        // Build trie
        for (string& s : dictionary)
        {
            insert(s);
        }
        
        stringstream ss(sentence);
        vector<string> tokens;
        string temp_string;
        
        while(getline(ss, temp_string, ' '))
        {
            tokens.push_back(temp_string);
        }
        
        string result;
        for (int i = 0; i < tokens.size(); i++)
        {
            if (i != 0)
                result += " ";
            
            TrieNode* curr = root;
            string replacement = "";
            for (char& c: tokens[i])
            {
                if (curr->children[c - 'a'] == nullptr || curr->isEnd)
                {
                    break;
                }
                replacement += c;
                curr = curr->children[c - 'a'];
            }
            
            if (curr->isEnd)
            {
                result += replacement;
            }
            else
            {
                result += tokens[i];
            }
        }
        return result;
    }
};