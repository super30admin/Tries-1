// Time Complexity : O(N*K)where N is number of word and K is the average length of word.
// Space Complexity : O(N*K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    class TrieNode{
    public:
        bool isEnd;
        vector<TrieNode*> child;
        TrieNode(){
            child = vector<TrieNode*> (26, NULL);
            isEnd = false;
        }
    };
    TrieNode* root;
    void insert(string word){
        TrieNode* curr = root;
        for(int i=0; i<word.length(); i++){
            char c = word[i];
            if(curr->child[c - 'a'] == NULL)
                curr->child[c - 'a'] = new TrieNode();
            curr = curr->child[c - 'a'];
        }
        curr->isEnd = true;
    }
    string replaceWords(vector<string>& dictionary, string sentence) {
        if(sentence.empty() || sentence.length() == 0)
            return sentence;
        //inserting into TrieNode
        root = new TrieNode();
        for(string word : dictionary)
            insert(word);
        //splitting string into array
        istringstream ss(sentence);
        string str;
        vector<string> strArray;
        while(ss >> str){
            strArray.push_back(str);
        }
        //searching and replacing
        str = "";
        for(int i=0; i<strArray.size(); i++){
            if(i>0)
                str += " ";
            string word = strArray[i];
            string replacement;
            TrieNode* curr = root;
            for(int j=0; j<word.length(); j++){
                char c = word[j];
                if(curr->child[c - 'a'] == NULL || curr->isEnd)
                    break;
                replacement += c;
                curr = curr->child[c - 'a'];
            }
            if(curr->isEnd)
                str += replacement;
            else
                str += word;
        }
        return str;
    }
};



