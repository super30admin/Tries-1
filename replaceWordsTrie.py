# Time complexity:  O(M*N) where M is length of the dict and N is number of words in the sentence
# Space complexity: O(N) where N is length of the sentence
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = dict()
        self.isWord = False


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for letter in word:
            child = node.children.get(letter)
            if child is None:
                child = TrieNode()
                node.children[letter] = child
            node = child
        node.isWord = True

    def search(self, word):
        answer = ''
        node = self.root
        for letter in word:
            node = node.children.get(letter)
            if node is None:
                break
            answer += letter
            if node.isWord:
                return answer
        return word


class Solution(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        trie = Trie()
        for word in dict:
            trie.insert(word)
        answer = []
        for word in sentence.split():
            answer.append(trie.search(word))
        return ' '.join(answer)
