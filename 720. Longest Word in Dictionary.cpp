/*
Time Complexity = O(NK)
Space Complexity = O(NK)
where n is the number of strings and k is the average length of the strings.
*/
class Solution {
public:
    class TrieNode{
        public:
        TrieNode *children[26];
        string isEnd="";
    };
    
    TrieNode *root;
    Solution(){
        root = new TrieNode();
        for (int i = 0; i < 26; i++){
            root->children[i] = NULL;
        }
    }
    void insert(string word)
    {
        TrieNode *curr = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word[i];
            if(curr->children[ch-'a']==NULL)
                curr->children[ch-'a']=new TrieNode();
            curr = curr->children[ch-'a'];
        }
        curr->isEnd = word;
    }
    
    string longestWord(vector<string>& words) {
        int i;
        for(i=0;i<words.size();i++)
            insert(words[i]);
        queue<TrieNode*> q;
        TrieNode *curr = root;
        q.push(curr);
        while(!q.empty())
        {
            curr = q.front();
            q.pop();
            for(i=25;i>=0;i--)
            {
                if(curr->children[i]!=NULL && curr->children[i]->isEnd!="")
                    q.push(curr->children[i]);
            }
        }
        return curr->isEnd;
    }
};
