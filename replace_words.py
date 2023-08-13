class TrieNode:
    # Initialize your data structure here.
    def __init__(self):
        self.word = False
        self.children = {}


class Trie:
    # https://leetcode.com/explore/learn/card/trie/147/basic-operations/1047/
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        node = self.root
        for i in word:
            if i not in node.children:
                node.children[i] = TrieNode()
            node = node.children[i]
        node.word = True

    def find_prefix(self, word):
        node = self.root
        prefix = ''
        for i in word:
            prefix += i
            if i not in node.children:
                return word
            else:
                if node.children[i].word:
                    return prefix
                else:
                    node = node.children[i]
        return word


class Solution:
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        tire = Trie()
        for i in dict:
            tire.insert(i)

        words=[]
        for i in sentence.split(sep=' '):
            words.append(tire.find_prefix(i))
        return ' '.join(words)