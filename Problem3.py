#Replace Words

# Create Trie based dictioary to store dictionary, then iterate over the sentence words and for each for find the root/prefix
# If found any return that and replace in the statament

# Space - > max of (O(NxLd) or O(MxLs)) avg length of all the input words in the dictionary of the total number of chars in the sentence
# Time -> O(MxLs)) for each word of the sentence each character has to be iterated in worst case. 


from typing import List


class Trie:
    
    def __init__(self):
        self.charDict = {}
        self.isEnd = False

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trieDict = Trie()
        def insert(word):
            currentNode = trieDict
            for char in word:
                currNodeDict = currentNode.charDict
                if char not in currNodeDict:
                    currNodeDict[char] = Trie()
                
                currentNode = currNodeDict[char]
            currentNode.isEnd = True

        def findRootWord(word):
            path = []
            currentNode = trieDict
            for char in word:
                currNodeDict = currentNode.charDict
                if char in currNodeDict:
                    path.append(char)
                else:
                    break
                currentNode = currNodeDict[char]
                if currentNode.isEnd:
                    return "".join(path)
            
            return word


        for word in dictionary:
            insert(word)
        sentenceWords = sentence.split(" ")
        for index in range(len(sentenceWords)):
            word = sentenceWords[index]

            sentenceWords[index] = findRootWord(word)
        return " ".join(sentenceWords)

