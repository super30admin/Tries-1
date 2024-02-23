// TC = O(M * L) / O(N * L); m = no. of words in trie, n = no. of words in sentence
// SC = O(M * L); L = max length of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Trie

class Solution {
public:
    class TrieNode {
        public:
        bool isEnd;
        vector<TrieNode*> children;
        TrieNode() {
            isEnd = false;
            children.resize(26);
        }
    };
    TrieNode* root;
    void insert(string word) {
        TrieNode* curr = root;
        for(int i = 0; i < word.size(); i++) {
            char c = word[i];
            if(curr->children[c -'a'] == NULL) {
                curr->children[c - 'a'] = new TrieNode();
            }
            curr = curr->children[c - 'a'];
        }
        curr->isEnd = true;
    }
    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new TrieNode();
        for(string str: dictionary) { // TC = O(M * L)
            insert(str); // inserting in trie
        }
        string sb = "", result = "", s = "";
        vector<string> strArr;
        for(int i = 0; i < sentence.size(); i++) { // splitting the sentence into words
            if(sentence[i] == ' ') {
                strArr.push_back(s);
                s = "";
            }
            else s += sentence.at(i);
        }
        strArr.push_back(s);
        for(int k = 0; k < strArr.size(); k++) {
            string word = strArr[k];
            if(k != 0) result += " "; // for adding space in between the words
            string replacement = "";
            TrieNode *curr = root;
            for(int i = 0; i < word.size(); i++) {
                char c = word.at(i);
                if(curr->children[c - 'a'] == NULL || curr->isEnd) {
                    break; // come out of loop when we dont find it all or char (in trie) is found & it is complete
                }
                replacement = replacement + c;
                curr = curr->children[c - 'a'];
            }
            if(curr->isEnd) { // we found replacement
                result += replacement;
            }
            else result += word;
        }   
        return result;
    }
};