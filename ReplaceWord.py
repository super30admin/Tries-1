'''
time complexity: O(n), n is len of sentence
space complexity: o(n)
'''
class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isWord = False
class Trie:

            
    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root
        for w in word:
            if curr.children[ord(w)-ord('a')] == None:
                curr.children[ord(w)-ord('a')] = TrieNode()
            curr = curr.children[ord(w)-ord('a')] 
        curr.isWord = True
        
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        tr = Trie()
        for word in dictionary:
            tr.insert(word)
        strArr = []
        sentArr = sentence.split(" ")
        for word in sentArr:
            if(word==' '): continue
            curr = tr.root
            replace = ""
            
            for w in word:

                if(curr.children[ord(w)-ord('a')]==None or curr.isWord==True): break
                replace+=w
                curr = curr.children[ord(w)-ord('a')]
            if(curr.isWord==True):
                strArr.append(replace)
            else:
                strArr.append(word)
        return " ".join(strArr)
                
        