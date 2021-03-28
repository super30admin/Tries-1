//Insert: TC:O(n), SC: O(n)
//Search: TC:O(n), SC: O(1)
//Prefix: TC:O(n), SC: O(1) where n is number of elements 

class Trie {
public:
    /** Initialize your data structure here. */
    
    //using a structure for TrieNode, where elements have a character array and a bool for isWord
    struct TrieNode{
        TrieNode* children[26];
        bool isWord;
    };
    
    //root initialization
    TrieNode *root;

    //initialization
    Trie() {
      root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        //initialize a current pointer
        TrieNode *curr = root;
        
        //iterate through word elements
        for(int i=0; i<word.size(); i++){
            char curChar = word[i];
            //if in the character array for the current char, the value is null, then create it.
            if(curr->children[curChar - 'a'] == NULL){
                curr->children[curChar - 'a'] = new TrieNode();
            }
            //set curr to the newly created character
            curr = curr->children[curChar - 'a'];
        }
        
        //after finishing the word, set the last child (character)'s isWord to true
        curr->isWord = true;
        
        
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        
        TrieNode *curr = root;

        //iterate through the word, and if at any point of time during iteration, the word is null, return false
        for(int i=0; i<word.size(); i++){
            char curChar = word[i];
            if(curr->children[curChar - 'a'] == NULL){
                return false;
            }
            curr = curr->children[curChar - 'a'];
        }
        
        //after finishig iterating through the word, return the value of the isWord variable
        return curr->isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        
        TrieNode *curr = root;
        
        //same logic as earlier
        for(int i=0; i<prefix.size(); i++){
            char curChar = prefix[i];
            if(curr->children[curChar - 'a'] == NULL){
                return false;
            }
            curr = curr->children[curChar - 'a'];
        }
        //return true in this case since we are just checking if the prefix exists
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