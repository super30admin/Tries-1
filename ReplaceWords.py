'''
Solution:
1.  Insert all new possible words to the Trie.
2.  For each old word (split in the sentence by a space), check whether any subword is present in the Trie as a word
    and if present replace the sub-word with the old word and otherwise leave the old-word as is.
3.  Return the sentence conaining replaced words.

Time Complexity:    O(n * L) n is no. of words and L is max length of one word
Space Complexity:   O(n * L) max space occupied by the Trie; there is also space occupied by new sentence which is again
                    O(n * L) and so total space complexity would be O(n * L)

--- Passed all testcases on Leetcode successfully
'''


class TrieNode(object):

    def __init__(self):
        self.children = [None for i in range(26)]
        self.word = None


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):

        #   function to insert a word in a Trie data structure

        #   initialize to the root of the trie as current node
        currNode = self.root

        #   traverse the trie until we hit the length of word to be inserted
        for i in range(len(word)):
            currChar = word[i]
            if (currNode.children[ord(currChar) - ord('a')] == None):
                currNode.children[ord(currChar) - ord('a')] = TrieNode()
            currNode = currNode.children[ord(currChar) - ord('a')]

        currNode.word = word


class ReplaceWords(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        #   initialize a Trie
        trie = Trie()

        #   insert all words to a Trie present in the dict
        for word in dict:
            trie.insert(word)

        #   intialize a list to append all new words replacing old words
        newWords = []

        #   traverse all words
        for word in sentence.split():

            #   traverse the entire old word until you hit a sub-word
            currNode = trie.root
            for i in range(len(word)):
                currChar = word[i]
                if (currNode.children[ord(currChar) - ord('a')] == None or currNode.word != None):  #   condition to break
                    break
                currNode = currNode.children[ord(currChar) - ord('a')]

            newWord = currNode.word                   # take the new word to be the subword till we traversed

            if (newWord == None):                     # if new word not a word, then append old word itself
                newWords.append(word)
            else:                                     # else append new word
                newWords.append(newWord)

        return ' '.join(newWords)                     # join the list of new words as a string
