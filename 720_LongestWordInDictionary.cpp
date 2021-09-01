// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    class TrieNode{
        public:
        vector<TrieNode*> child;
        string word;
        TrieNode(){
            child = vector<TrieNode*> (26, nullptr);
            word = "";
        }
    };
    TrieNode* root;
    
    void insert(string word){
        TrieNode* curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word[i];
            if(curr->child[c - 'a'] == NULL)
                curr->child[c - 'a'] = new TrieNode();
            curr = curr->child[c - 'a'];
        }
        curr->word = word;
    }
    
    string longestWord(vector<string>& words) {
        if(words.empty() || words.size() == 0)
            return "";
        root = new TrieNode();
        for(string word : words)
            insert(word);
        //BFS
        queue<TrieNode*> q;
        q.push(root);
        TrieNode* curr = root;
        while(!q.empty()){
            curr = q.front();
            q.pop();
            for(int i=25; i>=0; i--){//to maintain lexicographical order
                if((curr->child[i] != nullptr) && (curr->child[i]->word != ""))
                    q.push(curr->child[i]);
            }
        }
        return curr->word;
    }
};
