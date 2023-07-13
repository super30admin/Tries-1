'''
Problem: Longest Word in Dictionary
Time Complexity: O(nl), where n is words and l is length of each word
Space Complexity: O(nl), for trie
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        store every word in trie
        then apply BFS and check children from reverse
        whenever child has isEnd true, append to queue
        simultaneously append curr string to queue.
'''

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Solution:
    def insert(self, root, word):
        curr = root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx]==None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True

    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        for word in words:
            self.insert(self.root, word)
        
        q1 = deque() #for TrieNode
        q2 = deque() #for strings

        q1.append(self.root)
        currstr = ''
        q2.append('')
        while q1:
            curr = q1.popleft()
            currstr = q2.popleft()
            for i in range(25, -1, -1 ):
                child = curr.children[i]
                if child != None and child.isEnd == True:
                    q1.append(child)
                    print(i)
                    newstr = currstr+chr(ord('a') + i)
                    q2.append(newstr)
        
        return currstr