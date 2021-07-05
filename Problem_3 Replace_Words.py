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
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] is None:
                curr.children[ord(c) - ord('a')] = TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)

        split_array = sentence.split()
        result = []
        # handling spaces
        for word in split_array:
            replacement = ""
            curr = self.root
            for i in range(len(word)):
                c = word[i]
                if curr.children[ord(c) - ord('a')] == None or curr.isEnd:
                    break
                    # there are 2 cases here :
                    # one is Not Found
                    # second is Found Small Prefix
                curr = curr.children[ord(c) - ord('a')]
                replacement += c
            if curr.isEnd:
                # we found the smallest prefix
                result.append(replacement)
            else:
                # we didn't find
                result.append(word)

        return " ".join(result)


