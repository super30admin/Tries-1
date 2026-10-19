# Time Complexity : O(S)
# Space Complexity : O(S)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# First Approach using Sorting and HashSet
# Check if the word len is 1 or if except the last letter is in set then check len of longest is smaller then update the longest to word and add it to valid
# Second Approach is using Trie
# We insert all words into Trie and mark the end of each word as True
# We will traverse the Trie by going over each word in dictionary and check if for each node the isEnd is True if not then set isValid to False and break
# Check if isValid is True and compare length of longest with word and if the length is same check word < longest then update longest to word


class Solution:
    def longestWord(self, words: list[str]) -> str:
        valid = set()
        longest = ""
        words.sort(key=lambda word:(len(word), word))
        for i in range(len(words)):
            if len(words[i]) == 1 or words[i][:-1] in valid:
                if len(longest) < len(words[i]):
                    longest = words[i]
                valid.add(words[i])
        return longest

#Time: O(N log N + S), where N is the number of words and S is the total number of characters.
#Space: O(S) for the valid set and sorting overhead.

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        currentNode = self.root
        for ch in word:
            if ch not in currentNode.children:
                currentNode.children[ch] = TrieNode()
            currentNode = currentNode.children[ch]
        currentNode.isEnd = True

        

class Solution:
    def longestWord(self, words: list[str]) -> str:
        longest = ""
        trie = Trie()
        for word in words:
            trie.insert(word)
        for word in words:
            currentNode = trie.root
            isValid = True
            for ch in word:
                currentNode = currentNode.children[ch]
                if not currentNode.isEnd:
                    isValid = False
                    break
            
            if isValid and (len(longest) < len(word) or (len(longest) == len(word) and word < longest)):
                longest = word
        return longest

#Time: O(S) expected — each word is inserted and traversed once.
#Space: O(S) — Trie storage.
