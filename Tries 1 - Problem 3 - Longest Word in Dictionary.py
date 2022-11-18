"""
FAANMG Problem #78 {Easy} 

720. Longest Word in Dictionary

Time complexity : O(n*l)
Space complexity : O(n*l)

        
Did this code successfully run on Leetcode : Yes


Approach --
BFS


@name: Rahul Govindkumar_RN27JUL2022
"""



from collections import deque

# define the TrieNode class and add a word at the end of each TrieNode
class TrieNode():
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]
        self.word = ""

class Solution:
    # insert the words from dict into TrieNode
    def insert(self, word):
        
        curr = self.root
        for ch in word:
            if curr.children[ord(ch) - ord('a')] == None:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        curr.isEnd = True
        curr.word = word

    def longestWord(self, words: List[str]) -> str:
        self.root = TrieNode()
        # Insert the words into TrieNode
        for word in words:
            self.insert(word)

        # insert the root into queue
        q = deque([self.root])
        
        while q:
            # remove the root from the queue
            curr = q.popleft()
            
            # traverse from 25 till 0, so that we have the last word which is lexicographically correct
            for i in range(25,-1,-1):
              # check if the children of curr is not None and also that the isEnd flag is True
                if curr.children[i] != None and curr.children[i].isEnd:
                    # append those elements into the queue
                    q.append(curr.children[i])
        # at the end, we would just have one word remaining, return the complete word
        return curr.word
    

"""

Time complexity : O(n * l)
Space complexity : O(n * l)



Approach --
Backtrack


@name: Rahul Govindkumar_RN27JUL2022
"""

# define TrieNode class having a flag and a boolean array of length of 26 chars
class TrieNode():
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]

class Solution:
    def longestWord(self, words: List[str]) -> str:
        # we define a root node as TrieNode
        self.root = TrieNode()
        self.res = ""
        # for each word in the dictionary, we built it using the TrieNode
        for word in words:
            self.insert(word)
        # then we call the helper function to find out the longest word
        self.helper(self.root,"")
        # return the longest word found in the trie
        return self.res

    def insert(self, word):
        curr = self.root
        for ch in word:
            # check if the character is present in the trie, if so then move to that character on the next level
            if curr.children[ord(ch) - ord('a')] == None:
                # if not then create a trie node at that level for that character
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        # after the word has ended, just mark the flag as True to mark it in Trie
        curr.isEnd = True

    def helper(self, root, string):
        # base
        # if the lenght of the current string is more than the res we have so far, just put the string into result
        if len(string) > len(self.res):
            self.res = string
        # logic
        # tarverse over all the 26 characters and check if the char is present, if so then use dfs to fing the longest length of the word seen so far
        for i in range(26):
            child = root.children[i]
            # if the child is not None which means that there is a word formed using this, and also flag is True, as we need to make the longest word
            # which is built from the string in the dict
            if child != None and child.isEnd:
                # action
                # add the character to the string
                string += chr(ord('a') + i)

                # recurse
                # recursively call the function with the child of the current TrieNode
                self.helper(child, string)

                # backtrack
                # remove the character which was added last to continue the path ahead
                string = string[:-1]


