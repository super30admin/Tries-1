#Time: O(sum of lengths of all words in dictionary)
#Space: same as time
#did the code run successfully? yes
#Approach:
#insert words in trie
#using dfs find the valid candidate, place, update the result, explore further and backtrack.

class Trie:
    def __init__(self):
        self.root = [None for _ in range(27)]

    def insert(self, word):
        curr = self.root
        for c in word:
            idx = ord(c)-ord('a')
            if not curr[idx]:
                child = [None for _ in range(27)]
                curr[idx] = child
            curr = curr[idx]
        curr[-1] = True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        #create trie
        trie = Trie()
        for word in words:
            trie.insert(word)
        #backtracking
        def is_valid(child):
            return child and child[-1]

        def backtrack(curr, candidate):
            for idx in range(26):
                child = curr[idx]
                if is_valid(child):
                    letter = chr(idx+ord('a'))
                    candidate.append(letter)
                    if len(candidate) > len(self.result):
                        self.result = candidate[:]
                    backtrack(child, candidate)
                    candidate.pop()
        
        self.result = []
        backtrack(trie.root, [])
        return "".join(self.result)