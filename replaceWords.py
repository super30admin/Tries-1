# Time Complexity : O(N*L) - L is max key size
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False

class Solution:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        return

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] is None:
                curr.children[ord(c)-ord('a')] = TrieNode() 
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True


    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)

        split_sent = sentence.split()
        result = []

        for word in split_sent:
            replacement = ""
            curr = self.root
            for i in range(len(word)):
                c = word[i]
                if curr.children[ord(c)-ord('a')] is None or curr.isEnd:
                    break
                curr = curr.children[ord(c) - ord('a')]
                replacement += c

            if curr.isEnd:
                result.append(replacement)
            else:
                result.append(word)

        return " ".join(result)