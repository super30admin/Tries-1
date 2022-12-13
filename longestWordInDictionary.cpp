// Time Complexity : O(n*l) where n is the number of words and l is the average length of words in dict      
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes 

//Approach 1: BFS

/*
create a trie with all the words given
Iterate over each of them usinf BFS -> the last element to pop would be the word in the last level 
Last level = longest word 
We don't add it to the queue if the word is not present in the list
Add the nodes right to left to preserve the lexicographical order
*/

// Class to contruct the Trie Node
class TrieNode {
public:
    string word;
    vector<TrieNode*> children;
    TrieNode(){
        children = vector<TrieNode*> (26);
    }
};

class Solution {
public:
    TrieNode* root;
    string longestWord(vector<string>& words) {
        root = new TrieNode();

        // create the trie with
        for(string word:words)
            insert(word);
        
        //BFS
        queue<TrieNode*> q;
        q.push(root);
        TrieNode* curr;

        // iterate over the nodes in the queue
        while(!q.empty()){
            curr = q.front();
            q.pop();
            // right to left such that the last popped elem from queue is lexicographically the smallest
            for(int i=25; i>=0; i--){
                // push only if there is a next letter and the word at that point is in the list
                // i.e., the childs word is not empty
                if(curr->children[i] != NULL && curr->children[i]->word.size() != 0){
                    q.push(curr->children[i]);
                }
            }
        }
        return curr->word;
    }

private:
    void insert(string word){
        TrieNode* curr = root;
        for(char c:word){
            if(curr->children[c-'a'] == NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        // adding the word at the level if it's present in the list
        curr->word = word;
    }
};



// Approach 2: DFS based solution
class TrieNode {
public:
    string word;
    vector<TrieNode*> children;
    TrieNode(){
        children = vector<TrieNode*> (26);
    }
};

class Solution {
    string result;
public:
    TrieNode* root;
    string longestWord(vector<string>& words) {
        root = new TrieNode();
        for(string word:words)
            insert(word);
        
        //DFS
        dfs(root);
        return result;
    }

private:
    void insert(string word){
        TrieNode* curr = root;
        for(char c:word){
            if(curr->children[c-'a'] == NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->word = word;
    }

    // call the dfs function only if the next letter is present and there is a valid word there 
    // every time there is a valid word, make a comparison with result
    void dfs(TrieNode* node){
        for(int i=0; i<26; i++){
            if(node->children[i] != NULL && node->children[i]->word.size() != 0){
                if(result.length() < node->children[i]->word.length())
                    result = node->children[i]->word;
                dfs(node->children[i]);
            }
        }
    }
};