//Time Comp: Insert = O(l), where l is the length of the key
//Space Comp: Insert = O(l), where l is the length of the key

//Time Comp: Search = O(l), where l is the length of the key
//Space Comp: Search = O(1)

//Time Comp: startsWith = O(l), where l is the length of the key
//Space Comp: startsWith = O(1)

class TrieNode{
    public:
        bool isEnd;
        TrieNode* childrens[26]={nullptr};
        TrieNode(){
            isEnd = false;
        }
};


class Trie {
public:
    /** Initialize your data structure here. */
    TrieNode* root;
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* trav = root;
        for(int i=0; i<word.length(); i++){
            if(trav->childrens[word.at(i)-'a'] == nullptr){
                TrieNode* temp = new TrieNode();
                 if(i==word.length()-1) temp->isEnd = true;
                trav->childrens[word.at(i)-'a'] = temp;
                trav = temp;
            }
            else{
                trav = trav->childrens[word.at(i)-'a'];
                if(i==word.length()-1) trav->isEnd = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* trav = root; 
        for(int i=0; i<word.length(); i++){
            if(trav->childrens[word.at(i)-'a'] == nullptr){
                return false;
            }
            else{
                trav = trav->childrens[word.at(i)-'a'];
            }
        }
        return trav->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode* trav = root; 
        for(int i=0; i<prefix.length(); i++){
            if(trav->childrens[prefix.at(i)-'a'] == nullptr){
                return false;
            }
            else{
                trav = trav->childrens[prefix.at(i)-'a'];
            }
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