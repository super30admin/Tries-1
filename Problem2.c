/* Problem Statement:
Verified on leetcode

720. Longest Word in Dictionary
Easy

Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Example 1:

Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:

Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

Note:
All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].


 *
 * Time Complexity : O(26 ^ N) where 26 alphabets with N as the max height of prefix tree. 
 * Space Complexity : O(1) excluding the result array 
 */


/*CASE MISSED : 
 *
 * input dict : a, aa, aaa, aaaaa, aaaaaa, 
 Missed setting \0 in output string at correct point
 */
#define ALPHABETS 26
typedef struct Trie {
    bool is_word;
    int dict_idx;
    int len_word;
    struct Trie *map[ALPHABETS];
}trie_t;

void build_trie(trie_t *trie, char *word, int dict_idx) {
    trie_t *new_node = NULL;
    trie_t *temp = NULL;
    int map_idx = 0;
    int len_word = 0;
    temp = trie;
    /* no validations for pointers : INTENTIONAL */
    while(*word != '\0') {
        map_idx = *word - 'a';
        if (temp->map[map_idx] == NULL) {
            new_node = (trie_t *)calloc(1, sizeof(trie_t));
            temp->map[map_idx] = new_node;
            temp = new_node;
        } else {
            temp = temp->map[map_idx];
        }
        len_word++;
        word++;
    }
    temp->is_word = true;
    temp->dict_idx = dict_idx;
    temp->len_word = len_word;
}

void traverse_trie(trie_t *trie) {
    int idx = 0;
    
    if (!trie) {
        return;
    }
    if (trie->is_word == true) {
        printf(" ::: %d,%d\n", trie->dict_idx,trie->len_word);
    }
    for (idx = 0; idx < ALPHABETS; idx++) {
        if (trie->map[idx] != NULL) {
            printf("%c->", idx + 97);
            traverse_trie(trie->map[idx]);
        }
    }
}

void trieFree(trie_t* trie) {
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

/* HELPER FUNCTION
 * Tasks
 * 1. Traverse through trie. Keep going in a specific direction until is_word is true 
 * 2. Once we get is_word false, record that result if its length is larger than current result length
 * 3. If is_word is not false and we reach the end of the prefix tree for that specific section, then check for length and update
 * result accordingly
 * dict_idx_ans stores the index of the answer present in the input and len_of_ans is used as marker to keep track of the answer 
 */
void search_trie_for_ans(trie_t *prev_trie, trie_t *trie, int *dict_idx_ans, int *len_of_ans) {
    int idx = 0;
    bool is_empty = true;
    
    /* Record result here if there is a path where its not a word */
    if (prev_trie != NULL && trie->is_word == false) {
        if (*len_of_ans < prev_trie->len_word) {
            *len_of_ans = prev_trie->len_word;
            *dict_idx_ans = prev_trie->dict_idx;
        }
        return;
    }
    /* traverse through all nodes for a specific level */
    for (idx = 0; idx < ALPHABETS; idx++) {
        if (trie->map[idx] != NULL) {
            is_empty = false; 
            search_trie_for_ans(trie, trie->map[idx], dict_idx_ans, len_of_ans);
        }
    }
    /* Reached end of prefix tree for that specific, node update the result */
    if (is_empty) {
        if (*len_of_ans < trie->len_word) {
            *len_of_ans = trie->len_word;
            *dict_idx_ans = trie->dict_idx;
        }
        return;     
    }
    
}

char * longestWord(char ** words, int wordsSize){
    int len_of_ans = 0;
    int idx = 0;
    trie_t *trie = NULL;
    int dict_idx_ans = -1;
    
    /* validations */
    if (!wordsSize) {
        return NULL;
    }
    /* alloc memory */
    trie = (trie_t *)calloc(1, sizeof(trie_t));
    
    /* Build trie */
    for (idx = 0; idx < wordsSize; idx++) {
        build_trie(trie, words[idx], idx);        
    }
    /* search for our answer :) */
    search_trie_for_ans(NULL, trie, &dict_idx_ans, &len_of_ans);
    trieFree(trie);
    return words[dict_idx_ans];
}




/* Execute on leetcode platform */


