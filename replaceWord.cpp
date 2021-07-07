// Time Complexity : O(nk) + O(lk); n=number of words in dict; k=avg length of words; l=length of sentence
// Space Complexity : O(nk) - space of trie
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create a trie out of the dictionary and tokenize sentence into words
// 2. Search each word in trie, at any point if a char is not found return *, keep adding the char to prefix string
// 3. If input word is parsed or trie reaches char with isEnd=true, return prefix.
// 4. Keep forming result string by appending prefix/orig word (depending on if prefix exists) with a space. Remove final space separately

class TrieNode{
public:
    vector<TrieNode*> children;
    bool isEnd;
    
    TrieNode(){
        isEnd = false;
        children.resize(26);
        for(auto child: children)
            child=nullptr;
    }
    
    void createTrie(vector<string>& dict){
        for(string word: dict){
            TrieNode* root = this;
            for(char w: word){
                if(root->children[w-'a'] == nullptr)
                    root->children[w-'a'] = new TrieNode();
                root = root->children[w-'a'];
            }
            root->isEnd = true;
        }
    }
};

class Solution {
public:
    string findPrefix(TrieNode* root, string word){
        string prefix="";
        for(char w: word){
            if(root->children[w-'a'] == nullptr)
                return "*";
            prefix+=w;
            root=root->children[w-'a'];  
            if(root->isEnd == true)
                return prefix;
        }
        return prefix;
    }
    
    string replaceWords(vector<string>& dict, string sentence) {
        TrieNode* root = new TrieNode();
        root->createTrie(dict);
        stringstream sstr(sentence);
        string word, result;;
        while(getline(sstr, word, ' ')){
            string prefix = findPrefix(root, word);
            if(prefix=="*")
                result += word; 
            else
                result += prefix;
            result+=" ";
        }
        result.pop_back();
        return result;
    }
};