class TrieNode:
    def __init__(self):
        self.child = {}
        self.isEnd = False
        self.word = ''

class Solution:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, wrd: str):
        cur = self.root
        for i in wrd:
            if i not in cur.child:
                cur.child[i] = TrieNode()
            cur = cur.child[i]
        cur.isEnd = True
        cur.word = wrd
    
    def longestWord(self, words: List[str]) -> str:
        st = ''
        queue = []
        queue.append(self.root)
        for i in words:
            self.insert(i)
        while(len(queue)!=0):
            curr =  queue.pop(0)
            for i in curr.child.values():
                if i.isEnd is True:
                    queue.append(i)
                    if(len(i.word)>len(st) or i.word<st):
                        st = i.word
        return st
                        
        
        