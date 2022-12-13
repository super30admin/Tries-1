// Time Complexity : O(m*l) + O(n*k) where m is the size of dict and l is the average length of words in dict, n is the number of words in sentence and k is the average size of the words        
// Space Complexity : O(m*l) + O(n*k)
// Did this code successfully run on Leetcode : Yes 


class TrieNode {
public:
    bool isEnd;
    vector<TrieNode*> children;

    TrieNode () {
        isEnd = false;
        children = vector<TrieNode*> (26, NULL);
    }
};

class Solution {
public:
    TrieNode* root;
    string replaceWords(vector<string>& dictionary, string sentence) {

        root = new TrieNode();

        // create trie for the dictionary
        for(string root:dictionary){
            insert(root);
        }

        stringstream s(sentence);
        string inputWord;

        string result;

        // iterate over each input word
        while(s >> inputWord){
            TrieNode* curr = root;
            string prefixWord;
            for(char c:inputWord){

                // iteration stops when we either hit a NULL (i.e the word is not present in the dict)
                // or we completed going over as prefix Ex: cat from cattle 
                if(curr->children[c-'a'] == NULL || curr->isEnd == true){
                    break;
                }

                // Creating the prefix word to use in result
                prefixWord.push_back(c);
                curr = curr->children[c-'a'];
            }

            // if isEnd is true, we have seen the prefix -> add that to the result
            if(curr->isEnd == true)
                result += prefixWord + ' ';
            else
                result += inputWord + ' ';
        }

        // removing an extra space at the end
        result.erase(result.end()-1);
        return result;
    }

    void insert(string word){
        TrieNode* curr = root;
        for(char c: word){
            if(curr->children[c-'a'] == NULL){
                curr->children[c-'a'] = new TrieNode();
            }
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
    }
};