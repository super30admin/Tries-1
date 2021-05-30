/*
Intuition: Apply BFS. At each queue.pop() check if it is a word and iterate in reverse order to get the longest word.
#####################################################################
Insertion:
Time Complexity : O(L) , L = length of the word to be inserted
Space Complexity : O(L), L = length of the word to be inserted ( which will be also the height: worst case)
#####################################################################
longestWord:
Time Complexity : O(L) , To serch the word in the trie,  L = length of the word
Space Complexity : O(L), L = length of the word to be inserted ( which will be also the height: worst case)
*/
class TrieNode{
    public:
        bool isWord;
        TrieNode * children[26];
        string word;
        TrieNode(){
            isWord = false;
            for ( int i =0; i < 26; i++){
                children[i] = NULL;
            }
        }
};
class Solution {
    
public:
    TrieNode* root = new TrieNode();
    
    string longestWord(vector<string>& words) {
        string result;
        for (auto word: words){
            insertWordInTrie(word);
        }
        TrieNode* curr = NULL;
        queue <TrieNode*> queue;
        
        // for ( int i = 0; i <26 ; i++){
        //     if (root->children['z'-i] != NULL) queue.push(root->children['z'-i]);
        // }
        
        queue.push(root);
        while (queue.size()!=0){
        
            int size = queue.size();
            for ( int i =0; i < size; i++){
                curr = queue.front();
                queue.pop();
                
                for(int j=25; j>=0; j--){

                    if(curr->children[j]!=NULL && curr->children[j]->isWord){

                        queue.push(curr->children[j]);
                    }
                }
            }
        
        }
        
        return curr->word; 
        
    }
    void insertWordInTrie(string word){
        
        TrieNode* currentNode = root;
        for ( int i =0; i < word.size(); i++){
            char letter = word[i];
            
            if ( currentNode->children[letter - 'a']== NULL){
                currentNode->children[letter - 'a'] = new TrieNode();
            }
            
            currentNode = currentNode->children[letter - 'a'];
        }
        currentNode->isWord = true;
        currentNode->word = word;

    }
};