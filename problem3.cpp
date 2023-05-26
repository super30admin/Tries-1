// no.of words in dictionary : m
// their average word length  : n
// total sentence length: o
// no. of words in sentence = p;
// their average word length = q
// // Time Complexity : O(m*n + o + p*q) => O(o);

// Space Complexity : O(N) (size of trie )(which would be much less than m*n)

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Hint: whenever a dictionary of words is observed , we try to think whether we can use trie.
// add words in thr dictionary to the trie. split the sentence into words.
// find the root of each word and make them as a sentence and return

class Solution {
public:
    class TrieNode{
        public:
        bool flag;
        TrieNode* child[26];
        TrieNode(){
            flag = false;
            for(int i = 0;i<26;i++)
            {
                child[i] = NULL;
            }
        }  
    };
    
    TrieNode* root;
    
    string replaceWords(vector<string>& dictionary, string sentence) {
        if(dictionary.empty() || dictionary.size()==0) return sentence;
        root = new TrieNode();
        for(string &s : dictionary)
        {
            insert(s);
        }
        
        //splitting sentence into word array
        vector<string>arr;
        int pos = 0;
        while((pos=sentence.find(" "))!=string::npos){
            string sub = sentence.substr(0,pos);
            arr.push_back(sub);
            sentence.erase(0,pos+1);
        }
        if(!sentence.empty())
        {
            arr.push_back(sentence);
        }
        
        // finding the root of each word else keep the same word
        string result;
        for(int i = 0;i<arr.size();i++)
        {
            if(i!=0) result+=" ";
            result+=search(arr[i]);
        }
        return result;
    }
    string search(string s) 
    {
        TrieNode* curr = root;
        string p;
        for(int i = 0;i<s.size();i++)
        {
            int idx = s[i] - 97;
            p = p + s[i];
            if(curr->child[idx] == NULL) return s;
            else if(curr->child[idx]->flag ==true) return p;
            curr = curr->child[idx];
        }
        return s;
    }
    void insert(string s)
    {
        TrieNode* curr = root;
        for(int i = 0;i<s.size();i++)
        {
            int idx = s[i] - 97;
            if(curr->child[idx] ==NULL)
            {
                curr->child[idx] = new TrieNode();
            }
            curr = curr->child[idx];
        }
        curr->flag = true;
    }
};