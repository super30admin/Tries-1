// Time Complexity :
for insert function:  O(m) m=word.size();
for search function:  O(m)
for startsWith function: O(m)
// Space Complexity :
for insert: O(m)
for search: O(1)
for startsWith: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// As the lowercase alphabets are 26, we created 26 childnodes. and as we wanted to know whether a char is at the end of a string,
//  we use a bool flag.


class Trie {
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
    Trie() {
        root = new Node();
        
    }
    
    void insert(string word) {
         Node* curr  = root;
        for(int i = 0;i<word.size();i++)
        {
            int idx = word[i] - 97;
            if(curr->child[idx]==NULL)
            {
                curr->child[idx] = new Node();
            }
            curr = curr->child[idx];
        }
        curr->flag = true;
    }
    
    bool search(string word) {
        Node* curr = root;
        for(int i = 0;i<word.size();i++)
        {
            int idx = word[i] - 97;
            if(curr->child[idx]==NULL)
            {
                return false;
            }
            curr = curr->child[idx];
        }
        return curr->flag;
    }
    
    bool startsWith(string prefix) {
        Node* curr = root;
        for(int i = 0;i<prefix.size();i++)
        {
            int idx = prefix[i] - 97;
            if(curr->child[idx] ==NULL)
            {
                return false;
            }
            curr = curr->child[idx];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */