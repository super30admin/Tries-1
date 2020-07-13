// Time Complexity :O(n*l) - n being number of words and l being the maximum space
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//1. Created a sub class of TrieNode to hold extra information about each character at every level
//2. Inserted the word accordingly
//3. Search and prefix code is written to check the end of the word.



class Trie {
public:
    class TrieNode{
        public:
            bool word_end=false;
            TrieNode * word_char[26]={NULL};
            TrieNode(){

            }
    };
    /** Initialize your data structure here. */
    TrieNode *root;
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode *curr = root;
        int index;
        for(index=0; index<word.length(); index++){
            if(curr->word_char[word[index]-'a'] == NULL){
                curr->word_char[word[index]-'a'] = new TrieNode();
            }
            curr = curr->word_char[word[index]-'a'];
        }
        curr->word_end = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode *curr = root;
        int index;
        for(index=0; index<word.length(); index++){
            if(curr->word_char[word[index]-'a'] == NULL) return false;
            curr = curr->word_char[word[index]-'a'];
        }
        return curr->word_end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode *curr = root;
        int index;
        for(index=0; index<prefix.length(); index++){
            if(curr->word_char[prefix[index]-'a'] == NULL) return false;
            curr = curr->word_char[prefix[index]-'a'];
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
