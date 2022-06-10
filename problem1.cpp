class Trie {
    
    class TreeNode {
     public:
        TreeNode *children[26] = {};
        bool isEnd;
    };
    
public:
    
    TreeNode *root;
    Trie() {
        root = new TreeNode();
    }
    
    void insert(string word) {
        TreeNode *curr = root;
        
        for(int i =0;i<word.length();i++) {
            
            if(curr->children[word[i] - 'a'] == NULL) {
                curr->children[word[i] - 'a'] = new TreeNode();
            }
            curr = curr->children[word[i] - 'a'];
        }
        curr->isEnd = true;
    }
    
    bool search(string word) {
        TreeNode *curr = root;
        
        for(int i =0;i<word.length();i++) {
            
            if(curr->children[word[i] - 'a'] == NULL) {
                return false;
            }
            curr = curr->children[word[i] - 'a'];
        }
       return curr->isEnd;
    }
    
    bool startsWith(string prefix) {
        
         TreeNode *curr = root;
        
        for(int i =0;i<prefix.length();i++) {
            
            if(curr->children[prefix[i] - 'a'] == NULL) {
                return false;
            }
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