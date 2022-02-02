# // Time Complexity : O(mk +nl) where n is the length of the dictionary, l is the average length of a word, m is the length of the sentence and K is average word in a sentence.
# // Space Complexity : O(nl) where n is the length of the dictionary and l is the average length of a word.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Node:

    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if curr.children[ord(i) - ord('a')] == None:
                curr.children[ord(i) - ord('a')] = Node()
            curr = curr.children[ord(i) - ord('a')]
        curr.isEnd = True

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        sentence_list = sentence.split()
        result = ""
        for t,word in enumerate(sentence_list):
            if t != 0:
                result += " "
            curr = trie.root
            temp = ""
            for i in word:
                if curr.children[ord(i) - ord('a')] == None or curr.isEnd:
                    break
                temp += i
                curr = curr.children[ord(i) - ord('a')]
                
            if curr.isEnd:
                result += temp
            else:
                result += word
        return result
