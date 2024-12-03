class Solution:
    class Trie():
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False
        
        def insert(self, word):
            curr = self
            for c in word:
                if not curr.children[ord(c)-ord('a')]:
                    curr.children[ord(c)-ord('a')] = Solution.Trie()
                curr = curr.children[ord(c)-ord('a')]
            curr.isEnd = True
        
        def isPrefix(self, word):
            curr = self
            for c in word:
                if not curr.children[ord(c)-ord('a')] or not curr.children[ord(c)-ord('a')].isEnd:
                    return False
                curr = curr.children[ord(c)-ord('a')]
            return curr.isEnd

    def lexicographical_score(string):
        score = 0
        for char in string.lower():
            score += ord(char) - ord('a') + 1  # 'a' gets 1, 'b' gets 2, etc.
        return score

    def longestWord(self, words: List[str]) -> str:
        #word.sort()
        obj = Solution.Trie()
        maxLen = 0
        map = {}
        hashSet = set()
        for word in words:
            obj.insert(word)

            if len(word) not in map.keys():
                map[len(word)] = [word]
            else:
                map[len(word)].append(word)

        for word in words:
            if len(word) == 1:
                hashSet.add(word)
                maxLen = max(maxLen, len(word))
            elif obj.isPrefix(word):
                hashSet.add(word)
                maxLen = max(maxLen, len(word))
            
        print(hashSet)
        print(maxLen)
        if maxLen == 0:
            return ""
        
        res = []
        for word in map[maxLen]:
            if word in hashSet:
                res.append(word)
        
        res.sort()
        return res[0]

        
