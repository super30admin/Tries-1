//TC: O(sum(len(eachword)))
//SC: O(sum(len(eachword)))

class Solution {
    //create a TrieNode class
    class TrieNode{
        public:
        TrieNode *children[26];
        string word = "";
    };   
    
    TrieNode *root;
    //output to be returned
    string output = "";
    
public:
    
    //insert each word into TrieNode
    void insert(vector<string>& words){
        
        for(auto eachStr: words){
            //since we have to add each word from the root.
            TrieNode *curr = root;
            
            //adding each word to trie
            for(int i=0; i<eachStr.size(); i++){
                char ch = eachStr[i];
                if(curr->children[ch-'a'] == NULL){
                    curr->children[ch-'a'] = new TrieNode();
                }
                
                curr = curr->children[ch-'a'];
            }
            //done with word
            curr->word = eachStr;
            cout<<curr->word<<endl;
        }    
    }
    
    
    //dfs traversal
    void dfs(TrieNode *node){
        if(node->word.size() > output.size()){
            output = node->word;
        }
        
        //check each of the elements of TrieNode
        //actual base case
        //since we scan each array in alphabetical order, we get the lexicographical check here as well.
        for(int i=0; i<26; i++){
            //check if the start letter exists and a prefix for this exists
            if(node->children[i]!=NULL && node->children[i]->word!=""){
                dfs(node->children[i]);
            }
        }
    }
    
    
    
    string longestWord(vector<string>& words) {
        //sanity check for input
        root = new TrieNode();
        
        //insert all words in trie
        insert(words);
        
        //dfs traversal
        dfs(root);
        
        return output;
    }
};