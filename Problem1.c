/* Problem Statement:
Verified on leetcode

208. Implement Trie (Prefix Tree)
Medium

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.



 *
 * Time Complexity : O(n), insertion, searching, deleting where n is size of the input string
 *
 */



#define ALPHABETS 26
typedef struct Trie{
    bool is_word;
    int dict_idx;
    struct Trie *map[ALPHABETS]; 
} Trie;

/** Initialize your data structure here. */

Trie* trieCreate() {
    Trie *new_trie = (Trie *)calloc(1, sizeof(Trie));
    return new_trie;
}

/** Inserts a word into the trie. */
void trieInsert(Trie* obj, char * word) {
    Trie *new_node = NULL;
    Trie *temp = NULL;
    int map_idx = 0;
    
    temp = obj;
    /* no validations for pointers : INTENTIONAL */
    while(*word != '\0') {
        map_idx = *word - 'a';
        if (temp->map[map_idx] == NULL) {
            new_node = (Trie *)calloc(1, sizeof(Trie));
            temp->map[map_idx] = new_node;
            temp = new_node;
        } else {
            temp = temp->map[map_idx];
        }
        word++;
    }
    temp->is_word = true;
}

/** Returns if the word is in the trie. */
bool trieSearch(Trie* obj, char * word) {
    int idx = 0;
    Trie *temp = NULL;
    int map_idx = 0;
    
    temp = obj;
    /* no validations for pointers : INTENTIONAL */
    while(*word != '\0') {
        map_idx = *word - 'a';
            
        if (temp->map[map_idx] != NULL) {
            temp = temp->map[map_idx];
            word++;
        } else {
            return false;
        }
    }
    return temp->is_word; 
}

/** Returns if there is any word in the trie that starts with the given prefix. */
bool trieStartsWith(Trie* obj, char * prefix) {
    
    int idx = 0;
    Trie *temp = NULL;
    int map_idx = 0;
    
    temp = obj;
    /* no validations for pointers : INTENTIONAL */
    while(*prefix != '\0') {
        map_idx = *prefix - 'a';
            
        if (temp->map[map_idx] != NULL) {
            temp = temp->map[map_idx];
            prefix++;
        } else {
            return false;
        }
    }
    /* If I have completed the processing of string and I am still here, it means I have got a string with prefix */
    return true;
}

void trieFree(Trie* trie) {
    int idx = 0;
    
    if (!trie) {
        return;
    }
    for (idx = 0; idx < ALPHABETS; idx++) {
        if (trie->map[idx] != NULL) {
            trieFree(trie->map[idx]);
            free(trie->map[idx]);
        }
    }
}

/**
 * Your Trie struct will be instantiated and called as such:
 * Trie* obj = trieCreate();
 * trieInsert(obj, word);
 
 * bool param_2 = trieSearch(obj, word);
 
 * bool param_3 = trieStartsWith(obj, prefix);
 
 * trieFree(obj);
*/
/* Execute on leetcode platform */


