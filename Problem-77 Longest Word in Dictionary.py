# 720. Longest Word in Dictionary
# https://leetcode.com/problems/longest-word-in-dictionary/

# Logic: Add all the words in the dictionary. Sort the words list on length and letters. 
# Start searching in the trie. If the letter doesnt have a isEnd as true, means that word 
# is not there in the dict so we cannot take it. If it is true, we move to the next letter.

# Time Complexiety: O(len(words)) [creating dictionary] + O(nlogn) [sorting words list]
# Space Complexiety: O(len(words)) [to store the dictionary]

class trieNode:
    def __init__(self):
        self.isEnd = False
        self.child = dict()
        
class Solution:
    def __init__(self):
        self.root = trieNode()
    
    def insert(self, word):
        cur = self.root
        
        for i in word:
            if cur.child.get(i) == None:
                cur.child[i] = trieNode()
            cur = cur.child[i]
        cur.isEnd = True
        
    def longestWord(self, words) -> str:
        # Add word given in Trie
        words = sorted(words, key = lambda x: len(x))
        for i in words:
            self.insert(i)
            
        words = sorted(words, key = lambda x: (-len(x),x))
        
        for i in words:
            cur = self.root
            temp = ""
            for j in i:
                temp += j
                if cur.child[j].isEnd == True:
                    cur = cur.child[j]
                else:
                    break
            if temp == i:
                return temp
        return ""

obj = Solution()
print(obj.longestWord(["wo","wor","worl","world"]))
# print(obj.longestWord(["a","banana","app","appl","ap","apply","apple"]))