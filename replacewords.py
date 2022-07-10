#Time complexity : O(n*L + m*L) for iterating over all the n words in sentence over L length of word and inserting the strings of dictionary in the Trie
#Space complexity : O(nl + ml) for storing the m strings of dictionary in the Trie and nl for storing the given sentence in form of words
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=C8VRMbEgOqc&ab_channel=%7BS30%7D
#creating a new class for creating a Tri of 26 children for each alphabet and isEnd for marking the end of the words
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
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        #storing the list of given words of dcitionary in the Trie
        #creating a Trie first
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        #creating a result as a stringbuilder
        result = ""
        #converting the sentance in form of array 
        strArray = sentence.split(" ")
        #iterating over all the words
        for k in range(len(strArray)):
            word = strArray[k]
            #creating new string builder for storing the replacement coming one by one alphabet from the trie
            replacement =""
            #creating current as an object of the TrieNode for going over the trie
            current = TrieNode()
            current = trie.root
            #iterating over the current word in the trie for searching the replacement
            for i in range(len(word)):
                #storing the current character i 
                c = word[i]
                #storing the index of the current character
                index = ord(c)- ord("a")
                #there are two conditions for coming out of the loop
                #1 if there is no replacement found
                #2 if we find the smallest prefix then we break the loop
                if current.children[index]== None or current.isEnd:
                    break
                #keep adding the shortest string we get in the replacement
                replacement += c
                #further if we found the character then we will go to the chidren
                current = current.children[index]
            #if we find the match of substring then we will replace it
            if current.isEnd:
                result += replacement
            else:
                result += word
            if k<len(strArray)-1:
                result += " "
        
        return result
