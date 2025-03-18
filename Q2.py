############# Longest Word in Ddictionary

# Time Complexity :  Insert -> O(n), getLongest -> O(n)
# Space Complexity : O(26*h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Using a trie add all the elements to a trie and find longest based on the height using bfs.

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_complete = False
    
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def add_word(self,word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.is_complete = True

    
    def get_all_longest(self):
      queue = []
      for k in "abcdefghijklmnopqrstuvwxyz":
            if k in self.root.children:
                queue.append((self.root.children[k],k))

      max_len = -1
      word = ""
      while queue:
        elem, path = queue.pop(0)
        if elem.is_complete:
            if len(path) > max_len:
                max_len = len(path)
                word = path
        
            for c in "abcdefghijklmnopqrstuvwxyz":
                if c in elem.children:
                    queue.append((elem.children[c],path+c))
      return word
        


class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        trie = Trie()
        for word in words:
            trie.add_word(word)
        return trie.get_all_longest()
