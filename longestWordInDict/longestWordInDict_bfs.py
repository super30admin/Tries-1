'''
Time Complexity: 0(levels)
Space Complexity: 
'''

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
                
                # case: not a root
                if currentNode.prefixString != None:
                    objNewNode.prefixString = objNewNode.prefixString +currentNode.prefixString + char
                # case: root case
                else:
                    objNewNode.prefixString = objNewNode.prefixString + char
                currentNode.charList[index] = objNewNode
            
            # 3.3. update the rfr of the currentNode
            currentNode = currentNode.charList[index]
        
        '''end of for loop'''
        # 4. my word is completed i.e. inserted into the trie
        currentNode.isWord = True
        
        '''Inserted successfully into the tries'''
        
class Solution:
    
    def longestWord(self, words: List[str]) -> str:
        
        # 1. insert words into trie
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        '''inserted into trie'''
        
        # 2. initialize the currentNode to the root
        currentNode = trie.root
        
        # 3. bfs traversal to find longestWord in the dict
        queue = deque([])
        queue.append(currentNode)
        
        # 4. iterate the queue
        while len(queue) != 0:
            # 4.1. pop from the queue
            currentNode = queue.popleft()
            
            # 4.2. chk for the prefixString from behind
            for i in range(len(currentNode.charList)-1,-1,-1):
                
                # 4.2.1. chk the boolean value
                if currentNode.charList[i] != None and currentNode.charList[i].isWord == True:
                    queue.append(currentNode.charList[i])
            '''end of for loop'''
            
        '''end of while loop'''
        
        # 5. my currentNode is at the longestWord position
        # print("longest word is:\t",currentNode.prefixString)
        if currentNode.prefixString != None:
            return currentNode.prefixString
        return ""
        