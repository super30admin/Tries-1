#Time: O(sum of lengths of all words in dictionary)
#Space: same as time
#did the code run successfully? yes
#Approach:
#insert words in trie
#traverse each word and check if all its prefixes are words in the trie
#update the result with longest and lexicographically smaller such word

class Trie:
    def __init__(self):
        self.root = {}

    def insert(self, word):
        curr = self.root
        for c in word:
            if c not in curr:
                curr[c] = {}
            curr = curr[c]
        curr['isWord'] = True

    def prefixes(self, word):
        curr = self.root
        for c in word:
            if 'isWord' not in curr[c]:
                return False
            curr = curr[c]
        return True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        #create trie
        trie = Trie()
        for word in words:
            trie.insert(word)

        result = ''
        for word in words:
            if trie.prefixes(word):
                l1, l2 = len(word), len(result)
                if l1>l2:
                    result = word[:]
                elif l1==l2:
                    result = min(result, word)

        return result
   