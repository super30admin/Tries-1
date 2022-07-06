// Time Complexity - To form the 'Trie' - m*l, where, 'm' is the number of words in the dictionary and 'l' is the average length of words.
//                   To replace -> n*l, 'n' is the number of words in the sentence and 'l' is the average length of the words.
// Space Complexity - O(n*l) -> 'n' is the number of wrods in the sentence and 'l' is the average length of wrds in the sentence.
// Problems Faced - No!
// It runs on Leetcode!

class Solution {
    
     struct TrieNode{
        bool isEnd; 
        TrieNode* children[26] = {NULL};
        public: TrieNode(){
            isEnd = false;
        }
    };
    TrieNode* root;
    
public:
    void insert(string word) {
        TrieNode* curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word[i];
            int index = word[i] - 'a';
            if(curr->children[index] == NULL)
                curr->children[c-'a'] = new TrieNode();
            curr = curr->children[c-'a'];
        }
        curr->isEnd = true;
        
    }
    
public:
    string replaceWords(vector<string>& dictionary, string sentence) {
        string answer;
        root = new TrieNode();
        for(string str : dictionary)
            insert(str);
        istringstream ss(sentence);
        string word;
        vector<string> words;
        while(ss >> word)
            words.push_back(word);
        cout << "size: " << words.size();
        
        for(int i = 0; i < words.size(); i++){
            string word = words[i];
            string replace;
            TrieNode* curr = root;
            if(i != 0)
                answer += " ";
            for(int j = 0; j < word.length(); j++){
                char c = word[j];
                if(curr->children[c-'a'] == NULL || curr->isEnd)
                    break;
                replace += c; 
                curr = curr->children[c-'a'];
            }
            if(curr->isEnd)
                answer += replace;
            else
                answer += word ;
        }
        
        return answer;
    }
};