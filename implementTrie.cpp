//O(m)-time
//O(m)-space



class TrieNode{
        
    public:
        TrieNode* arr[26];
        bool isEnd=false;
        TrieNode(){
            
            for (int i = 0; i < 26; i++) {
                arr[i] = nullptr;
            }
       
        }
};
class Trie {
    
public:
    TrieNode* root;
    Trie() {
        this->root = new TrieNode();
        
    }
    
    void insert(string word) {
        TrieNode* curr = root;

        for(char i:word){
            if(curr->arr[i-'a']==NULL){
                curr->arr[i-'a']=new TrieNode();

            }
            curr = curr->arr[i-'a'];

            
            
        }
        curr->isEnd=true;
        
    }
    
    bool search(string word) {
        TrieNode* curr = root;

        for(char i:word){
            if(curr->arr[i-'a']==NULL){
                return false;

            }
            else{
                curr=curr->arr[i-'a'];

            }

        }
        return curr->isEnd;

        
    }
    
    bool startsWith(string prefix) {
    TrieNode* curr = root;

    for (char i : prefix) {
        if (curr->arr[i - 'a'] == NULL) {
            return false;
        } else {
            curr = curr->arr[i - 'a'];
        }
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