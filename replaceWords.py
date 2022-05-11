class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Solution:
    
    def insert(self, dictionary):
        root = TrieNode()
        charA = ord('a')
        for word in dictionary:
            curr = root
            for letter in word:
                if curr.children[ord(letter)-charA] == None:
                    curr.children[ord(letter)-charA] = TrieNode()
                curr = curr.children[ord(letter)-charA]
            curr.isEnd = True
        # print(root.children)
        return root
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        sentenceList = sentence.split(" ")
        root = self.insert( dictionary )
        # print(root.children)
        charA = ord('a')
        res = ""
        for word in sentenceList:
            if res:
                res += " "
            curr = root
            temp = ""
            for letter in word:
                # print(word)
                if curr.children[ord(letter)-charA] == None or curr.isEnd:
                    break 
                temp += letter
                curr = curr.children[ord(letter)-charA] 
                
            if curr.isEnd == True:
                res += temp
            else:
                res += word
        return res 
    
