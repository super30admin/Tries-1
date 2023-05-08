# Time Complexity : O(N * M), where N is the number of words in the sentence and M is the maximum length of a word
# Space Complexity : O(L), where L is the total number of characters in the dictionary words
from typing import List
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = {}
        
        # Build the Trie data structure
        for word in dictionary:
            node = trie
            for char in word:
                if char not in node:
                    node[char] = {}
                node = node[char]
            node['#'] = True
        
        def search_prefix(word):
            node = trie
            prefix = ""
            for char in word:
                if char not in node:
                    break
                prefix += char
                if '#' in node[char]:
                    return prefix
                node = node[char]
            return word
        
        result = []
        for word in sentence.split():
            result.append(search_prefix(word))
        
        return " ".join(result)