
# Time Complexity --> O(m*l1+n*l2) where m,n are the number of words in dictionary and sentence respectively and l1, l2 are the average lengths of words in dictionary and sentence respectively
# Space Complexity --> O(m*l1+n*l2)
# Approach --> Place all the words from dcitionary into a Trie and then search for a prefix of words from sentence. If prefix is available then replace the actual word with prefix. 
class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False

class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for char in word:
            index = ord(char)-ord('a')
            if curr.children[index] is None:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        for word in dictionary:
            self.insert(word)
        strarr = sentence.split(' ')

        result = ''
        for i in range(len(strarr)):
            word = strarr[i]
            if i>0:
                result += ' '
            curr = self.root
            replacement = ''

            for char in word:
                index = ord(char)-ord('a')
                if curr.children[index] is None or curr.isEnd==True:
                    break
                replacement += char
                curr = curr.children[index]
            if curr.isEnd==True:
                result += replacement
            else:
                result += word
        
        return result 
