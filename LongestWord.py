# Time Complexity : O(N)  //Where n is the size of the array
#  Space Complexity : O(H)  //Recursive stack for the tree
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Node:
    #Declare the components required for trie and insert function as well
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = Node()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for w in word:
            if w not in curr.children:
                curr.children[w] = Node()
            curr = curr.children[w]
        
        curr.isEnd = True
class Solution:
    def longestWord(self, words: List[str]) -> str:
        #Initialize Trie
        trie = Trie()
        
        #insert the words in Trie
        for word in words:
            trie.insert(word)
            
        def longestPath(node, path):
            #Decare length of the word and the total words
            maxPathLen, maxPath = len(path), path
            #Iterate over the alphabets if that is the matched alphabet then return the maxPath else continue, we need to split the char and then join and return them as string
            for i in range(26):
                letter = chr(ord('a') + i) 
                child = node.children.get(letter, None)
                if not child or not child.isEnd:
                    continue
                
                currPath = longestPath(child, path + [letter])
                
                if len(currPath) > maxPathLen:
                    maxPathLen = len(currPath)
                    maxPath = currPath
                    
            return maxPath

        maxPath = longestPath(trie.root, [])

        return "" if not maxPath else "".join(maxPath)