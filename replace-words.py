# Time : O(nl) longest length of a word
# Space: O(dictionary)
class Trie:
    class TrieNode:
        def __init__(self, isEnd=False):
            self.chars = [None] * 26
            self.isEnd = isEnd

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            i = ord(c) - ord('a')
            if curr.chars[i] == None: 
                curr.chars[i] = self.TrieNode()
            curr = curr.chars[i]
        curr.isEnd = True

    def searchRoot(self, word: str) -> str:
        curr = self.root
        
        for j in range(len(word)):
            i = ord(word[j]) - ord('a')
            if curr.chars[i] == None: return None
            curr = curr.chars[i]
            if curr.isEnd == True: return word[:j+1]


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        res = []
        for word in sentence.split(" "):
            root = trie.searchRoot(word)
            if root is not None: res.append(root)
            else: res.append(word)
        return " ".join(res)