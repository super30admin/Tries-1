/* Problem Statement:
Verified on leetcode

648. Replace Words
Medium

In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

 

Note:

    The input will only have lower-case letters.
    1 <= dict words number <= 1000
    1 <= sentence words number <= 1000
    1 <= root length <= 100
    1 <= sentence words length <= 1000


 *
 * Time Complexity : O(n)
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
    struct Trie *map[ALPHABETS];
}trie_t;

void build_trie(trie_t *trie, char *word, int dict_idx) {
    trie_t *new_node = NULL;
    trie_t *temp = NULL;
    int map_idx = 0;
    
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
        word++;
    }
    temp->is_word = true;
    temp->dict_idx = dict_idx;
}

void traverse_trie(trie_t *trie) {
    int idx = 0;
    
    if (!trie) {
        return;
    }
    if (trie->is_word == true) {
        printf(" ::: %d\n", trie->dict_idx);
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

bool search_trie(trie_t *trie, char *word, int *dict_idx) {
    int idx = 0;
    trie_t *temp = NULL;
    int map_idx = 0;
    
    temp = trie;
    /* no validations for pointers : INTENTIONAL */
    while(*word != '\0') {
        map_idx = *word - 'a';
            
        if (temp->map[map_idx] != NULL) {
            temp = temp->map[map_idx];
            if (temp->is_word == true) {
                *dict_idx = temp->dict_idx;
                return true;
            } else {
                word++;
            }
        } else {
            break;
        }
    }
    return false;
}

char * replaceWords(char ** dict, int dictSize, char * sentence){
    trie_t *trie = NULL;
    char *sep = " ";
    char *ctx = NULL;
    char *word = NULL;
    int idx = 0;
    char *result = NULL;
    int res_len = 0;
    char **dict_temp = dict;
    int dict_idx = 0;
    int src_len = 0;
    int size = 0;
    int dbg = 0;
    
    /* Check for invalid dict size */
    if (!dictSize) {
        return result;
    }
    /* Update src len and the size of new string */
    src_len = strlen(sentence);
    size = src_len + 1;
    
    trie = (trie_t *)calloc(1, sizeof(trie_t));
    result = (char *)calloc(1, src_len + 1);
    
    /* Build trie */
    for (idx = 0; idx < dictSize; idx++) {
        build_trie(trie, dict_temp[idx], idx);        
    }
    
    /* Go word by word in the sentence and match it in trie, if it matches write that word, else write the original word
     * in sentence */
    for (word = strtok_r(sentence, sep, &ctx); word; word = strtok_r(NULL, sep, &ctx)) {
        dict_idx = 0;
        if (search_trie(trie, word, &dict_idx)) {
            dbg = snprintf(result + res_len, size - res_len, "%s ", dict[dict_idx]);
            res_len += dbg;
        } else {
            dbg = snprintf(result + res_len, size - res_len, "%s ", word);
            res_len += dbg;
        }
    }
    /* Space is appended at string, so overwrite it with \0 */
    result[res_len - 1] = '\0';
    trieFree(trie);
    return result;
}




/* Execute on leetcode platform */


