class TrieNode:
        # Initialize your data structure here.
        def __init__(self):
            self.isWord=False
            self.children={}
    
class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        currNode = self.root

        #Insert Word one by one
        for i in word:
            #If not present in children
            if i not in currNode.children:
                currNode.children[i] = TrieNode()
            #Shift the node to next char
            currNode = currNode.children[i]

        # At the end of everything -- mark the node as True (Word)
        currNode.isWord = True

    def search(self, word):
        if not self.startsWith(word):
            return False
        currNode = self.root
        #For every char in word
        for i in word:
            currNode = currNode.children[i]#currNode.next
        #As we are at the currNode -- which is the node which has the last word
        return currNode.isWord #We check if the currNode has the word or not

    def startsWith(self, prefix):
        currNode = self.root
        #For every char in word
        for i in prefix:
            #search if the children map has the keys present
            if i not in currNode.children:
                return False
            else: #Present
                currNode = currNode.children[i]#currNode.next
        return True