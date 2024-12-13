# Approach:
# To efficiently replace words in the sentence with their shortest root from the dictionary, we use a Trie.
# We insert all roots into the Trie, then for each word in the sentence, find the shortest root in the Trie that matches the word.
# If no root matches, we keep the word as is.

# Time Complexity:
# - Building the Trie: O(n * k), where n is the number of roots and k is the average length of a root.
# - Processing the sentence: O(m * l), where m is the number of words in the sentence and l is the average length of a word.
# Space Complexity: O(n * k) for the Trie.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Helper function to build the Trie
        def build_trie():
            root = {}
            for word in dictionary:
                node = root
                for char in word:
                    if char not in node:
                        node[char] = {}
                    node = node[char]
                # Mark the end of the word
                node['isEnd'] = True
            return root
        
        # Helper function to find the shortest root for a word
        def find_root(word):
            node = trie
            prefix = ""
            for char in word:
                if char not in node:
                    break
                node = node[char]
                prefix += char
                # If we find the end of a root, return it
                if 'isEnd' in node:
                    return prefix
            return word
        
        # Step 1: Build a Trie from the dictionary
        trie = build_trie()
        
        # Step 2: Process each word in the sentence and replace it with the root if available
        words = sentence.split()
        for i in range(len(words)):
            words[i] = find_root(words[i])
        
        # Step 3: Join the processed words back into a sentence
        return " ".join(words)
