//Time Complexity : O(n*l)
// Space Complexity :O(n*l)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class TrieNode{
public:
        bool isEnd=false;;
        vector<TrieNode*> children;
        TrieNode(){
            for(int i=0; i<26; i++){
                children.push_back(NULL);
            }
        }
};
class Trie {
public:
    TrieNode* root;
    /** Initialize your data structure here. */
    Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* curr = root;
        for(int i=0; i<word.size(); i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL){
               curr->children[c-'a']=new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode* curr = root;
        for(int i=0; i<word.size(); i++){
            char c = word[i];
            if(curr->children[c-'a']==NULL) return false;
            curr = curr->children[c-'a'];
        }
        
        if(curr->isEnd==true) return true;
        
        return false;
        
        //return curr->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode* curr = root;
        for(int i=0; i<prefix.size(); i++){
            char c = prefix[i];
            if(curr->children[c-'a']==NULL) return false;
            curr = curr->children[c-'a'];
        }
        
        return true;
    }
};
