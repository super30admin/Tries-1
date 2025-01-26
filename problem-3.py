# Time Complexity : O(m*n + k*l), m is the no of words in the sentence, n is the avg length of each word. k is the no fo words in dictionary and l is the length of each word

# space complexity : O(m + kl), m is the length of the array and kl is the space for traversing the dictionary

# Approach :

# create a list and and string for storing the words
# first insert the words in a tried node
# iterate over each word and in each word check the trienode for characters
# if the substring is present in the trienode, add it to the string and append it in the array
# if not append the original word in the array
# finally convert the array to a string

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [0 for i in range(26)]


class Solution:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):

        self.current = self.root

        for i in range(len(word)):
            if not self.current.children[ord(word[i]) - ord("a")]:
                self.current.children[ord(word[i]) - ord("a")] = TrieNode()
            self.current = self.current.children[ord(word[i]) - ord("a")]

        self.current.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        for word in dictionary:
            self.insert(word)

        stringArr = sentence.split(" ")
        newStr = []

        for word in stringArr:

            stringBuild = ""
            trieRoot = self.root

            for char in word:
                if not trieRoot.children[ord(char) - ord("a")] or trieRoot.isEnd:
                    break
                stringBuild = stringBuild + char
                trieRoot = trieRoot.children[ord(char) - ord("a")]

            if trieRoot.isEnd:
                newStr.append(stringBuild)
            else:
                newStr.append(word)

        finalStrArr = " ".join(newStr)

        return finalStrArr
