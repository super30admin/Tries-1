// Time Complexity : insert O(n), search O(n), startsWith O(n)
// Space Complexity :  O(m*n) (Number of insert requests * lengths of strings)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

#define SIZE 26

struct trie_node
{
    bool eow = false;
    struct trie_node* children[SIZE] = {NULL};
};

class Trie {
private:
    struct trie_node* root;
    
    struct trie_node* create_node(void)
    {
        struct trie_node* new_node = new struct trie_node;
                
        return new_node;
    }
    
public:
    /** Initialize your data structure here. */
    Trie() {
        
        root = create_node();
        root->eow = false;
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        
        if(word.size() == 0)
            return;
        
        int ptr = 0;
        int idx;
        
        trie_node* curr_node = root;
        trie_node* temp_node;
        
        while(ptr != word.size())
        {
            idx = word[ptr] - 'a';
            
            if(curr_node->children[idx] == NULL)
            {
                temp_node = create_node();
                temp_node->eow = false;
                
                curr_node->children[idx] = temp_node;
            }
            
            curr_node = curr_node->children[idx];
            
            ptr++;
        }
        
        curr_node->eow = true;
        
        return;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        
        if(word.size() == 0)
            return false;
        
        int ptr = 0;
        int idx = 0;
        
        trie_node* curr_node = root;
        
        while(ptr != word.size())
        {
            idx = word[ptr] - 'a';
            
            if(curr_node->children[idx] == NULL)
                return false;
            
            curr_node = curr_node->children[idx];
            
            ptr++;
        }
        
        if(curr_node)
            return curr_node->eow;
        else
            return false;
        
        //return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        
        if(prefix.size() == 0)
            return false;
        
        int ptr = 0;
        int idx = 0;
        
        trie_node* curr_node = root;
        
        while(ptr != prefix.size())
        {
            idx = prefix[ptr] - 'a';
            
            if(curr_node->children[idx] == NULL)
                return false;
            
            curr_node = curr_node->children[idx]; 
            ptr++;
        }
        
        for(int i = 0; i < SIZE; i++)
            if(curr_node->children[i] != NULL || curr_node->eow == true)
                return true;
        
        return false;
    }
};