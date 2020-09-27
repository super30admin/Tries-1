"""
    // Time Complexity :O(nk)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NA

    //Explanation:
    inline comments
"""

"""
T = O(nk) for inserting inside queue + O(nk)
"""
import collections
class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.word= None

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self,word):
        current = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if current.children[index] == None:
                current.children[index] = TrieNode()
            current = current.children[index]
        current.word= word

class Solution:
    def longestWord(self, words: List[str]) -> str:
        """
            insert all words in trie
        """
        tr = Trie()
        for w in words:
            tr.insert(w)
        """
            apply bfs over the trie.add children inside queue only if
            it is not None and it forms word
        """
        queue = deque([])
        queue.append(tr.root)
        while queue:
            current = queue.popleft()
            for i in range(25,-1,-1):
                if current.children[i] != None and current.children[i].word != None:
                    queue.append(current.children[i])
        return current.word
