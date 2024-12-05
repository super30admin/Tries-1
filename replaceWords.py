# // Time Complexity :O(M*l+N*l); N : words in dict, M: words in sentence,traversal,insert 
# // Space Complexity :O(N*l+M*l) 
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Trie() vs TrieNode()
class TrieNode:                                     # TrieNode
    def __init__(self):
        self.children = [None] *26                  # for children
        self.isEnd = False                          # final letter?

class Trie:                                         # Trie for root
    def __init__(self):
        self.root = TrieNode()

    def insert(self,word):                          # insert new words as a Trie
        curr = self.root
        for char in word:
            i = ord(char) - ord('a')
            if not curr.children[i]:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isEnd = True
        
    def getShortest(self,word):                     # shortest in dict or curent word
        res = ""
        curr = self.root
        for char in word:
            i = ord(char) - ord('a')
            if not curr.children[i] or curr.isEnd:
                break
            res += char
            curr = curr.children[i]
            if curr.isEnd:
                return res
        return word

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        result = []
        root = Trie()
        
        for word in dictionary:                     # initialize words in dict as TRIE
            root.insert(word)

        for w in sentence.split(" "):               # split sentence and getShortest ever word 
            result.append(root.getShortest(w))
        
        return " ".join(result)