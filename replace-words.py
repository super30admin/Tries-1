class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

# TC : O(ml + nl') -
# m is no. of words in the dictionary and l is the avg length of words in the dictionary
# n is no. of words in the sentence and l' is the avg length of words in the sentence
# SC : O(ml + nl')
# ml nodes for the trie of dictionary and nl' for the list of words of sentences

class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """

        result = []

        dict_trie = TrieNode()
        for word in dictionary:
            curr = dict_trie
            for ch in word:
                if curr.children[ord(ch) - ord('a')] is None:
                    curr.children[ord(ch) - ord('a')] = TrieNode()
                curr = curr.children[ord(ch) - ord('a')]
            curr.isEnd = True

        words_list = sentence.split(" ")

        for word in words_list:
            replacement_word = []
            curr = dict_trie
            for ch in word:
                if curr.children[ord(ch) - ord('a')] is None or curr.isEnd == True:
                    break
                replacement_word.append(ch)
                curr = curr.children[ord(ch) - ord('a')]
            if curr.isEnd:
                result.append("".join(replacement_word))
            else:
                result.append(word)
        return " ".join(result)





