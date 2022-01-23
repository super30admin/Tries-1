class TrieNode:
    
    def __init__(self):
        self.hasharr = [None for i in range(26)]
        self.check = False
    
class Trie:

    def __init__(self):
        self.BaseNode = TrieNode()
        
    def insert(self, word: str) -> None:
        temp_base = self.BaseNode
        for i,char in enumerate(word):
            if temp_base.hasharr[ord(char) - ord('a')] is None:
                temp_base.hasharr[ord(char) - ord('a')] = TrieNode()
            temp_base = temp_base.hasharr[ord(char) - ord('a')]
            if i == len(word)-1:
                temp_base.check = True 

    def search(self, word: str) -> bool:
        i = 0
        
        temp = self.BaseNode
        check = False
        while i < len(word):
            if temp.hasharr[ord(word[i]) - ord('a')] is None:
                return False
            else:
                temp = temp.hasharr[ord(word[i]) - ord('a')]
                i += 1
        return True and temp.check

    def startsWith(self, prefix: str) -> bool:
        i = 0
        temp = self.BaseNode
        while i < len(prefix):
            if temp.hasharr[ord(prefix[i]) - ord('a')] is None:
                return False
            else:
                temp = temp.hasharr[ord(prefix[i]) - ord('a')]
                i += 1
        return True 

class Solution:
    def longestWord(self, words: List[str]) -> str:
        Node = Trie()
        for word in words:
            Node.insert(word)
            print(Node.search(word))
        Queue = []
        
        for char in Node.hasharr:
            if char not None and char.check:
                Queue.append(char)
        if len(Queue) == 0:
            return ""
        ans = Queue[0]
        while Queue:
            
                        
        
        return ""
    
# class Solution(object):
#     def longestWord(self, words):
#         wordset = set(words)
#         words.sort(key = lambda c: (-len(c), c))
#         for word in words:
#             check = True
#             for i in range(1,len(word)+1):
#                 if all(word[:k] in wordset for k in range(1, len(word)+1)):
#                     return word

#         return ""