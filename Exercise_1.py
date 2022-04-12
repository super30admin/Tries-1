
class TrieNode(object):

    def __init__(self):
        self.childNode = [None for i in range(26)]
        self.word = None
        
class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):

        currNode = self.root

        for i in range(len(word)):
            currChar = word[i]
            if (currNode.childNode[ord(currChar) - ord('a')] == None):
                currNode.childNode[ord(currChar) - ord('a')] = TrieNode()
            currNode = currNode.childNode[ord(currChar) - ord('a')]

        currNode.word = word


class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        #   initialize a Trie
        trie = Trie()
        newWords = []

        for word in dictionary:
            trie.insert(word)
        
        
        for s_word in sentence.split():
            currNode = trie.root
            for w in s_word:
                if currNode.childNode[ord(w)-ord('a')]:
                    currNode = currNode.childNode[ord(w)-ord('a')]
                else:
                    break
            newWord = currNode.word
                
            if not newWord:
                newWords.append(s_word)
            else:
                newWords.append(newWord)
                
        return ' '.join(newWords)
