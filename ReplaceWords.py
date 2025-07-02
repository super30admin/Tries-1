from typing import List
class TrieNode :
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            i = ord(c)-ord('a')
            if curr.children[i] == None:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True
      
        
# class Solution:
#     def replaceWords(self, dictionary: List[str], sentence: str) -> str:
#         trie = Trie()
#         for word in dictionary:
#             trie.insert(word)
#         strArr = sentence.split()
#         res = []
#         for s in strArr:
#             curr = trie.root
#             replacement = ""
#             for c in s:
#                 i = ord(c) - ord("a")
#                 if not curr.children[i] or curr.isEnd:
#                     break
#                 replacement+=c
#                 curr = curr.children[i]
#             if curr.isEnd:
#                 res.append(replacement)
#             else:
#                 res.append(s)
#         return ' '.join(res)

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        
        sb = []  # This is like a StringBuilder in Python
        
        for word in sentence.split():
            curr = trie.root
            replacement = []
            for c in word:
                i = ord(c) - ord('a')
                if not curr.children[i] or curr.isEnd:
                    break
                replacement.append(c)
                curr = curr.children[i]
            
            if curr.isEnd:
                sb.append(''.join(replacement))
            else:
                sb.append(word)
        
        return ' '.join(sb)

# class Solution:
#     def replaceWords(self, dictionary: List[str], sentence: str) -> str:
#         hashSet = set(dictionary)
#         res = []
#         strArr = sentence.split()
#         for word in strArr:
#             flag = False
#             for i in range(len(word)):
#                 prefix = word[0:i+1]
#                 if prefix in hashSet:
#                     flag = True
#                     res.append(prefix)
#                 if flag: break
#             if not flag: res.append(word)
#         return " ".join(res)

        
        