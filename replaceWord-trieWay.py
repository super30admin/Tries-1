'''
Time: 0(1) -- for trie structure to iterate 
      0(n*k) -- where n is iterating the successor and k is iterating the root
Space: 0(k) -- build trie
Ran on leetcode: Yes 
'''
class TrieNode:
    
    def __init__(self):
        self.trieList = [None] * 26
        self.isaword = False

class Trie:
    
    def __init__(self):
        self.root = None
    
    def insert(self,word):
        
        # base-case
        # 1. Initialize it to the root if its None
        if self.root == None:
            objNewNode = TrieNode()
            self.root = objNewNode
        
        # logic-case
        # 2. Initialize the 'currentPtr' to the 'root'
        currentPtr = self.root
        
        # 2. Iterate the 'word' char by char and initilze the "trieList[index]" with a "trieNode"
        for char in word:
            
            # 2.1. get the index position i.e. index = ascii('char') - ascii('a')
            index = ord(char) - ord('a')
            
            # 2.2. go-to the trieNode.trieList[index] position and initialize the new "trieNode"
            if currentPtr.trieList[index] == None: 
                # initialize a trie-node
                objNewNode = TrieNode()
                
                # update the currentPtr.trieList[index] to the newNode
                currentPtr.trieList[index] = objNewNode
            
            # 2.3. update the "currentPtr" rfr 
            currentPtr = currentPtr.trieList[index]
        '''end of for-loop'''
        
        # 3. update the currentPtr.flag from False to True
        currentPtr.isaword = True
    
    def searchSpecific(self,char,node):
        
        # 1. initialize the currentNode rfr
        currentNode = node
        
        # 2. chk for the char and return
        
        # 2.1. cal index
        index = ord(char) - ord('a')
        
        # 2.2. check the currentNode
        if currentNode.trieList[index] != None:
            return currentNode.trieList[index]
        
        else:
            return None       
        
class Solution:
    def replaceWords(self, dictionary, sentence):
        
        # convert dictionary into a trie tree structure
        trie = Trie()
        for root in dictionary:
            trie.insert(root)
        
        # iterate the successor in a sentence
        
        # convert sentence into list
        sentence = sentence.split(" ")
        
        # finalResultString
        returnString = ""
        
        for successor in sentence:
            
            # initialize currentPtr to the trie.root
            currentPtr = trie.root
            
            # create a subString
            subString = ""
            
            # iterate the succesor char-by-char
            for char in successor:
                
                # search in trie
                currentPtr = trie.searchSpecific(char,currentPtr)
                
                # check if currentPtr return
                if currentPtr != None:
                    
                    # add char to the subString
                    subString = subString + char
                    
                    # chk flag 
                    if currentPtr.isaword == True:
                        # I have my subString
                        break
                    
                    else:
                        continue
                else:
                    break
            
            # chk if we can replace successor with subString
            if currentPtr != None and currentPtr.isaword == True:
                returnString = returnString + subString + ' '
            else:
                returnString = returnString + successor + ' '
        
        # return the final string
        #print("Return sentence is:\t",returnString[:-1])
        return returnString[:-1]

#sol = Solution()
#sol.replaceWords(["cat"], "cattle")