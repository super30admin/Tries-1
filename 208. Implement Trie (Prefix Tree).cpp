/*
n = total words, l = max. word length
Time: O(l) for each operation
Space: O(n*l) 
*/

class Trie {
public:
    struct node{
        bool leaf = false;
        vector<node*> child;
        
        node(){
            for(int i=0;i<26;i++)  child.push_back(nullptr);
        }
    };

    node* head;

    Trie() {
        head = new node();
    }
    
    void insert(node* nd, int pos, string& w){
        if(pos==w.length()){
            nd->leaf = true;
            return;
        }  

        int idx = w[pos] - 'a';
        if(nd->child[idx]==nullptr)  nd->child[idx] = new node();
        insert(nd->child[idx], pos+1, w);
    }

    void insert(string w) {
        insert(head, 0, w);
    }

    bool search(node* nd, int pos, string& w, bool prefix){
        if(nd == nullptr)  return false;
        if(pos==w.length())  return prefix || nd->leaf; //for prefix search, just a existing node suffices

        int idx = w[pos] - 'a';
        return search(nd->child[idx], pos+1, w, prefix);
    }
    
    bool search(string w) {
        return search(head,0,w, false);
    }
    
    bool startsWith(string p) {
        return search(head,0,p, true);
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
