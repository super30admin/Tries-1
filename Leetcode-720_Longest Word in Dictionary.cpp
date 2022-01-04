// Time Complexity : O(N*M)for inserting into trie + O(N*M) for searching longest word
// Space Complexity :  O(N*M) for storing Trie.
// where N is no of strings and K is length of each string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
1. Build a trie using given words.
2. Iterate through each word, check if it's a word and not a prefix->increment the count.
3. If the word size are equal, do the lexicographical comparision using string compare.

-- Another idea is to maintain substr prefix instead of isTerminal at every node and do a BFS/DFS.
*/

class TrieNode
{
    public:
    char data;
    unordered_map<char, TrieNode*> children;
    bool isTerminal= false;
    TrieNode(char c)
    {
        data = c;
    }
    
    void insertIntoTrie(const string& word)
    {
        TrieNode* temp = this;
        for(int i=0;i<word.size(); i++)
        {
            if(temp->children.count(word[i]))
                temp = temp->children[word[i]];
            else
            {
                TrieNode* newNode = new TrieNode(word[i]);
                temp->children[word[i]] = newNode;
                temp = newNode;
            }
        }
        temp->isTerminal = true;
    }
    
    void search(vector<string>& words, string& result)
    {
        int max_count=0;
        for(auto word:words)
        {
            int curr_count=0;
            TrieNode* temp = this;
            for(int i=0;i<word.size(); i++)
            {
                temp = temp->children[word[i]];
                if(temp->isTerminal)
                    curr_count++;
                else
                    break;
            }
            
            if(curr_count>max_count)
            {
                max_count = curr_count;
                result = word;
            }
            else if(curr_count ==max_count)
            {
                if(result.compare(word)>0)
                    result = word;
            }
        }
    }
};

class Solution 
{
    public:
    TrieNode* root;
    
    Solution()
    {
        root = new TrieNode('#');
    }
    
    string longestWord(vector<string>& words) 
    {
        int longestWordSize;
        int currentWordSize;
        
        string result;
        
        // insert every node into trie
        for(const auto &word: words)
            root->insertIntoTrie(word);
        
        root->search(words, result);
        return result;
    }
};
