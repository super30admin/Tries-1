class TrieNode(object):

    def __init__(self):
        self.charNodes = [None for i in range(26)]
        self.isEnd = False


class Trie(object):

    def __init__(self):
        
        self.rootNode = TrieNode()

    def insert(self, word):
        
        currNode = self.rootNode

        for i in range(len(word)):
            currChar = word[i]
            if (currNode.charNodes[ord(currChar) - ord('a')] == None):      
                currNode.charNodes[ord(currChar) - ord('a')] = TrieNode()
            currNode = currNode.charNodes[ord(currChar) - ord('a')]
        currNode.isEnd = True                                               

    def search(self, word):

        currNode = self.rootNode

        for i in range(len(word)):
            currChar = word[i]
            if (currNode.charNodes[ord(currChar) - ord('a')] == None):      
                return False
            currNode = currNode.charNodes[ord(currChar) - ord('a')]
        return currNode.isEnd                                               
    
    def startsWith(self, prefix):
        currNode = self.rootNode

        for i in range(len(prefix)):
            currChar = prefix[i]
            if (currNode.charNodes[ord(currChar) - ord('a')] == None):      
                return False
            currNode = currNode.charNodes[ord(currChar) - ord('a')]
        return True                                                         
