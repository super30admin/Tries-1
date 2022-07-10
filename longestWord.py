#Approach : DFS but BFS is also possible
#Time complexity : O(2nl) for inserting n words with length l and backtrack is done on the trie itself
#Space complexity : O(nl) for storing n words of length l in trie 
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=gmLBi4J906A&ab_channel=%7BS30%7D
#creating class TrieNode and creating insert function for putting the words in Trie
class TrieNode:
    def __init__(self):
        self.isEnd = False 
        self.children = [None]*26

class Solution:
    
    def insert(self, word:str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            index = ord(c)-ord('a')
            if curr.children[index] == None:
                curr.children[index]=  TrieNode()
            curr = curr.children[index]
        curr.isEnd = True
    def __init__(self):
        #defining the gobal variable maxStr as a stringbuilder for storing the maximum length string
        self.maxStr = ""
        self.root = TrieNode()
    def longestWord(self, words: List[str]) -> str:
        #creating a root node of the trienode for putting the elements in the Trie
        #root = TrieNode()
        #curr = Trie()
        #inserting the words in trie
        for word in words:
            self.insert(word)
        #calling the backtrack function
        self.backtrack(self.root, [])
        return self.maxStr
    def backtrack(self, curr, currStr):
        #base condition
        if len(currStr) > len(self.maxStr):
            #here we are appending all the characters in the list with the help of join function
            self.maxStr = ''.join(currStr)
            print(self.maxStr)
            print("currStr",currStr)
        #logic
        #starting from root checking over all the childrens is there any children present if yes then it will go futher with the next children
        for i in range(26):
            #storing the length of the initial string for the backtracking after the action is done
            #le = len(currStr)
            #checking the children is present and if the children isEnd is true then only we will move further for backtrack
            if curr.children[i] != None and curr.children[i].isEnd:
                #action
                #we are typecasting the current index from the ascii value
                character = i+ord('a')
                currStr.append(chr(character))
                #recurse
                self.backtrack(curr.children[i], currStr)
                #backtrack
                currStr.pop()
        
