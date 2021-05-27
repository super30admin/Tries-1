/*
Intuition: A trie is a tree like data structure. It has the same time complexity as a hashmap.
Although it is much more efficient in terms of space.

It is used in spell checker, autocorrect, autocomplete, etc.
#####################################################################
Insertion:
Time Complexity : O(L) , L = length of the word to be inserted
Space Complexity : O(L), L = length of the word to be inserted ( which will be also the height: worst case)
#####################################################################
Search:
Time Complexity : O(L) , L = length of the word to be searched
Space Complexity : O(1)
#####################################################################
startsWith:
Time Complexity : O(L) , L = length of the prefix to be searched
Space Complexity : O(1)
#####################################################################
*/
class TrieNode{
    public:
        TrieNode *children[26];
        bool isEnd = false;
        TrieNode(){     
            for ( int i =0; i < 26; i++){
                children[i] = NULL;
            }
        }
};
class Trie {
public:
    TrieNode* root;
    Trie() {
        root = new TrieNode();
    }

    void insert(string word) {
        TrieNode* currentNode = root;
        
        for (int i =0; i < word.size(); i++){
            
            char letter = word[i];
            if(currentNode->children[letter - 'a'] == NULL){
                TrieNode* newNode = new TrieNode();
                currentNode->children[letter - 'a'] = newNode;
            }
            currentNode = currentNode->children[letter - 'a'];
        }
        currentNode->isEnd = true;
        
    }
    
    bool search(string word) {
        TrieNode* currentNode = root;
        
        for (int i =0; i < word.size(); i++){
            
            char letter = word[i];
            if(currentNode->children[letter - 'a'] == NULL){
                return false;
            }
            currentNode = currentNode->children[letter - 'a'];
        }
        return currentNode->isEnd;
        
    }
    
    bool startsWith(string prefix) {
        TrieNode* currentNode = root;
        
        for (int i =0; i < prefix.size(); i++){
            
            char letter = prefix[i];
            if(currentNode->children[letter - 'a'] == NULL){
                return false;
            }
            currentNode = currentNode->children[letter - 'a'];
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