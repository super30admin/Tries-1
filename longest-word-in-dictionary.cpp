//Time - O(sum(len(all words)))
//space - O(sum(len(all words)))

class TrieNode {
    public:
    unordered_map<char,TrieNode*> nodes;
    bool isEnd;
};

class Trie {
    public:
    TrieNode* root;
    
    Trie(){
        root = new TrieNode();
    }
    
    void insert(string word){
       TrieNode* node = root;
       for(auto c:word){
           if(node->nodes.find(c) == node->nodes.end()){
              node->nodes[c] = new TrieNode(); 
           }
           node = node->nodes[c];
       } 
        node->isEnd = true;
    }
    
    bool search(string word){
        TrieNode* node = root;
        for(auto c:word){
            if(node->nodes.find(c) == node->nodes.end() || !node->nodes[c]->isEnd) return false;
            node = node->nodes[c];
        }
        
        return true;
    }
    
    
};

class Solution {
public:
    string longestWord(vector<string>& words) {
        Trie* trie = new Trie();
        string ans = "";
       
        for(auto w: words){
            trie->insert(w);
        }
        
        for(auto w: words){
            if(trie->search(w) && (w.length()>ans.length() || (w.length() == ans.length() && w.compare(ans)<0) )){
                ans = w;
            }
        }
        return ans;
        
    }
};