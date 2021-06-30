// Time Complexity : O(n)
// Space Complexity :  O(m*n) (Number of insert requests * lengths of strings)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

#define SIZE 26

struct trie_node
{
    bool eow = false;
    struct trie_node* children[SIZE] = {NULL};
};

class Solution {
private:
    struct trie_node* root;
    string largest_str;
    int largest_str_len;
    
    struct trie_node* create_node(void)
    {
        struct trie_node* new_node = new struct trie_node;
                
        return new_node;
    }
    
    /** Initialize your data structure here. */
    void Trie_Init() {
        
        root = create_node();
        root->eow = false;
        
        largest_str_len = 0;
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
    
    // Recursive function to find largest word
    void find_largest(trie_node* curr_node, string str, int count, int letter)
    {
        if(curr_node->eow == 0)
            return;
        
        count++;
        str += 'a' + letter;

        // Check for largest length   
        if(count >= largest_str_len)
        {
            largest_str = str;   
            largest_str_len = count;
        }
        
        // Reverse order check if more depth in trie
        for(int i = SIZE-1; i >= 0; i--)
        {
            if(curr_node->children[i] != NULL)
                find_largest(curr_node->children[i], str, count, i);
        }
    }
    
public:
    // Primary Function
    string longestWord(vector<string>& words) {
        
        // Constructor
        Trie_Init();
        
        // Insert all input words in dictionary
        for(int i = 0; i < words.size(); i++)
            insert(words[i]);
        
        string s;
        
        // Search in all 26 starting letters
        for(int j = SIZE-1; j >= 0; j--)
        {
            if(root->children[j] != NULL)
                find_largest(root->children[j], s, 0, j);
        }
        
        return largest_str;
    }
};