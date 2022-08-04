# Time complexity:O(nl)- n is no.of.words, l is average length of each word
# space complexity: O(nl)
# Approach: create a trie by inserting all the words, h=and have a string in the end of each word like we do isEnd
# BFS: initiate a queue and add the root of trie
# pop from queue
# keep adding the popped node's children whenever the children is not none and word exists in the string.
# but do this insertion of children from last children-like z to a and not a to z
# this is to preserve lexogrpahical order mentioned in the question
# return the last popped element's string.


class Trienode:
    def __init__(self):
        self.children = [None]*26
        self.string = ""
class Trie:
    def __init__(self):
        self.root = Trienode()
    def insert(self,word):
        curr = self.root
        for char in word:
            ci = ord(char)-ord('a')
            if curr.children[ci]== None:
                curr.children[ci]=Trienode()
            curr = curr.children[ci]
        curr.string = word
        
    
class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        q = []
        q.append(trie.root)
        while q:
            curr = q.pop(0)
            for i in range(25,-1,-1):
                if curr.children[i] != None and curr.children[i].string is not "" :
                    q.append(curr.children[i])
        return curr.string
            
        