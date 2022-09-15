# TC : O(length of sentence)
# SC : O(words in dictionary)
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
       
    def getRoot(self):
        return self.root
    
        
    def insert(self,word):
        curr = self.root
        print("root",curr.children,curr.isEnd)
        for char in word:
            key = ord(char) - ord('a')
            if curr.children[key] == None:
                curr.children[key] = TrieNode()
            print(curr.children,curr.isEnd)
            curr = curr.children[key]
        curr.isEnd = True 
        print("last node",curr.children,curr.isEnd)
        
            

class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        trie = Trie()
        
        for prefixwords in dictionary:
            trie.insert(prefixwords)
            
        resultstr=[]
        sentence = sentence.split()
        for word in sentence:
            curr = trie.getRoot()
            currword = ""
            for char in word:
                keychar = ord(char) - ord('a')
                if curr.children[keychar]==None or curr.isEnd == True:
                    #currword +=char
                    break
                currword +=char
                curr = curr.children[keychar]
            if curr.isEnd == True:
                resultstr.append(currword)
                
            else:
                resultstr.append(word)
                
                
        return " ".join(resultstr)