#LC 720 - Longest Word in Dictionary
#Time Complexity - O(n.k) k being the average length of the word
#Space Complexity - O(n)
from collections import deque
class TrieNode(object):
    
    def __init__(self):
        self.children = dict()
        self.endOfWord = False
        self.word = ""
        
class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        self.root = TrieNode()
       
        def insert(word):
            """
            Inserts a word into the trie.
            :type word: str
            :rtype: None
            """
            currNode = self.root
            for i in range(len(word)):
                char = word[i]
                if char not in currNode.children:
                    currNode.children[char] = TrieNode()
                currNode = currNode.children[char]
            currNode.endOfWord = True
            currNode.word = word
        
        for i in words:
            insert(i)
        
        q = deque()
        q.append(self.root)
        ans = ""
        while q:
            node = q.popleft()
            if len(node.word) >= len(ans):
                if len(node.word) > len(ans) or ans > node.word:
                    ans = node.word
            for child in node.children:
                if node.children[child].endOfWord:
                    q.append(node.children[child])
        return(ans)