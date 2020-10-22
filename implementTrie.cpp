//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using array
//any issues faced? yes


struct TrieNode{
    TrieNode* children[26];
    bool iscompleted=false;
};
class Trie {
    TrieNode* root;
public:
    /** Initialize your data structure here. */
    Trie() {
        root=new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* curr=root;
        for(char curchr: word)
        {
            int idx=curchr-'a';
            if(curr->children[idx]==NULL)
                curr->children[idx]=new TrieNode();
            curr=curr->children[idx];
        }
        curr->iscompleted=true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode *curr=root;
        for(char curchr:word)
        {
            int idx=curchr-'a';
            if(curr->children[idx]==NULL)
                return false;
            curr=curr->children[idx];
        }
        return (curr && curr->iscompleted);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode* curr=root;
        for(char curchr:prefix)
        {
            int idx=curchr-'a';
            if(curr->children[idx]==NULL)
                return false;
            curr=curr->children[idx];
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