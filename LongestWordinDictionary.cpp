// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
//    where n : Number of words in dictionary.
//          m : average length of word in dictionary.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build a Prefix Trie using provided words. 
 * Perform BFS on a trie, while traversing a node insert right most child (z -> a) first to get a lexicographically correct answer node at the end of traversal. 
 */

class Solution {
    class TrieNode{
        public:
            TrieNode* children[26];
            string word;
            
            TrieNode()
            {
                for (int i = 0; i < 26; i++)
                {
                    children[i] = nullptr;
                }
                
                word = "";
            }
    };
    
public:
    TrieNode* root;
    
    void insert(string& word)
    {
        TrieNode* curr = root;
        
        for (char& c: word)
        {
            if (curr->children[c - 'a'] == nullptr)
            {
                curr->children[c - 'a'] = new TrieNode();
            }
            
            curr = curr->children[c - 'a'];
        }
        
        curr->word = word;
    }
    
    string longestWord(vector<string>& words) {
        
        if (words.size() == 0)
            return "";
        
        // Build Trie
        root = new TrieNode();
        for (string& word : words)
        {
            insert(word);
        }
        
        // BFS approach
        queue<TrieNode*> q;
        q.push(root);
        TrieNode* curr;
        while(!q.empty())
        {
            curr = q.front();
            q.pop();
            
            for (int i = 25; i >= 0; i--)
            {
                if (curr->children[i] != nullptr && curr->children[i]->word != "")
                {
                    q.push(curr->children[i]);
                }
            }
        }
        
        return curr->word;
    }
};