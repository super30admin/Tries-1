720. Longest Word in Dictionary

// trie 
class Solution {
private: 
    struct Node{
        Node* arr[26];
        bool end = false;
    };
public:
    Node* root = new Node();
    void trie_insert(string &word){
        Node* node = root;
        for(int i = 0; i < word.size(); i++){
            if(node->arr[word[i] - 'a'] == NULL){
                node->arr[word[i] - 'a'] = new Node();
            }
            node = node->arr[word[i] - 'a'];
        }
        node->end = true;
    }
    bool isValid(string &word, Node* curr){
        for(int i = 0; i < word.size(); i++){
            curr = curr->arr[word[i] - 'a'];
            if(!curr->end) return false;
        }
        return true;
    }
    string longestWord(vector<string>& words) {
        string ans = "";
        for(auto w: words){
            trie_insert(w);
        }    
        for(int i = words.size() - 1; i >= 0; i--){
            if(isValid(words[i], root)){
                if(words[i].length() > ans.length()){
                    ans = words[i];
                }else if(words[i].length() == ans.length()){
                    ans = min(words[i], ans);
                }
            }
        }
        return ans;
    }
};
