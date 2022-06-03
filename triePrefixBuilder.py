'''
Time: 0(k) -- for trie structure to iterate
      0(k) -- for insert a string
      
Space: 0(n) -- build trie

Ran on leetcode: Yes 
'''
class TrieNode:
    
    def __init__(self):
        self.trieList = [None] * 26
        self.endOfWord = False
        
class Trie:

    def __init__(self):
        self.root = None

    def insert(self, word: str) -> None:
        
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
        currentPtr.endOfWord = True

    def search(self, word: str) -> bool:
        
        # base-case
        if self.root == None:
            # empty Trie
            return False
        
        # logic-case
        # 1. initialize "currentPtr" to root
        currentPtr = self.root
        
        # 2. iterate the word to check if it exist
        flagResult = True
        for char in word:
            
            # 2.1. get the index
            index = ord(char) - ord('a')
            
            # 2.2. check the object in index position
            if currentPtr.trieList[index] != None:
                
                # 2.2.1. update the currentPtr and continue
                currentPtr = currentPtr.trieList[index]
                continue
            
            else:
                flagResult = False
                break
        
        # 3. return result
        if (flagResult == False) or (flagResult != False and currentPtr.endOfWord == False):
            return False
        
        else:
            return True

    def startsWith(self, prefix: str) -> bool:
        
        # base-case
        if self.root == None:
            # empty Trie
            return False
        
        # 1. Initialize the currentPtr
        currentPtr = self.root
        
        # 2. Iterate the prefix
        for char in prefix:
            # 2.1. cal index position
            index = ord(char) - ord('a')
            
            # 2.2. chk the index
            if currentPtr.trieList[index] == None:
                # We don't have this prefix
                return False
            
            else:
                currentPtr = currentPtr.trieList[index]
                continue
        '''out of for-loop'''
        
        # default return as true
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)