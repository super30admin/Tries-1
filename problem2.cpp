// Time Complexity :  O(m*n) avg. wordlength * no. of words

// Space Complexity : O(m*n) avg. wordlength * no. of words( in a trie, the space occuppies will be much less than this)

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Hint: whenever we see a problem dealing with prefixes  or a dictionary ,we should think if we can make use of atrie.

// Trie + dfs with backtracking

class Solution {
public:
    class Node{
        public:
        bool flag;
        Node* child[26];
        Node(){
            flag = false;
            for(int i = 0;i<26;i++)
            {
                child[i] = NULL;
            }
        }
    };
    Node* root;
    string ans = "";
    string longestWord(vector<string>& words) {
        if(words.empty() || words.size()==0) return "";
        root = new Node();
        for(string &s : words)
        {
            insert(s);
        }
        string s = "";
        dfs(root,s);
        return ans;
    }
    void dfs(Node* root,string &s)
    {
        if(ans.size() == s.size() && ans > s) ans = s;
        else if ( ans.size() < s.size()) ans =s;
        Node* curr = root;
        for(int i = 0;i<26;i++)
        {
            if(curr->child[i]!=NULL && curr->child[i]->flag == true)
            {
                s = s + char(i+97);
                dfs(curr->child[i], s);
                s.pop_back();
            }
        }
    }
    void insert(string s)
    {
        Node* curr = root;
        for(int i = 0;i<s.size();i++)
        {
            int idx = s[i] - 97;
            if(curr->child[idx]==NULL)
            {
                curr->child[idx] = new Node();
            }
            curr = curr->child[idx];
        }
        curr->flag = true;
    }
};

// Trie + BFS by adding a string in the trie data structure

class Solution {
public:
    class TrieNode{
        public:
        bool flag;
        string Ns;
        TrieNode* child[26];
        TrieNode(){
            flag = false;
            Ns = "";
            for(int i = 0;i<26;i++)
            {
                child[i] = NULL;
            }
        }
    };
    TrieNode* root;
    string longestWord(vector<string>& words) {
        if(words.empty() || words.size()==0) return "";
        root = new TrieNode();
        for(auto &s:words)
        {
            insert(s);
        }
        string ans = "";
        queue<TrieNode*>q;
        q.push(root);
        while(!q.empty())
        {
            TrieNode* curr = q.front();q.pop();
            for(int i = 25;i>=0;i--)
            {
                if(curr->child[i]!=NULL && curr->child[i]->flag == true)
                {
                    ans = curr->child[i]->Ns;
                    q.push(curr->child[i]);
                }
            }
        }
        return ans;
    }
    void insert(string s)
    {
        string temp ="";
        TrieNode * curr = root;
        for(int i = 0;i<s.size();i++)
        {
            temp+=s[i];
            int idx = s[i] - 97;
            if(curr->child[idx] == NULL)
            {
                curr->child[idx] = new TrieNode();
            }
            curr = curr->child[idx];
            curr->Ns = temp;
        }
        curr->flag = true;
    }
};


// Trie + dfs by adding a string in the trie data structure

class Solution {
public:
    class Node{
        public:
        string Ns;
        bool flag;
        Node* child[26];
        Node(){
            Ns = "";
            flag = false;
            for(int i = 0;i<26;i++)
            {
                child[i] = NULL;
            }
        }
    };
    Node* root;
    string ans = "";
    string longestWord(vector<string>& words) {
        if(words.empty() || words.size()==0) return "";
        root = new Node();
        for(string &s : words)
        {
            insert(s);
        }
        string s = "";
        dfs(root,s);
        return ans;
    }
    void dfs(Node* root,string &s)
    {
        if(ans.size() == s.size() && ans > s) ans = s;
        else if ( ans.size() < s.size()) ans =s;
        Node* curr = root;
        for(int i = 0;i<26;i++)
        {
            if(curr->child[i]!=NULL && curr->child[i]->flag == true)
            {
                s = curr->child[i]->Ns;
                dfs(curr->child[i], s);
            }
        }
    }
    void insert(string s)
    {
        Node* curr = root;
        string temp;
        for(int i = 0;i<s.size();i++)
        {
            temp+=s[i];
            // cout << "temp "<<i<<" "<<temp<<endl;
            int idx = s[i] - 97;
            if(curr->child[idx]==NULL)
            {
                curr->child[idx] = new Node();
            }
            curr = curr->child[idx];
            
            curr->Ns = temp;
        }
        curr->flag = true;
    }
};

// Trie + traversing each word in the trie and find the answer

class Solution {
public:
    class Node{
        public:
        bool flag;
        Node* child[26];
        Node(){
            flag = false;
            for(int i = 0;i<26;i++)
            {
                child[i] = NULL;
            }
        }
    };
    Node * root;
    string longestWord(vector<string>& words) {
        if(words.empty() || words.size()==0) return "";
        root = new Node();
        for(string &s: words)
        {
            insert(s);
        }
        string ans = "";
        for(string &s: words)
        {
            if(checkAllPrefix(s))
            {
                if((ans.size()== s.size() && (ans>s)) || (ans.size()<s.size()))
                {
                    ans = s;
                }
            }
        }
        return ans;
    }
    bool checkAllPrefix(string s)
    {
        Node* curr = root;
        for(int i = 0;i<s.size();i++)
        {
            int idx = s[i] - 97;
            curr = curr->child[idx];
            if(curr->flag == false) return false;
        }
        return true;
    }
    void insert(string s)
    {
        Node* curr = root;
        for(int i = 0;i< s.size();i++)
        {
            int idx = s[i] - 97;
            if(curr->child[idx] ==NULL)
            {
                curr->child[idx] = new Node();
            }
            curr = curr->child[idx];
        }
        curr->flag = true;
    }
};