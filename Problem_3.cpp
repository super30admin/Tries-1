/**
 * @Time Complexity:
 * O(n) where n is the number of elements in the sentence
 * 
 */

/**
 * @Space Complexity:
 * O(n) mwhere n is the length of the sentence
 * 
 */

// The code ran perfectly on leetcode

class Solution {
    class TrieNode {
        public:
        bool isEnd;
        vector<TrieNode*> children;
        TrieNode(){
            children.resize(26);
            isEnd = false;
        }  
    };
    
    TrieNode *root;
    
    private:
    void insert(string word){
        TrieNode *curr = root;
        for(auto c: word){
            if(curr->children[c- 'a'] == NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
    }
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new TrieNode();
        for(auto d : dictionary){
            insert(d);
        }
        string extract;
        vector<string> split;
        stringstream s(sentence);
        while(getline(s, extract,' ')){
            split.push_back(extract);
        }
        string res;
        for(int i =0; i<split.size(); i++){
            if(i>0){
                res.push_back(' ');
            }
            string rep;
            TrieNode *curr= root;
            string word = split[i];

            for(int j = 0; j<word.size(); j++){
                char c = word[j];
                if(curr->children[c-'a'] == NULL || curr->isEnd){
                    break;
                }
                rep.push_back(c);
                curr = curr->children[c-'a'];
            }
            if(curr->isEnd){
                res.append(rep);
            } else {
                res.append(word);
            }
        }
        return res;     
    }
};