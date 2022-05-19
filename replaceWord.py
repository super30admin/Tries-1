#Time complexity -> O(nk) + O(ml) where n and m are size of dictionary and sentence
#Space complexity -> O(nk) + O(ml)
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = None
        
class Solution:
    def createTrie(self, dictionary):
        root = TrieNode()
        charA = ord('a')
        
        for word in dictionary:
            curr = root
            for i in range(len(word)):
                if curr.children[ord(word[i])-charA] == None:
                    curr.children[ord(word[i])-charA] = TrieNode()
                curr = curr.children[ord(word[i])-charA]
            
            curr.isEnd = True  
        return root
            
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        charA = ord('a')
        
        root = self.createTrie(dictionary)
        sentenceList = sentence.split(' ')
        res = ''
        
        for word in sentenceList:
            if res:
                res += ' '
            curr = root
            temp = ''
            for i in range(len(word)):
                if curr.children[ord(word[i])-charA] == None or curr.isEnd:
                    break
                temp += word[i]
                curr = curr.children[ord(word[i])-charA]
                
            if curr.isEnd == True:
                res += temp
            else:
                res += word                                    
                    
        return res