"""
Time Complexity: O(m*n)
Space Complexity: O(m*n)
Compiled on leetcode: Yes
"""
class TrieNode:
    def __init__(self, children, isEnd):
        self.children = children
        self.isEnd = isEnd
        
class Solution:
    def __init__(self):
        self.root = TrieNode(dict(), False)
        
        
    def insertWordsInTrie(self, word):
        current = self.root
        for letter in word:
            if letter not in current.children:
                current.children[letter] = TrieNode(dict(), False)
            current = current.children[letter]
        current.isEnd = True    
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
                self.insertWordsInTrie(word)
        
        newSentenceWordList = list()
        
        for word in sentence.split(" "):
            wordToAppend = ""
            current = self.root
            for letter in word:
                if letter not in current.children or current.isEnd:
                    break
                else:
                    wordToAppend += letter
                    current = current.children[letter]
            if current.isEnd and len(wordToAppend) > 0:
                newSentenceWordList.append(wordToAppend)
            else:
                newSentenceWordList.append(word)
        return " ".join(newSentenceWordList)        
                
        