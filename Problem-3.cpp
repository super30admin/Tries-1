/*
Time Complexity = O(NK) + O(L)
Space Complexity = O(NK) + O(L)
where n is the number of words in the sentences, K is the average length of words and L is the length of the sentences.
*/
class Solution {
public:
    class TrieNode{
        public:
        TrieNode *children[26];
        bool isEnd;
    };
    /*TrieNode(){
        for (int i = 0; i < 26; i++)
            root->children[i] = NULL;
    }*/
    TrieNode *root;
    Solution(){
        root = new TrieNode();
        for (int i = 0; i < 26; i++)
            root->children[i] = NULL;
    }
    void insert(string word)
    {
        TrieNode *curr = root;
        for(int i =0 ;i<word.length();i++)
        {
            char ch = word[i];
            if(curr->children[ch - 'a']==NULL)
                curr->children[ch - 'a']=new TrieNode();
            curr = curr->children[ch - 'a'];
        }
        curr->isEnd = true;
    }
    string replaceWords(vector<string>& dictionary, string sentence) {
        int i,j;
        for(i=0;i<dictionary.size();i++)
            insert(dictionary[i]);
        istringstream ss(sentence);
        string finalstring;
        string word;
        int count=0;
        while(ss>>word)
        {
            if(count)
                finalstring.append(" ");
            count++;
            string replace;
            TrieNode *curr = root;
            for(j=0;j<word.length();j++)
            {
                char ch = word[j];
                if(curr->children[ch - 'a'] == NULL || curr->isEnd)
                    break;
                curr = curr->children[ch-'a'];
                replace.push_back(ch);
            }
            if(curr->isEnd)
                finalstring.append(replace);
            else
                finalstring.append(word);
        }
        return finalstring;
    }
};
