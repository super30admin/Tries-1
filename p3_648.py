# 648. Replace Words

# TC : O(D * L + W * L), where:
    # D is the number of words in the dictionary
    # W is the number of words in the sentence
    # L is the average length of words
    # Building the Trie takes O(D * L)
    # Processing the sentence takes O(W * L)
# SC : O(D * L), where:
    # The Trie can have at most D * L nodes in the worst case
    # Additional O(W) space for storing the result

# Did this code successfully run on Leetcode : Yes

# Approach :
# Efficient Prefix Matching: Finding the shortest root takes O(L) time instead of checking against each dictionary word
# Automatic Shortest Root: The Trie traversal naturally finds the shortest root first
# Scalability: More efficient for large dictionaries

from ast import List


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Create Trie node class
        class TrieNode:
            def __init__(self):
                self.children = {}
                self.is_end = False
                self.word = ""
        
        # Build Trie from dictionary
        root = TrieNode()
        for word in dictionary:
            current = root
            for char in word:
                if char not in current.children:
                    current.children[char] = TrieNode()
                current = current.children[char]
            current.is_end = True
            current.word = word
        
        # Function to find the shortest root of a word
        def find_root(word):
            current = root
            for char in word:
                if char not in current.children:
                    return word  # No root found
                current = current.children[char]
                if current.is_end:
                    return current.word  # Found a root
            return word  # No root found (should not happen if above logic is correct)
        
        # Process each word in the sentence
        words = sentence.split()
        for i in range(len(words)):
            words[i] = find_root(words[i])
        
        # Join and return the result
        return ' '.join(words)