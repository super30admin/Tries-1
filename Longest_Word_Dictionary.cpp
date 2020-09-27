// Time Complexity : O(n*l) : TRie construction
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//1. The trieNode and the insert functions are created to create the trie
//2. Queue is utilized to store the words with each element present from last to first alphabet
//3. The resultant_word is store at each node to make the return easier. 
class Solution {
public:
    class TrieNode{
      public:
        bool word_end=false;
        string res_word;
        TrieNode* children[26] = {NULL};
    };
    /** Initialize your data structure here. */
    TrieNode * root = new TrieNode(); 
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode *curr= root;
        int index;
        for(index=0; index<word.length();index++){
            if(curr->children[word[index]-'a'] ==NULL){
                curr->children[word[index]-'a'] = new TrieNode();
            }
            curr = curr->children[word[index]-'a'];
        }
        curr->word_end = true;
        curr->res_word += word;
    }
    
    string longestWord(vector<string>& words) {
        //edge case
        if(words.size() == 0){
            return "";
        }
        
        //logic
        //construct the trie : O(NxL)
        for(int i=0; i<words.size(); i++){
            insert(words[i]);
        }
        
        //searching for the longest word
        queue<TrieNode *> myqueue;
        myqueue.push(root);
        int size, index;TrieNode* curr;
        while(!myqueue.empty()){
            size = myqueue.size();
            while(size>0){
                curr = myqueue.front(); 
                myqueue.pop(); 
                size--;
                for(int k=25; k>=0;k--){
                    if(curr->children[k] !=NULL && curr->children[k]->word_end == true)     myqueue.push(curr->children[k]);
                }
            }
        }
       return curr->res_word;
    }
};