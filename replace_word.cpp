// Time Complexity : O(n*l + s) : TRie construction + string length
// Space Complexity : O(n*l +s)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//Was facing issues with one of the addition of the word
// Your code here along with comments explaining your approach
//1. The trieNode and the insert functions are created to create the trie
//2. Given sentence is split up based on the delimiter
//3. Each word is searched for the root and replaces on the result

class Solution {
public:
    class TrieNode{
        public:
        bool word_end=false;TrieNode* word_char[26] ={NULL};
    };
    TrieNode *root = new TrieNode();
   void insert(string word) {
        TrieNode *curr= root;
        int index;
        for(index=0; index<word.length();index++){
            if(curr->word_char[word[index]-'a'] ==NULL){
                curr->word_char[word[index]-'a'] = new TrieNode();
            }
            curr = curr->word_char[word[index]-'a'];
        }
        curr->word_end = true;
    }
    string replaceWords(vector<string>& dict, string sentence) {
        //edge case
        if(sentence.length()==0) return "";
        //logic
        //insert all the dictionary words
        for(int i=0; i<dict.size(); i++){
            insert(dict[i]);
        }
        //search for each word in the given sentence
        vector<string> word_sentence; string temp;
        sentence +=' ';
        int k =0;
        for(int i=0; i<sentence.length(); i++){
            if(sentence[i] == ' ' ) {
                word_sentence.push_back(temp); temp.erase();
                continue;
            }
            temp +=sentence[i];
        }
        
        string result;  string temp_result;
        for(int i=0; i<word_sentence.size(); i++){
             TrieNode *curr= root;
             temp = word_sentence[i];
             for(k=0; k<temp.size(); k++){
                 //faced issues to understand this end case
                 if(curr->word_char[temp[k]-'a'] ==NULL || k== temp.size()-1) {
                      result+=temp; temp_result.erase(); break;
                 }
                 temp_result +=temp[k];  
                 curr = curr->word_char[temp[k]-'a'];
                 if(curr->word_end == true) {
                      result+=temp_result;temp_result.erase(); break;
                 }
             }
            result+=" ";
         }
        result.pop_back();
        return result;
    }
};
