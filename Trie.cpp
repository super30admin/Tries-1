// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
//    where n : Number of words in dictionary.
//          m : average length of word in dictionary.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build a Prefix Trie using array.
 *  1. Insertion :- Iterate over the input words char by char. If current node does not have a child node present at the next word char location
 *                   then create a new TrieNode at that location and move the current pointer the that new node. Keep repeating above operation until end of word is reached.
 *  2. Search :- Iterate over the input word char by char and traverse the trie. If the child node corresponding to word char is not found then return false. 
 *                If the word end is reached but the current node is not the end of any word then return false. Else return true. 
 *  2. Prefix Search :- Iterate over the input word char by char and traverse the trie. If the child node corresponding to word char is not found then return false. 
 *               If the word end is reached then return true.  
 */

class Trie {
    
    class TrieNode{        
        public :
        
            TrieNode* children[26];
            bool isEnd;    

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
    
    Trie() {
        root = new TrieNode();    
    }
    
    void insert(string word) {    
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
    
    bool search(string word) {
        TrieNode* curr = root;
        
        for (char& c : word)
        {
            if (curr->children[c - 'a'] == nullptr)
            {
                return false;
            }
            curr = curr->children[c - 'a'];
        }
        
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        
        for (char& c : prefix)
        {
            if (curr->children[c - 'a'] == nullptr)
            {
                return false;
            }
            
            curr = curr->children[c - 'a'];
        }
        
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */