// 208. Implement Trie (Prefix Tree)
// Time Complexity : O(n)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Trie {
public:
    class TrieNode{
        public:
            bool isEnd;
            TrieNode *children[26];
            TrieNode()
            {
                isEnd = false;
                for (int i = 0; i < 26; i++) {
                    children[i] = NULL;
                }
            }
    };
    TrieNode *root;
    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) { // t-c: length, s-c: 
        TrieNode *curr = root;
        for(int i = 0; i < word.size(); i++)
        {
            if(curr->children[word[i] - 'a'] == NULL)
            {
                curr->children[word[i] - 'a'] = new TrieNode();
            }
            curr = curr->children[word[i] - 'a'];
        }
        curr->isEnd = true;
    }
    
    bool search(string word) { // t-c: length, s-c: 
        TrieNode *curr = root;
        for(int i = 0; i < word.size(); i++)
        {
            if(curr->children[word[i] - 'a'] == NULL)
            {
                return false;
            }
            curr = curr->children[word[i] - 'a'];
        }
        return curr->isEnd;
    }
    
    bool startsWith(string prefix) { // t-c: length, s-c:
        TrieNode *curr = root;
        for(int i = 0; i < prefix.size(); i++)
        {
            if(curr->children[prefix[i] - 'a'] == NULL)
                return false;
            curr = curr->children[prefix[i] - 'a'];
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
