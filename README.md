# Tries-1

## Problem1: Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)
class Trie:

    def __init__(self):
        self.root={}
        
    def insert(self, word: str) -> None:

        cur=self.root

        for letter in word:
            if letter not in cur:
                cur[letter]={}
            cur=cur[letter]

        cur['*']=''

    def search(self, word: str) -> bool:

        cur=self.root
        for letter in word:
            if letter not in cur:
                return False
            cur=cur[letter]

        return '*' in cur
        
    def startsWith(self, prefix: str) -> bool:

        cur=self.root
        for letter in prefix:
            if letter not in cur:
                return False
            cur=cur[letter]

        return True



## Problem2: Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)
def longestWord(self, words: List[str]) -> str:
    #sort the words, then keep in the set and check for nextWord[:-1] in the set
    words.sort()
    st, res = set(), "" #res == result
    st.add("")
    for word in words:
        if word[:-1] in st:
            if len(word) > len(res):
                res = word
            st.add(word)
    
    return res


## Problem3: Replace Words (https://leetcode.com/problems/replace-words/)
class Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        roots = set(dict)
        words = sentence.split()
        result = []

        for word in words:
            for i in range(len(word) + 1):
                prefix = word[:i]
                if prefix in roots:
                    result.append(prefix)
                    break
            else:
                result.append(word)

        return ' '.join(result)


