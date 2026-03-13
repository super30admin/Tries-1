# Time Complexity : O(M * L + N * L) where M is the number of words in dictionary, N is number of words in sentence and L is the average word length
# Space Complexity : O(M * L + N * L) for tries and split array.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First we build a Trie using all the words from the dictionary.
# Then we go word by word in the sentence and check for the shortest prefix match in the Trie.
# If a match is found, we use that word; if not, we keep the original word.


class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word):
        curr = self.root
        for c in word:
            idx = ord(c) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = self.TrieNode()

            curr = curr.children[idx]
        curr.isEnd = True

    def getShortestVersion(self, word):
        curr = self.root
        sb = []
        for c in word:
            idx = ord(c) - ord('a')
            if not curr.children[idx] or curr.isEnd:
                break
            sb.append(c)
            curr = curr.children[idx]
        if curr.isEnd:
            return ''.join(sb)
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        
        splitArr = sentence.split(" ")
        res = []

        for ele in splitArr:
            res.append(self.getShortestVersion(ele))

        return " ".join(res)



        