// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes could not implement it successfully


// Your code here along with comments explaining your approach
class Solution {
public:
    class TrieNode {
        public:
        TrieNode *child[26];
        bool isEnd;
        TrieNode () {
            isEnd=false;
            for (int i=0;i<26;i++)
                child[i]=NULL;
        }
    };
    
    int insert(TrieNode *root,string key) {
        TrieNode *curr=root;
        int count;
        for (int i=0;i<key.length();i++) {
            int index=key[i]-'a';
            if (curr->child[index]!=NULL) {
                count++;// number of nodes not created created
            } else {
                curr->child[index]=new TrieNode();
            }
            curr=curr->child[index];
        }
        curr->isEnd=false;
        return count;
    }
    
    string longestWord(vector<string>& words) {
        sort(words.begin(),words.end());
        TrieNode *root=new TrieNode();
        int maxi=INT_MIN;
        string s;
       
        for (int i=0;i<words.size();i++) {
            int sizeOfStringCreated=insert(root,words[i]);
            if (sizeOfStringCreated>maxi) {
                maxi=sizeOfStringCreated;
                 s=words[i];
            } 
        }
        return s;
    }
};