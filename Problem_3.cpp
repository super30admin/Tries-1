//Time Comp: O(M*N)
//Space Comp: O(M*N)
class TrieNode{
    public:
        bool isEnd;
        TrieNode* childrens[26]={nullptr};
        TrieNode(){
            isEnd = false;
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
                 if(i==word.length()-1) temp->isEnd = true;
                trav->childrens[word.at(i)-'a'] = temp;
                trav = temp;
            }
            else{
                trav = trav->childrens[word.at(i)-'a'];
                if(i==word.length()-1) trav->isEnd = true;
            }
        }
    }
    string replace(string word){
        TrieNode* trav = root;
        string temp="";
        for(char i: word){
            temp+=i;
             if(trav->childrens[i - 'a'] != nullptr){
                if(trav->childrens[i - 'a']->isEnd == true) return temp;
                trav = trav->childrens[i - 'a'];
             }
            else{
                 return word;
             }
        }
        return word;
    }
};

class Solution {
public:
    string replaceWords(vector<string>& dict, string sentence) {
        Trie* trie = new Trie();
        for(string s:dict) trie->insert(s);
        istringstream is(sentence);
        string word;
        string t;
        int count = 0;
        while(is >> word){
            if(count==0) t += trie->replace(word);
            else t += " " + trie->replace(word);
            count++;
        }
        return t;
    }
};