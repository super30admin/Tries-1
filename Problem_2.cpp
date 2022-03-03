/**
 * @Time complexity"
 * O(n) where n is the size of the words array
 * 
 */

/**
 * @Space complexity:
 * O(n) wher en is the size of the words array
 * 
 */



// The code ran perfectly on leetcode
class Solution {
    class TrieNode{
        public:
        vector<TrieNode*> children;
        bool isEnd;
        char ch;

        public:
        TrieNode(){
            children.resize(26);
            isEnd = false;
        }
    };
        
    TrieNode *root;
    private:
    void insert(string word){
        TrieNode  *curr = root;
        for(auto c : word){
            if(curr->children[c-'a'] == NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr = curr->children[c-'a'];
            curr->ch = c;
        }
        curr->isEnd = true;
        //curr->s = word;
    }
    string result;
public:
    string longestWord(vector<string>& words) {
        
        root = new TrieNode();
        result = "";
        for(string word: words){
            insert(word);
        }
        
        backtrack(root, "");
        return result;
    }
    
    private:
    void backtrack(TrieNode* curr, string path){
        if(path.size() >= result.size()){
            result= path;
        }
        for(int i = 25; i>=0; i--){
            if(curr->children[i] != NULL && curr->children[i]->isEnd){
                path.push_back(curr->children[i]->ch);
                backtrack(curr->children[i], path);
                path.pop_back();
            }
        } 
    }
    
};