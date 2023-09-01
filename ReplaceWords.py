class TrieNode(object):

    def __init__(self):
        self.children = [None for i in range(26)]
        self.word = None


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):

        currNode = self.root

        for i in range(len(word)):
            currChar = word[i]
            if (currNode.children[ord(currChar) - ord('a')] == None):
                currNode.children[ord(currChar) - ord('a')] = TrieNode()
            currNode = currNode.children[ord(currChar) - ord('a')]

        currNode.word = word


class ReplaceWords(object):
    def replaceWords(self, dict, sentence):
        trie = Trie()

        for word in dict:
            trie.insert(word)

        newWords = []

        for word in sentence.split():

            currNode = trie.root
            for i in range(len(word)):
                currChar = word[i]
                if (currNode.children[ord(currChar) - ord('a')] == None or currNode.word != None):  
                    break
                currNode = currNode.children[ord(currChar) - ord('a')]

            newWord = currNode.word                   

            if (newWord == None):                    
                newWords.append(word)
            else:                                     
                newWords.append(newWord)

        return ' '.join(newWords)                   