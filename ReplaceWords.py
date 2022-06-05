class Node():
    def __init__(self):
        self._trie = 26 * [None]
        self._isEnd = None


class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        # Tc = O(n*k) => n is the length of sentence and k is length of words in sentence - doubtful
        # Sc = O(n*k) => n is the length of sentence and k is length of words in sentence - doubtful
        root = Node()

        def constructTrie(word):
            curr = root
            for char in word:
                index = ord(char) - ord('a')
                if not curr._trie[index]:
                    curr._trie[index] = Node()
                curr = curr._trie[index]
            curr._isEnd = word

        def findReplacementWord(sentenceword):
            curr = root
            for char in sentenceword:
                index = ord(char) - ord('a')
                if curr._trie[index] and curr._trie[index]._isEnd:
                    return curr._trie[index]._isEnd
                if not curr._trie[index]:
                    return sentenceword
                curr = curr._trie[index]

            if not curr._isEnd:
                return sentenceword

            return curr._isEnd

        for word in dictionary:
            constructTrie(word)

        result = ""
        sentence = sentence.split(" ")
        for word in sentence:
            if not word.isspace():
                result = result + " " + findReplacementWord(word)

        return result.strip()
