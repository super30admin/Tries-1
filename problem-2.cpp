// 720. Longest Word in Dictionary
// Time Complexity : O(n*l)
// Space Complexity :O(n*l*26)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
public:
    class Trie{
        public:
        class TrieNode{
            public:
            bool isEnd;
            TrieNode *child[26];
                TrieNode(){
                    isEnd = false;
                    for(int i = 0; i < 26; i++)
                        child[i] = NULL;
                }
            };
            TrieNode *root;
            Trie(){
                root = new TrieNode();
            }
            void insert(string word){
                TrieNode* curr = root;
                for(int i = 0; i < word.size(); i++)
                {
                    if(curr->child[word[i] - 'a'] == NULL)
                        curr->child[word[i] - 'a'] = new TrieNode();
                    curr = curr->child[word[i] - 'a']; 
                }
                curr->isEnd = true;
            }
            string search(string word, string result, int &maxi)
            {
                TrieNode *curr = root;
                for(int i = 0; i < word.size()-1; i++)
                {
                    curr = curr->child[word[i] - 'a'];
                    if(curr->isEnd == false)
                        return result;
                }
                if(maxi < word.size() || (maxi == word.size() && word < result))
                {
                    maxi = word.size();
                    return word;
                }           
                return result;
            }
        };
    string longestWord(vector<string>& words) {
        string result = "";
        int maxi = 0;
        Trie *trie = new Trie();
        for(int i = 0; i < words.size(); i++)
            trie->insert(words[i]);
        for(int i = 0; i < words.size(); i++)
            result = trie->search(words[i], result, maxi); 
        return result;   

    }
};
