#Time Complexity - O(nl)
#Space Complexity - O(nl)

class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = {}
        result = ""
        trie["-"] = True
        for word in words:
            t = trie
            for ch in word:
                if ch not in t:
                    t[ch] = {}
                t = t[ch]
            t["-"] = True
        def explore(trie, string):
            nonlocal result
            print(string)
            if '-' not in trie:
                return
            if len(result) < len(string):
                result = string
            elif len(result) == len(string) and result > string:
                result = string
            for x in trie:
                if x == '-':
                    continue
                string += x
                explore(trie[x], string)
                string = string[:len(string) - 1]
        
        explore(trie, "")
        return result