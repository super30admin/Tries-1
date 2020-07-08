class Solution(object):
    # create node class
    class Node():
        def __init__(self):
            self.children = {}
            self.endOfWord = None
    #crate Trie class
    class Trie(object):

        def __init__(self):
            """
            Initialize your data structure here.
            """
            self.root = Solution.Node()
        # insert putting at end of word the word itself
        def insert(self, word):
            """
            Inserts a word into the trie.
            :type word: str
            :rtype: None
            """
            iterator = self.root
            for i in word:
                if i not in iterator.children:
                    iterator.children[i] = Solution.Node()
                iterator = iterator.children[i]
            iterator.endOfWord = word
        #search word and return the first end of word you find if anyletter not found return None
        def search(self, word):
            """
            Returns if the word is in the trie.
            :type word: str
            :rtype: bool
            """
            iterator = self.root
            for i in word:
                if iterator.endOfWord:
                    return iterator.endOfWord
                elif i not in iterator.children:
                    return None
                else:
                    iterator = iterator.children[i]
            return iterator.endOfWord
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        # instanciate Trie
        myTrie = Solution.Trie()
        # insert all words in dict in Trie
        for i in dict:
            myTrie.insert(i)
        #get all words from string
        words = sentence.split(" ")
        # for each word found
        for i in range(len(words)):
            #search in trie
            mysearch = myTrie.search(words[i])
            # if prefix found replace it in words
            if mysearch:
                words[i] = mysearch
        # join words and return
        return " ".join(words)
        
        