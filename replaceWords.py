class TrieNode(object):
    def __init__(self):
        self.isWord = False
        self.branches = [None] * 26


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for i in word:
            temp = ord(i) - ord('a')
            if curr.branches[temp] == None:
                curr.branches[temp] = TrieNode()
            curr = curr.branches[temp]
        curr.isWord = True


class Solution(object):
    """
    Time Complexity : O(nl + ml) where n is the number of words in the dict, m is the number of
                      words in the sentence and l is the average length of the words in the trie.
    Space Complexity : O(nl), where n is the number of words in the trie and l is the average length of the words
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No

    Your code here along with comments explaining your approach

    This approach uses a trie, each word in the dict is inserted into the trie.
    For every word in the sentence a shorter word which is also a prefix is
    found and replaced, if such a word doesn't exist, add the original word.
    """
    def replaceWords(self, dict, sentence):
        if not dict: return sentence
        # trie init, adding all words from dict
        t = Trie()
        for i in dict:
            t.insert(i)

        words = sentence.split()
        retVal = ""
        # iterating over all the words
        for i in range(len(words)):
            if i > 0:
                retVal += " "
            # iterating over each word
            word = words[i]
            temp = ""
            curr = t.root
            for i in range(len(word)):
                idx = ord(word[i]) - ord('a')
                if curr.branches[idx] == None or curr.isWord:
                    break
                temp += word[i]
                curr = curr.branches[idx]

            if curr.isWord:
                retVal += temp
            else:
                retVal += word

        return retVal
