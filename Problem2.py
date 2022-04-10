# Time Complexity : O(summation of words)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False
        self.word = ''
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self,word):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.isWord = True
        node.word = word
        
    def bfs(self):
        q = collections.deque([self.root])
        result = ''
        while q:
            current = q.popleft()
            for  node in current.children.values():
                if node.isWord:
                    q.append(node)
                    if len(result)< len(node.word) or node.word< result:
                        result = node.word
        return result

class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        trie = Trie()
        for word in words:
            trie.insert(word)
        return trie.bfs()
        