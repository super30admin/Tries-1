# Time O(n)
# Space O(n)
class Trie:
    class TrieNode:
        def __init__(self):
            self.chars = [None] * 26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()
    
    def insert(self, word) -> None:
        curr = self.root
        for c in word:
            i = ord(c) - ord('a')
            if curr.chars[i] == None: 
                curr.chars[i] = self.TrieNode()
            curr = curr.chars[i]
        curr.isEnd = True
    
    def isValid(self, word) -> bool:
        curr = self.root
        for c in word:
            i = ord(c) - ord('a')
            if curr.chars[i] == None: return False
            curr = curr.chars[i]
            if curr.isEnd == False: return False
        return True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        l = 0
        result = ""
        for word in words:
            if trie.isValid(word):
                n = len(word)
                if n > l:
                    l = n
                    result = word
                elif n == l and result > word: result = word
        return result
    
# Time O(2n)
# Space O(n)
class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        word_set = set()
        for word in words:
            word_set.add(word)
        l, result = 0, ""
        isValid = True
        for word in words:
            for i in range(len(word)):
                if word[:(i+1)] not in word_set:
                    isValid = False
                    break
            if isValid:
                if len(word) > l or (len(word) == l and result > word):
                    l = len(word)
                    result = word
            isValid = True

        return result

# Time O(n long n + n)
# Space O(n)    
class Solution:
    def longestWord(self, words: List[str]) -> str:
        words = sorted(words)
        wordset = set([''])
        longest_word = ""

        for word in words:
            if word[:-1] in wordset:
                wordset.add(word)
                if len(word)>len(longest_word):
                    longest_word = word

        return longest_word