from collections import defaultdict
class Node:
    def __init__(self, val):
        self.val = val
        self.child = defaultdict(Node)
        self.end = False

class Trie:
    def __init__(self):
        self.root = Node(None)
    
    def insert(self, word):
        root = self.root
        for ch in word:
            if ch not in root.child:
                root.child[ch] = Node(ch)
            root = root.child[ch]
            self.val = ch
        root.end = True

class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        def dfs(node, path):
            if not node.end:
                return
            if len(path) > len(self.ret) or (len(path) == len(self.ret) and "".join(path) < self.ret):
                self.ret = "".join(path)
            for letter in node.child:
                dfs(node.child[letter], path+[letter])
        words.sort()
        trie = Trie()
        trie.root.end = True
        for word in words:
            trie.insert(word)
        self.ret = ""
        dfs(trie.root, [])
        return self.ret