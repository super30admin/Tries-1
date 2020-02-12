# Time Complexity : O(n)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        for word in dict:
            self.insert(word)

        sentenceList = sentence.split(' ')
        retList = []
        retString = ' '
        for word in sentenceList:
            node = self.root
            for char in word:
                if node.children[ord(char) - ord('a')] is None or node.word is not None:
                    break
                node = node.children[ord(char) - ord('a')]
            replacement = node.word

            if replacement is None:
                retList.append(word)
            else:
                retList.append(replacement)
        return retString.join(retList)
    
    
    def insert(self, word):
        node = self.root
        for char in word:
            if node.children[ord(char) - ord('a')] is None:
                node.children[ord(char) - ord('a')] = TrieNode()
            node = node.children[ord(char) - ord('a')]
        node.word = word
    
    
class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.word = None