#Time Complexity :  O(N * M + W * M), where N is the number of words in the dictionary,
#M is the length of the longest word, and W is the number of words in the sentence.
#Space Complexity :O(N * M + W)
#Did this code successfully run on Leetcode : yes

from ast import List


class Solution:
    class Node:
        def __init__(self):
            self.node = [None] * 26
            self.flag = False

        def set_end(self):
            self.flag = True

    class Trie:
        def __init__(self):
            self.root = Solution.Node()

        def insert(self, word: str) -> None:
            node = self.root
            for char in word:
                index = ord(char) - ord('a')
                if not node.node[index]:
                    node.node[index] = Solution.Node()
                node = node.node[index]
            node.set_end()

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Solution.Trie()
        for prefix in dictionary:
            trie.insert(prefix)
        
        words = sentence.split()
        result = []
        for word in words:
            replacement = ""
            node = trie.root
            
            for char in word:
                index = ord(char) - ord('a')
                if node.node[index] is None or node.flag:
                    break
                node = node.node[index]
                replacement += char
            
            result.append(replacement if node.flag else word)
        
        return " ".join(result)