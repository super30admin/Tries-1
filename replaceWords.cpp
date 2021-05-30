/*
Intuition: Store all th elements in the 'dictionary' in a trie.
Use this trie to find words with prefixes in the sentence
#####################################################################
Time Complexity : O(L) , L = length of the sentence
Space Complexity : O(L), L = length of the longest word in the dictionary
*/
class TrieNode{
    public:
        TrieNode* children[26];
        bool isWord = false;
        TrieNode(){
            bool isWord = false;
            for( int i =0; i < 26; i++){
                children[i] = NULL;
            }
        }   
};

class Solution {
public:
    TrieNode* root;
    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new TrieNode();
        vector<string> splitArray;
        for ( auto word : dictionary){
            insertInTrie(word);
        } 
        stringstream ss(sentence);
        string w;                 
        while (ss >> w){
            splitArray.push_back(w);
        }

        string result;
        string replacement;
        TrieNode* currentNode;
        for ( int j =0; j <splitArray.size(); j++){
            if ( j >0){
                result += ' ';
            }
            string word = splitArray[j];
            cout << word <<" ";
            currentNode = root;
            replacement = "";
            for ( int i = 0; i < word.size() ; i++){
                char letter = word[i];
                if ( currentNode->children[letter - 'a'] == NULL or currentNode->isWord ){
                    break;
                }
                replacement = replacement + letter;
                currentNode = currentNode->children[letter - 'a'];
            }
            if( currentNode ->isWord){
                result = result+ replacement;

            }
            else{                   
                result = result+ word;
            }      
        }
        return result;
    }
    
    void insertInTrie(string word){
        TrieNode* currentNode = root;
        for ( int i = 0; i < word.size(); i++){
            char letter = word[i];
            if ( currentNode->children[letter - 'a'] == NULL){
                currentNode->children[letter - 'a'] = new TrieNode();
            }
            currentNode = currentNode->children[letter - 'a'];
        }
        currentNode->isWord = true;
    }
    
};