class Solution:
    class Trie:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False

        def insert(self, word: str) -> None:
            curr = self
            for c in word:
                idx = ord(c) - ord('a')
                if not curr.children[idx]:
                    curr.children[idx] = Solution.Trie()
                curr = curr.children[idx]
            curr.isEnd = True
    
    def getPrefix(self, trie, word: str) -> str:
        res = ""
        curr = trie
        for c in word:
            idx = ord(c) - ord('a')
            if not curr.children[idx] or curr.isEnd:
                break
            res += c
            print(res)
            curr = curr.children[idx]
        
        return res if curr.isEnd else word
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        obj = Solution.Trie()
        for word in dictionary:
            obj.insert(word)
        
        words = sentence.split()
        res = [self.getPrefix(obj, word) for word in words]
        
        return ' '.join(res)
