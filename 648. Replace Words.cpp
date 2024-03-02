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

    int query(node* root, int pos, string& s){
        if(root==nullptr)  return s.length();
        if(pos==s.length())  return s.length();
        
        if(root->leaf)  return pos;

        int idx = s[pos] - 'a';
        return query(root->child[idx], pos+1, s);
    }

};

class Solution {
public:
    vector<string> get_words(string& s){
        vector<string> ret;
        string word = "";

        for(auto &c: s){
            
            if(c==' '){
                ret.push_back(word);
                word = "";
            }
            else{
                word += c;
            }

        }

        ret.push_back(word);
        return ret;
    }

    string replaceWords(vector<string>& dict, string sentence) {
        Trie t;
        for(auto& word: dict)  t.insert(t.root, 0, word);

        auto words = get_words(sentence);
        for(auto& word: words){
            //cout<<word<<endl;

            int till = t.query(t.root, 0, word);
            if(till < word.length())  word = word.substr(0, till);
        }

        string ret = "";
        for(int i=0;i<words.size();i++){
            auto& word = words[i];
            ret += word;
            if(i<words.size()-1)  ret += ' ';
        }

        return ret;

    }
};
