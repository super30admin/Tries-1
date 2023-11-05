class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.is_end = False

class Solution:
    """
		Time Complexity:O(sum(length of each word))
          - this is the complexity to build the trie, and to search it.
        Space Complexity: O(sum(length of each word)) 
          - space to store the Trie
        Did this code successfully run on Leetcode: Yes
    
        Any problem you faced while coding this: No
    """    
    def longestWord(self, words: List[str]) -> str:
        root = TrieNode()

        # populate all words in the trie 
        for word in words:
            node = root
            for char in word:
                if char not in node.children:
                    node.children[char] = TrieNode()
                node = node.children[char]
            node.is_end = True

        result = ''

        # Loop through all words in array
        for word in words:
            # skip the subsequent processing if the current word length is smaller than result 
            print (f"result={result}  word={word}")
            if len(word) < len(result):
                continue

            node = root

            # For every char in the current word, the trie should
            # have the word i.e. where node.is_end=True 
            # i.e. every prefix is a stand-alone word.
            for char in word:
                node = node.children[char]
                if not node.is_end: 
                    break

                # if we reach end of the word, and all combinations were found
                # then check if the current word is longer than current result,
                # (because we need the LONGEST word)
                # If the length is same, then do lexical comparison 
                # (since we need the SMALLEST lexical word)
            if node.is_end and (len(word) > len(result) or (len(word) == len(result) and word < result)):
                result = word

        return result
