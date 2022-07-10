#Time complexity : O(L) for inserting, searching and prefix search
#Space complexity : O(1) as all operations are 
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=C8VRMbEgOqc&ab_channel=%7BS30%7D
#creating a new class for creating a Tri of 26 children for each alphabet and isEnd for marking the end of the words
class TrieNode:
    #creating a constructor so that by default isend value is False and in array of children is by default None
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26
        
class Trie:
    #creating a root node of TrieNode
    def __init__(self):
        self.root = TrieNode()
    #creating an insertion function for putting a word in Trie
    def insert(self, word: str) -> None:
        #starting the check or insert from the root node
        current = self.root
        #iterating over all the alphabets of the given word to insert
        for i in range(len(word)):
            #storing the ith alphabet in c
            c = word[i]
            #fetching the index value to trive the index of the children by subtracting over the ascii values
            index = ord(c)-ord('a')
            #if we don't find the current alphabet in the tri then we will add a new object of trie on the corresponding root node or the current point index of the previous character
            if current.children[index] == None:
                current.children[index] = TrieNode()
            #if the current alphabet is already present then we will move the current point to the index of the children
            current = current.children[index]
        #once the word is inserted in the trie then it will mark isEnd as true at the last alphabet 
        current.isEnd = True
    #defining a function for seaching a word
    def search(self, word: str) -> bool:
        current = self.root
        for i in range(len(word)):
            c = word[i]
            index = ord(c)-ord('a')
            #if we don't find the current alphabet in the tri if we get none then we will return false and stop searching for other alphabet
            if current.children[index] == None:
                return False
            #if the current alphabet is found then we will go to that index for further searching another alphabet
            current = current.children[index]
        #if we found the word then we will return end because it might possible that given word is might be a prefix of existing word so instead of return true we will return the word end
        return current.isEnd
    
    #defining a function for searching a prefix
    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for i in range(len(prefix)):
            c = prefix[i]
            index = ord(c)-ord('a')
            #if we don't find the current alphabet in the tri if we get none then we will return false and stop searching for other alphabet
            if current.children[index]== None:
                return False
            current = current.children[index]
         #if we found the prefix then we will return true because it might possible that given prefix is a prefix of existing word so instead of returning word end we will retun True
        return True
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
