class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.word = None

class Solution:
    def __init__(self):
        self.charA = ord('a')
    
    def insert(self, words):
        root = TrieNode()
        charA = self.charA
        for word in words:
            # print("word", word)
            curr = root
            for letter in word:
                if curr.children[ ord(letter) - charA ] == None :
                    curr.children[ ord(letter) - charA ] = TrieNode()
                curr = curr.children[ ord(letter) - charA ]
            curr.word = word
        return root
                    
    def longestWord(self, words: List[str]) -> str:
        if words == None or len(words) == 0:
            return ""
        charA = self.charA
        root = self.insert(words)
        root.word = ""
        # print( root.children )
        curr = root
        q = []
        q.append(curr)
        while q:
            curr = q.pop(0)
            # print("curr.children",curr.children)
            for i in range(25,-1,-1):
                # print( curr.children[i] )
                if curr.children[i] is not None and curr.children[i].word is not None:
                    # traverse n the resverse order of the lexiography and push all it's children 
                    # finally print the word at the last level. 
                    q.append(curr.children[i])
        return curr.word
            
            
