# Time Complexity : O(lengthOfSentence*LenWord)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]
        
class Solution:
    def __init__(self):
        self.head = TrieNode()
    
    def insert(self, word):
        curr = self.head 
        
        for i in range(len(word)):
            c = word[i]
            if not curr.children[ord(c) - ord('a')]:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        #insert words from dictionary into trie
        for word in dictionary:
            self.insert(word)
            
        res = []
        count = 0
        for word in sentence.split():
            if count > 0:
                res.append(' ')
            curr = self.head 
            replacement = []
            for i in range(len(word)):
                c = word[i]
                if not curr.children[ord(c)-ord('a')] or curr.isEnd == True:
                    break
                replacement.append(c)
                curr = curr.children[ord(c) - ord('a')]
                
            if curr.isEnd: 
                res.append(''.join(replacement))
            else:
                res.append(word)
            count += 1
                
        return ''.join(res)
        