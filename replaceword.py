# Time Complexity : O(L) where L is the length of the words
# Space Complexity : O(N.L) where N is the number of words and L is the length of the words
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am first creating a TrieNode class which has an array of size 26 to store the children nodes and a boolean variable to mark the end of a word.
# I am then creating a Trie class which has a root node of type TrieNode.
# The init function initializes the root node.
# The insert function takes a word as input and inserts it into the trie. In such a way that each character of the word is a child node of the previous character.
# I walk through each character of the word and check if it is already present in the children array of the current node. 
# If it is not present, I create a new TrieNode and add it to the children array.
# I then move to the child node and repeat the process for the next character.
# Finally, I mark the end of the word by setting the EndOfWord variable to True.
# The longestWord function takes a list of words as input and finds the longest word in the trie such that all its prefixes are also present in the trie.
# I first insert all the words into the trie using the insert function.
# I splirt the sentence into words and for each word, I traverse the trie to find the shortest prefix that is also a word in the trie.
# I maintain a boolean variable to check if such a prefix exists.
# If it exists, I append the prefix to the answer list, otherwise I append the original word.
# Finally, I join the answer list into a string and return it.

from typing import List
class TrieNode():
    def __init__(self):
        self.arr = [None] * 26
        self.endOfWord = False

class Solution:
    def __init__(self):
        self.root = TrieNode()
    def insert(self,s:str):
        node = self.root
        for i in s:
            index = ord(i) - ord('a')
            if not node.arr[index]:
                node.arr[index] = TrieNode()
            node = node.arr[index]
        node.endOfWord = True
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for i in dictionary:
            self.insert(i)
        word = sentence.split()
        # print(word)
        ans = []
        for i in word:
            node = self.root
            pre = ''
            ifexsist = False
            for j in i:
                index = ord(j) - ord('a')
                if not node.arr[index]:
                    break
                node = node.arr[index]
                pre += j
                # print(j)
                if node.endOfWord:
                    ifexsist = True
                    break
            
            if ifexsist:
                ans.append(pre)
            else:
                ans.append(i)
        return " ".join(ans)

            