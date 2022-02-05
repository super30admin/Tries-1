# Tries-1

## Problem1 
Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)


class Node:
    def __init__(self,char):
        self.is_word = False
        self.children = {}

class Trie:

    def __init__(self):
        self.root = Node('')
        

    def insert(self, word: str) -> None:
        temp = self.root
        for char in word:
            if char not in temp.children:
                temp.children[char] = Node(char)
            temp = temp.children[char]
        temp.is_word = True

    def search(self, word: str) -> bool:
        temp = self.root
        for char in word:
            if char not in temp.children:
                return False
            temp = temp.children[char]
        return temp.is_word
        

    def startsWith(self, prefix: str) -> bool:
        temp = self.root
        for char in prefix:
            if char not in temp.children:
                return False
            temp = temp.children[char]
        return True
        

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

## Problem2
Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

class Solution(object):
    def longestWord(self, words):
        Trie = lambda: collections.defaultdict(Trie)
        trie = Trie()
        END = True

        for i, word in enumerate(words):
            reduce(dict.__getitem__, word, trie)[END] = i

        stack = trie.values()
        ans = ""
        while stack:
            cur = stack.pop()
            if END in cur:
                word = words[cur[END]]
                if len(word) > len(ans) or len(word) == len(ans) and word < ans:
                    ans = word
                stack.extend([cur[letter] for letter in cur if letter != END])

        return ans

## Problem3
Replace Words (https://leetcode.com/problems/replace-words/)


class Solution(object):
    def replaceWords(self, roots, sentence):
        Trie = lambda: collections.defaultdict(Trie)
        trie = Trie()
        END = True

        for root in roots:
            reduce(dict.__getitem__, root, trie)[END] = root

        def replace(word):
            cur = trie
            for letter in word:
                if letter not in cur or END in cur: break
                cur = cur[letter]
            return cur.get(END, word)
        return " ".join(map(replace, sentence.split()))   