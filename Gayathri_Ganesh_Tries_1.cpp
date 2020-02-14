// Time Complexity : O(N) N- number of alphabets in given word
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//Code in C++


class Trie {
    class TrieNode {
        public:
        bool isEnd;
        TrieNode *children[26]; //26 as only lowercase letters
        TrieNode() {        //constructor to initilaize children[] and isEnd members
            for(int i=0;i<26;i++)
            {
                this->children[i]=NULL;
            }
            this->isEnd=false;
        } //empty constructor
    }; //end of class TrieNode
public:
    /** Initialize your data structure here. */
    Trie() {}
    
    TrieNode *root=NULL; //initialize root to NULL
    /** Inserts a word into the trie. */
    void insert(string word) {
    
        TrieNode *curr=root;    //assign root a new curr node that starts from root node
        for(int i=0;i<word.length();i++)
        {
            char c = word[i];
            if(!curr->children[c-'a']) //check if curr node's children node is NOT NULL
            {
                //Assign a new node if word does not exist
                curr->children[c-'a'] = new TrieNode(); 
            }
            curr=curr->children[c-'a']; //increment to the next node
        }
    curr->isEnd=true; //set tail pointer isEnd of the last 'word' to NULL
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        
        TrieNode *curr=root; //start with the root node
        for(int i=0;i<word.length();i++) //run through the entire 'word' length
        {
            char c=word[i];
            if(!curr->children[c-'a']) //check letter by letter if curr node's child is NOT EQUAL TO every letter in the existing trie
                return false;
            else
                curr=curr->children[c-'a']; //increment to the next node in the trie
        }
        return curr->isEnd; //return the value of isEnd value
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        TrieNode *curr=root;
        for(int i=0;i<prefix.length();i++) //run the loop for length of prefix
        {
            char c=prefix[i];
            if(!curr->children[c-'a'])//check for match for evry letter of prefix
                   return false;
            else
                curr=curr->children[c-'a']; //increment to next node
        }
        return curr->isEnd; //return the value of isEnd
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */