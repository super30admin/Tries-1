''''
Time Complexity: O(N + m) where N is the total number of characters in the dictionaryand m is total number of words in the sentence
Space Complexity: O(N) where N is the total number of characters in the dictionary
Run on leetcode: YES
'''
class TrieNode:
    def __init__(self, end=False):
        self.end = False
        self.children = [None] * 26


class Solution:
    def replaceWords(self, dictionary: list[str], sentence: str) -> str:
        root = TrieNode()
        for word in dictionary:
            curr = root
            for ch in word:
                idx = ord(ch) - ord('a')
                if not curr.children[idx]:
                    curr.children[idx] = TrieNode()
                curr = curr.children[idx]
            curr.end = True
        result = ""
        stArr = sentence.split()
        for index in range(len(stArr)):
            if index != 0:
                result += " "
            word = stArr[index]
            replace = ""
            curr = root
            for ch in word:
                idx = ord(ch) - ord('a')
                if not curr.children[idx] or curr.end:
                    break
                curr = curr.children[idx]
                replace += ch
            if curr.end :
                result += replace
            else:
                result += word
        return result