"""
sort the words and insert into Trie
check all prefixes and if it exisst update the longest word
TC: O(n*k logn) for sorting + O(n*k) for Trie insertion, n- number of words , k avg length of each word
SP: O(n*k) to store all the words

"""
class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for w in word:
            if w not in curr.children:
                curr.children[w]= TrieNode()
            curr = curr.children[w]
        curr.isEnd = True

    def can_build(self, word):
        curr = self.root
        for w in word[:-1]:  # Check all prefixes
            curr = curr.children[w]
            if not curr.isEnd:
                return False
        return True
class Solution:
    def longestWord(self, words: List[str]) -> str:
        pref_tree = Trie()
        words.sort()
        for word in words:
            pref_tree.insert(word)

        longest = ""
        for word in words:
            if pref_tree.can_build(word):
                if len(word) > len(longest):
                    longest = word
        return longest
    


        