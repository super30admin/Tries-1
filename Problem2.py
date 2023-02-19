# Time Complexity :- O(nl + mk) where n is words in dict and l is avergae length of word and m is lenght of sentence and k is avg length of word in sentence
# Space Complexity :- O(nl + mk) where n is words in dict and l is avergae length of word and m is lenght of sentence and k is avg length of word in sentence

class TrieNode:
    def __init__(self) :
        self.children = {}
        self.isEnd = False


class Solution:

    def __init__(self):
        self.root =  TrieNode()
        

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        words = sentence.split()
        print(words)
        self.createTrie(dictionary)
        self.changeWords(sentence)
        return (' ').join(words)
        
    def createTrie(self, dictionary):       
        for word in dictionary:
            curr  = self.root
            for letter in word:
                if letter not in curr.children[letter]:
                    curr.children[letter] = TrieNode()
                curr = curr.children[letter]
            curr.isEnd = True
    
    def changeWords(self, words):
        for i in range(len(words)):
            curr = self.root
            newWord = ''
            for j in range(len(words[i])):
                if words[i][j] not in curr.children[words[i][j]]:
                    break
                else:
                    newWord += words[i][j]
                    curr = curr.children[words[i][j]]
            if curr.isEnd:
                words[i] = newWord


