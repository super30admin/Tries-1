----------------------------------Longest Word -------------------------------------
# Time Complexity : O(NXL) N is the words in words list, L is the average length of each word.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have used array to implement trie data-structure. I have created a trie will all the given words by creating new array in the 
#index of ascii number of the character. Once we create a trie, we will process each and every node with its children node in reverse lexicographical order, so that
#the last word we get will be the first in ascending lexicographical order.


class TrieNode(object):
    def __init__(self):
        self.children= [None]*26
        self.word = None

        
class Trie(object):
    def __init__(self):
        self.root=TrieNode()
        
    def insert(self, word):
        node=self.root
        for c in word:
            if node.children[ord(c)-ord('a')] == None:
                node.children[ord(c)-ord('a')] = TrieNode()
            node = node.children[ord(c)-ord('a')]
        node.word=word

    
    def bfs(self):
        node = self.root
        q=collections.deque([node])
        count= 0
        while q:
            curr=q.popleft()
            for n in range(25, -1, -1):
                if curr.children[n] != None and curr.children[n].word != None:
                    q.append(curr.children[n])
        return curr.word
    
class Solution(object):
    def longestWord(self, words):
        trie = Trie()
        for w in words: trie.insert(w)
        return trie.bfs()
        
        
        
        
            
            
            
        
        
        
            