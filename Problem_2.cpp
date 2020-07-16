//Time Comp: O(M*N)
//Space Comp: O(M*N)

class TrieNode{
    public:
        string word;
        TrieNode* childrens[26]={nullptr};
        TrieNode(){
            word="";
        }
};

class Trie {
public:
    /** Initialize your data structure here. */
    TrieNode* root;
    Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode* trav = root;
        for(int i=0; i<word.length(); i++){
            if(trav->childrens[word.at(i)-'a'] == nullptr){
                TrieNode* temp = new TrieNode();
                trav->childrens[word.at(i)-'a'] = temp;
                trav = temp;
            }
            else{
                trav = trav->childrens[word.at(i)-'a'];
            }
        }
        trav->word = word;
    }
};

class Solution {
public:
    Trie* search = new Trie();
    string longestWord(vector<string>& words) {
            for(string s: words){
                search ->insert(s);
            }
        queue<TrieNode*> q;
        q.push(search->root);
        TrieNode* curr = nullptr;
        while(!q.empty()){
            curr = q.front();
            q.pop();
            for(int i=25; i>=0; i--){
                if(curr->childrens[i]!=nullptr && curr->childrens[i]->word!="")q.push(curr->childrens[i]);
            }
        }
        return curr->word;
    }
    
};