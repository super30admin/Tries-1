class TrieNode:
    def __init__(self):
        self.chars = dict() #{'a': {'b: {c}}, 'b':}
        self.isEnd = False

class Solution:
    def __init__(self):
        self.Trie = TrieNode()
        self.res = ""

    def insertWord(self, word):
        cur = self.Trie
        for c in word:
            if c not in cur.chars:
                cur.chars[c] = TrieNode()
            cur = cur.chars[c]
        cur.isEnd = True

    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insertWord(word)
        
#        for c in 'abcdefghijklmnopqrstuvwxyz':
  
        def dfs(root, ans):
            if root != self.Trie and not root.chars:
                #leaf
                if len(ans) > len(self.res) or (len(ans) == len(self.res) and ans < self.res):
                    self.res = ans
                return
            
            if root != self.Trie and not root.isEnd:
                return 
            else:
                if len(ans) > len(self.res) or (len(ans) == len(self.res) and ans < self.res):
                    self.res = ans
            
            for c in sorted(root.chars):
                ans += c
                dfs(root.chars[c], ans)
                ans = ans[:-1] 
            return
        
        dfs(self.Trie, "")
        #print(self.res)
        return self.res

            
            
