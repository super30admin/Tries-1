
// Time Complexity : OO(n) - where n is the length of the wordß
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Trie {
private:
struct TrieNode{
    struct TrieNode *child[26];
    bool isEnd;
};
TrieNode* node;

public:
    Trie() 
    {
        node=new TrieNode();
    }

    void insert(string word) {
        TrieNode* cur=node;
        for(char c: word){
            if(cur->child[c-'a']==NULL) cur->child[c-'a']=new TrieNode();
            cur=cur->child[c-'a'];
        }
        cur->isEnd=true;
    }

    bool search(string word) {
        TrieNode* cur=node;
        for(char c: word){
            if(cur->child[c-'a']==NULL)return false;
            cur=cur->child[c-'a'];
        }
        if(cur->isEnd==true) return true;
        return false;
    }

    bool startsWith(string prefix) {
        TrieNode* cur=node;
        for(char c: prefix){
            if(cur->child[c-'a']==NULL)return false;
            cur=cur->child[c-'a'];
        }
        return true;
    }
};
