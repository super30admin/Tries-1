#  Time Complexity : O(N * L)
#  Space Complexity : O(N * L) -> where N is the number of words and L is the length of the words
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code builds a Trie from the given words and then uses BFS to find the longest word such that all its prefixes are also valid words. Each word is inserted into the Trie, with isEnd marking the completion of a word, and BFS explores nodes level by level, only following children that represent complete words. By traversing from 'z' to 'a', BFS ensures lexicographical order preference, and the final currStr from the last valid path becomes the longest word.


class Solution:
    def longestWord(self, words: List[str]) -> str:
        class TrieNode:
            def __init__(self):
                self.isEnd = False
                self.children = [0] * 26
        
        def __init__(self):
            self.root = self.TrieNode()
            self.result = ""
        
        def insert(self, root):
            curr = self.root
            for c in word:
                idx = ord(c) - ord('a')
                if curr.children[idx] is None:
                    curr.children[idx] = self.TrieNode()
                curr = curr.children[idx]
            curr.isEnd = True 

        def longestWord(self, words):
            for word in words:
                self.insert(word)

            self.bfs(self.root)
            return self.result

        def bfs(self, node):
            currStr = ""
            q = deque()
            strQ = deque()

            q.append(self.root)  
            strQ.append(currStr)

            while q:
                curr = q.popleft()
                currStr = strQ.popleft()

                for i in range(25, -1, -1):
                    child = curr.children[i]
                    if child and child.isEnd:
                        q.append(child)
                        strQ.append(currStr + chr(i + ord('a')))

            self.result = currStr  