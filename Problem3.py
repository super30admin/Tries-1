"""
TC: O(S + W) {where S is the total number of characters in the `dictionary` and W is the total number of characters in the `sentence`. Insertion takes O(S) and the lookup phase traverses the sentence, which takes O(W).}
SC: O(S) {The space is determined by the total number of nodes in the Trie, which is proportional to the total length of all unique prefixes in the `dictionary`.}

Approach:

This problem is optimally solved using a **Trie** (Prefix Tree) data structure. The goal is to efficiently find the shortest **root** (prefix from the dictionary) for every word in the sentence.

1.  **Trie Construction**: First, all words in the `dictionary` are inserted into the Trie. During insertion, an important optimization is implicitly handled in the loop logic: if a word is a longer version of an existing root (i.e., we encounter a node with `ends == True`), we **don't continue inserting** the rest of the current word. This ensures that the trie only stores the minimal required roots and, more importantly, guarantees that when we search, the *first* root we find is the *shortest* one.
2.  **Sentence Traversal**: The input `sentence` is split into individual words. For each word, we traverse the constructed Trie character by character.
3.  **Shortest Root Lookup**: As we traverse, we build the potential `replacer` string. If, at any node, the `ends` flag is `True`, we've found the shortest root that is a prefix of the current word. We immediately replace the word in the result array with this shortest root and **break** the inner loop. If the path in the Trie breaks (i.e., a child is `None`) before a root is found, the original word is kept.

Finally, the modified words are joined back into a single string. The use of the Trie ensures that the lookup for the shortest possible root is performed in linear time relative to the word's length.

The problem ran successfully on LeetCode.
"""
from typing import List
class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.ends = False
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = self.TrieNode()

        #insert all words from dictionary
        for each in dictionary:
            curr = root
            for i in range(len(each)):
                if curr.children[ord(each[i]) - ord('a')] == None:
                    #add trienode
                    curr.children[ord(each[i]) - ord('a')] = self.TrieNode()
                
                #iter to next character
                curr = curr.children[ord(each[i]) - ord('a')]

                if curr.ends == True:
                    break
                        
            curr.ends = True

        result = sentence.split(" ")

        for i in range(len(result)):
            curr = root
            word = result[i]
            replacer = ""
            for j in range(len(word)):
                ch = word[j]
                replacer += ch

                if curr.children[ord(ch) - ord('a')] == None:
                    break
                curr = curr.children[ord(ch) - ord('a')]

                if curr.ends:
                    result[i] = replacer
                    break

        return " ".join(result)
