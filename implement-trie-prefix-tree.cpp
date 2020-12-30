/*
Insert:
	Time - O(len(word))
	Space - O(len(word))

Search:
	Time - O(len(word))
	Space - O(1)

Prefix search:
	Time- O(len(prefix word))
	Space - O(1)

*/
class TrieNode{
    public:
        bool ends;
        vector<TrieNode*> child;
        TrieNode(){
            ends = false;
            child = vector<TrieNode*> (26,NULL);
        }
};
class Trie {
public:
    TrieNode* root;
    /** Initialize your data structure here. */
    Trie() {
       root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        
        TrieNode* node = this->root;
        for(auto c:word){
            if(node->child[c-'a'] == NULL){
                node->child[c-'a'] = new TrieNode();
            }
            node = node->child[c-'a'];
        }
        
        node->ends = true;
        
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        
        TrieNode* node = this->root;
        for(auto c:word){
            if(node->child[c-'a'] == NULL){
                return false;
            }
            node = node->child[c-'a'];
        }
        
        return node->ends;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
         TrieNode* p = root;
        for(int i=0;i<prefix.length();i++){
            if(p->child[prefix[i]-'a'] == NULL) return false;
            p = p->child[prefix[i]-'a'];
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