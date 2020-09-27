"""
    // Time Complexity :O(nk + k)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode :YES
    // Any problem you faced while coding this : NA

    //Explanation:
    Read inline comments.
"""
class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.word1 = None
class Trie:
    def __init__(self):
        self.root = TrieNode()
    """
        for each character of word in dictionary, create a TrieNode at index position
    """
    def insert(self,word1):
        dummy = self.root
        for i in range(len(word1)):
            index = ord(word1[i]) - ord('a')
            if dummy.children[index] == None:
                dummy.children[index] = TrieNode()
            dummy = dummy.children[index]
        dummy.word1 = word1
        #print(word1,dummy.word1)


class Solution:
    def __init__(self):
        self.result = [ ]

    def replaceWords(self, dict: List[str], sentence: str) -> str:
        tr = Trie()
        """
            iterate over dict and insert each word in trie
        """
        for w in dict:
            tr.insert(w)

        """
            iterate over sentence and check if word is present in trie
            if it is present, replace with trie word
            else keep the sentence word as it is
        """
        current = tr.root

        wordList = sentence.split()

        for w in wordList:
            current = tr.root
            for i in range(len(w)):
                index = ord(w[i]) - ord('a')
                if current.children[index] == None or current.word1 != None:
                    break
                current = current.children[index]
            if current.word1 != None:
                self.result.append(current.word1)
            else:
                self.result.append(w)
        return " ".join(self.result)
