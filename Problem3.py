#Time complexity: O(n*l) + O(m*k) where n is the number of words in dictionary and l is average length of a word -> m is number of words in sentence and k is avg length of word
#Space complexity: O(n*l) + O(m*k)

#Accepted on Leetcode

#Approach:
#Create a Trie -> For each word in the sentence start iterating from starting of the trie and keep checking until a prefix found (or not found -> if not found add entire word else add prefix)


class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()


    def insert(self, word):
        root = self.root
        for char in word:
            charCode = ord(char) - ord('a')
            if root.children[charCode] == None:
                root.children[charCode] = TrieNode()
            root = root.children[charCode]
        
        root.isEnd = True

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        #construct a trie
        trie = Trie()
        for word in dictionary:
            trie.insert(word)

        #now check for prefix and form soln
        soln = []
        sentenceArr = sentence.split(' ')
        for word in sentenceArr:
            formedWordList = []
            root = trie.root
            for char in word:
                if root.isEnd:
                    break
                charCode = ord(char) - ord('a')
                if root.children[charCode] == None:
                    break
                formedWordList.append(char)
                root = root.children[charCode]
            
            if root.isEnd:
                soln.append(''.join(formedWordList))
            else:
                soln.append(word)
        

        return ' '.join(soln)

                

         


        