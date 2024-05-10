"""

!!!!!!!!!!!!!!!!!!!!!! BFS NOT DONE YET !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

"""
class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.is_end = False

    class Trie:
        def __init__(self):
            self.root = self.getNode()
        
        def getNode(self):
            return Solution.TrieNode()
        
        def insert(self, root, word):
            w_len = len(word)
            p_crawl = root
            for i in range(w_len):
                ind = ord(word[i]) - ord('a')
                if p_crawl.children[ind] == None:
                    p_crawl.children[ind] = self.getNode()
                p_crawl = p_crawl.children[ind]
            p_crawl.is_end = True


    # # DFS Solution:
    # def longestWord(self, words: List[str]) -> str:
    #     trie = self.Trie()
    #     root = trie.root
    #     for i in range(len(words)):
    #         trie.insert(root, words[i])
    #     self.res = ""
    #     self.backtrack(root, "")
    #     return self.res
    
    # def backtrack(self, node, path):
    #     # Base 
    #     if len(path) > len(self.res):
    #         self.res = path
    #     # Logic
    #     for i in range(26):
    #         if node.children[i] != None and node.children[i].is_end:
    #             # Action
    #             char = chr(i + ord('a'))
    #             path += str(char)

    #             #Recurse
    #             self.backtrack(node.children[i], path)

    #             # Backtrack
    #             path = path[:-1]