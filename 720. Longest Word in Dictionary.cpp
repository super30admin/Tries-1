class Trie{
    struct node{
        bool leaf = false;
        vector<node*> child;

        node(){
            for(int i=0;i<26;i++)  child.push_back(nullptr);
        }
    };

    public:
    node* root = new node();
    
    void insert(node* root, int pos, string& s){
        if(pos==s.length()){
            root->leaf = true;
            return;
        }

        int idx = s[pos] - 'a';
        if(root->child[idx] == nullptr)  root->child[idx] = new node();

        insert(root->child[idx], pos+1, s);
    }

    string ans = "";

    void trav(node* root, string s){
        if(root==nullptr || !root->leaf )  return;
        
        if(s.length()>ans.length())  ans = s;
        if(s.length()==ans.length())  ans = min(ans, s);


        for(int i=0;i<26;i++)        
            trav(root->child[i], s + (char)('a'+i));
    }
};

class Solution {
public:
    string longestWord(vector<string>& words) {
       Trie t;
       t.root->leaf = true;
       for(auto word: words)  t.insert(t.root, 0, word);
       t.trav(t.root, "");
       return t.ans;
    }
};
