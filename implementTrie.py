# Time Complexity : O(n) for all methods, where n is the length of word/prefix
# Space Complexity : O(nl), where n is the number of words in the trie and l is the average length of the words
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class TrieNode(object):
    def __init__(self):
        self.isWord = False
        self.branches = [None] * 26

class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    # check for prefix letter by letter and insert new node if necessary
    # in the end mark flag true to represent end of a word.
    def insert(self, word):
        curr = self.root
        for i in word:
            temp = ord(i) - ord('a')
            if curr.branches[temp] == None:
                curr.branches[temp] = TrieNode()
            curr = curr.branches[temp]
        curr.isWord = True

    # check for prefix, letter by letter, if branch breaks before word is found
    # return false. If word found return whether word or prefix for another word
    def search(self, word):
        curr = self.root
        for i in word:
            temp = ord(i) - ord('a')
            if curr.branches[temp] == None:
                return False
            curr = curr.branches[temp]
        return curr.isWord

    # Check for prefix, if branch breaks, return False
    # in the end return True.
    def startsWith(self, prefix):
        curr = self.root
        for i in prefix:
            temp = ord(i) - ord('a')
            if curr.branches[temp] == None:
                return False
            curr = curr.branches[temp]
        return True
