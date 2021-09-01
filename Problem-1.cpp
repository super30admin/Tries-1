/*
Insert Function
Time Complexity = O(L)
Space Complexity = O(NK)

Search Function
Time Complexity = O(L)
Space Complexity = O(NK)

StartWith Function
Time Complexity = O(L)
Space Complexity = O(NK)
where L is the length of the word, N is the number of the words and K is the average length of the word.
*/
class Trie {
public:
    class TrieNode{
        public:
        TrieNode *children[26];
        bool isEnd;
    };
    TrieNode *root;
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
        for (int i = 0; i < 26; i++)
            root->children[i] = NULL;
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode *curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word[i];
            if(curr->children[ch-'a']==NULL)
                curr->children[ch-'a'] = new TrieNode();
            curr = curr->children[ch-'a'];
        }
        curr->isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode *curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word[i];
            if(curr->children[ch-'a']==NULL)
                return false;
            curr = curr->children[ch-'a'];
        }
        return curr->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode *curr = root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix[i];
            if(curr->children[ch-'a']==NULL)
                return false;
            curr = curr->children[ch-'a'];
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
