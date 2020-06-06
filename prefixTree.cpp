// Time Complexity : O(n) for all functions; n=length of string 
// Space Complexity : O(n) for insert; O(1) for the ther two
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Figuring out how to do wihout extra class

// 1. Not creating different TrieNode class, using given Trie class only. Root is obtained using this pointer (see function call)
// 2. TrieNode consists of boolean isEnd to know if char is end of word and an array of Trie pointers.
// 3. Constructor creates a TrieNode with the boolean set to false and all pointers in array set to nullptr

// insert function: we iterate through input string and check if each char is present. If yes, go to that node, else create node
// search function: we iterate through input string and check if each char is present. If yes, go to that node, else return false. Finally, return isEnd for last char
// prefix function: we iterate through input string and check if each char is present. If yes, go to that node, else return false. Finally, return true.
 

class Trie {
private:
    bool isEnd;
    vector<Trie*> children;
public:
    /** Initialize your data structure here. */
    Trie() {
        isEnd=false;
        children.resize(26);
        for(auto child: children)
            child=nullptr;
    }
   
    /** Inserts a word into the trie. */
    void insert(string word) {
        auto root = this;
        for(auto c: word){
            if(root->children[c-'a'] == nullptr)
                root->children[c-'a'] = new Trie();
            root = root->children[c-'a'];
        }
        root->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        auto root = this;
        for(auto c: word){
            if(root->children[c-'a'] == nullptr)
                return false;
            root = root->children[c-'a'];
        }
        return root->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        auto root = this;
        for(auto c: prefix){
            if(root->children[c-'a'] == nullptr)
                return false;
            root = root->children[c-'a'];
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