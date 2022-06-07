
#Time Complexity of search and startss with O(l) => O(1) length of word for search or prefixsearch
#Space Complexity O(N)
#It successfully runs on leetcode 


#with 26 character list of children at each node
class TriNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isend = False
        
class Trie:
    def __init__(self):
        self.root = TriNode()
    
    def insert(self, word: str) -> None:
        cur = self.root
        
        for c in word:
            if cur.children[ord(c)-ord('a')]==None:
                cur.children[ord(c)-ord('a')]=TriNode()
            cur= cur.children[ord(c)-ord('a')]
        cur.isend = True

    def search(self, word: str) -> bool:
        cur = self.root
        for c in word:
            if cur.children[ord(c)-ord('a')]== None: return False
            cur = cur.children[ord(c)-ord('a')]
        return cur.isend
        

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for c in prefix:
            if cur.children[ord(c)-ord('a')] == None: return False
            cur = cur.children[ord(c)-ord('a')]
        return True

#with hashset

class TriNode:
    def __init__(self):
        self.children = {}
        self.isend = False
        
class Trie:

    def __init__(self):
        self.root = TriNode()
        

    def insert(self, word: str) -> None:
        cur = self.root
        for c in word:
            if c not in cur.children:
                cur.children[c]=TriNode()
            cur= cur.children[c]
        cur.isend = True

    def search(self, word: str) -> bool:
        cur = self.root
        for c in word:
            if c not in cur.children: return False
            cur = cur.children[c]
        return cur.isend
        

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for c in prefix:
            if c not in cur.children: return False
            cur = cur.children[c]
        return True