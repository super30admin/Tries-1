// 648. Replace Words
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
            TrieNode()
            {
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
            TrieNode *curr = root;
            for(int i = 0; i < word.size(); i++)
            {
                if(curr->child[word[i] - 'a'] == NULL)
                {
                    curr->child[word[i] - 'a'] = new TrieNode;
                }
                curr = curr->child[word[i] - 'a'];
            }
            curr->isEnd = true;
        }
        string search(string word)
        {
            string str = "";
            TrieNode *curr = root;
            for(int i = 0; i < word.size(); i++)
            {
                if(curr->child[word[i] - 'a'] == NULL)
                    return word;
                str += word[i];
                if(curr->child[word[i] - 'a']->isEnd == true)
                    return str;
                curr = curr->child[word[i] - 'a'];
            }
            return str;
        }
    };
    string replaceWords(vector<string>& dictionary, string sentence) {
        Trie *obj = new Trie();
        string word = "";
        string output = "";
        for(int i = 0; i < dictionary.size(); i++)
            obj->insert(dictionary[i]);
        for(int i = 0; i < sentence.size() + 1; i++)
        {
            if(i == sentence.size() || sentence[i] == ' ')
            {
                output += obj->search(word);
                word = "";
                if(i != sentence.size())
                    output+= " ";
            }
            else
                word += sentence[i];
        }
        return output;
    }
};
