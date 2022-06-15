from collections import deque

# create a TrieNode
class TrieNode:
    
    def __init__(self):
        
        # list of characters
        self.charList = [None]*26
        
        # check for word
        self.isWord = False
        
        # prefixString
        self.prefixString = ""

class Trie:

    def __init__(self):
        self.root = None

    def insert(self, word: str) -> None:
        
        # 1. create an obj of class TrieNode i.e. base-check
        if self.root == None:
            
            # my dictionary of tries is empty
            # create an obj of class TrieNode and initialize it to the index
            objNewNode = TrieNode()
            self.root = objNewNode
            self.root.prefixString = None
        
        # 2. initialize a currentNode that iterates the trie
        currentNode = self.root
        
        # 3. iterate the "word" and mark it inside the trieNodes
        for char in word:
            
            # 3.1. get the corresponding index for the char
            '''ascii(char)-ascii(a)'''
            index = ord(char) - ord('a')
            
            # 3.2. if position is marked i.e. we already have this char in tries
            if currentNode.charList[index] == None:
                
                # create an obj of class TrieNode and initialize it to the index
                objNewNode = TrieNode()
                objNewNode.prefixString = char
                
                currentNode.charList[index] = objNewNode
            
            # 3.3. update the rfr of the currentNode
            currentNode = currentNode.charList[index]
        
        '''end of for loop'''
        # 4. my word is completed i.e. inserted into the trie
        currentNode.isWord = True
        
        '''Inserted successfully into the tries'''
        
class Solution:
    
    def __init__(self):
        self.resultList = None
    
    def dfsTraversal(self,currentNode,listChar):
        
        # logic-case
        # iterate "charList" from the last index
        for i in range(len(currentNode.charList)-1,-1,-1):
            
            if currentNode.charList[i] != None and currentNode.charList[i].isWord == True:
                
                # action
                listChar.append(currentNode.charList[i].prefixString)
                
                # recurse
                self.dfsTraversal(currentNode.charList[i],listChar)
                
                # backtrack
                listChar.pop()
        '''end of for loop'''
        
        # base-case
        if (self.resultList == None) or (self.resultList != None and len(self.resultList) <= len(listChar)):
            self.resultList = listChar[:]
        
        return
        
    def longestWord(self, words: List[str]) -> str:
        
        # 1. insert words into trie
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        '''inserted into trie'''
        
        # 2. initialize the currentNode to the root
        currentNode = trie.root
        
        # 3. dfs traversal 
        self.dfsTraversal(currentNode,[])
        
        # 4. print the resultList
        # print("ResultList is:\t",self.resultList)
        if self.resultList != None:
            sentence = ''.join(map(str, self.resultList))
            # print("Sentence is:\t",sentence)
            return sentence
        else:
            return ""