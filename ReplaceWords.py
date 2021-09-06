"""
Time Complexity : O(n*k) where n is the no. of words in dictionary and k is the average length
Space Complexity : O(n) where n is the number of words
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class TrieNode:
    def __init__(self, char=""):
        self.char = char
        self.children = {}
        self.isEnd = False
class Solution:
    def __init__(self):
        self.root = TrieNode()
    # Insert method to insert the words in the Trie
    def insert(self, word):
        curr = self.root
        for char in word:
            if char not in curr.children:
                newNode = TrieNode(char)
                curr.children[char] = newNode
                curr = newNode
            else:
                curr = curr.children[char]
        curr.isEnd = True
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if len(sentence) == 0:
            return sentence
        self.root = TrieNode()
        # Insert the word in the trie 
        for word in dictionary:
            self.insert(word)
        # Split the sentence words to check if they are in dictionary or not
        sentenceWords = sentence.split(" ")
        replacedWords = ""
        # Loop through the words and see if you find any match if found
        # add it to the new string sentence for replcaement
        for word in sentenceWords:
            replacement = ""
            curr = self.root
            for char in word:
                if char not in curr.children or curr.isEnd: break
                replacement += char
                curr = curr.children[char]
            if(curr.isEnd) :
                replacedWords += replacement+" "
            else:
                replacedWords += word+" "
        return " ".join(replacedWords.split())
                    
        