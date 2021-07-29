# Time Complexity: O(mn) + O(kl),
#        where m - num of words in dictionary, n - average length of words in dict
#        where k - num of words in the sentence, l - average length of words in the sentence
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode: Yes

# Solution:

class TrieNode:
    def __init__(self):
        self.is_end = False
        self.children = [None for x in range(26)]


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if not dictionary or len(dictionary) == 0:
            return sentence

        # Initialize the root of Trie
        self.root = TrieNode()

        # Insert all words from dictionary into the Trie
        for word in dictionary:
            self.insert(word)

        result = []

        # Search for a replacement in the Trie for every word of the sentence
        str_words = sentence.split()
        for word in str_words:
            replacement = ""
            curr = self.root
            for ch in word:
                if curr.children[ord(ch) - ord('a')] == None or curr.is_end:
                    break
                replacement += ch
                curr = curr.children[ord(ch) - ord('a')]

            # If replacement exists, append to the result else append the same word
            if curr.is_end:
                result.append(replacement)
            else:
                result.append(word)

        return " ".join(result)


    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            if not curr.children[ord(ch) - ord('a')]:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        curr.is_end = True



