class TrieNode:
    def __init__(self):
        self.children = []
        self.word = ''
        for i in range(27):
            self.children.append(None)

class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            if  curr.children[ord(word[i]) - ord('a')] == None:
                curr.children[ord(word[i]) - ord('a')] = TrieNode()
            curr = curr.children[ord(word[i]) - ord('a')]           
        curr.word = word
            

    def longestWord(self, words: List[str]) -> str:

        for word in words:
            self.insert(word)
        
        queue = []
        curr = self.root
        queue.append(self.root)
        while(len(queue)>0):
            curr = queue.pop(0)
            for i in range(26,-1,-1):               
                if curr.children[i] is not None and  len(curr.children[i].word)!=0:
                    queue.append(curr.children[i])
                
        if curr.word is None:
            return ''
        return curr.word
