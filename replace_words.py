# Time - O(m* n + k * p) where m : word length, n: number of words in dictionary, k is the total words in sentence each with length p
# Space - O(mn)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
    
class Solution:
    
    def insert(self, word):
        
        curr = self.root
        for w in word:
            if curr.children[ord(w) - ord('a')] == None:
                curr.children[ord(w) - ord('a')] = TrieNode()
            curr = curr.children[ord(w) - ord('a')]
            
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        if not dictionary or len(dictionary) == 0:
            return sentence
        
        self.root = TrieNode()
        
        for word in dictionary:
            self.insert(word)
            
        sen_split = sentence.split()
        res = []
        
        for i in range(len(sen_split)):
            word = sen_split[i]
            if i > 0:
                res.append(" ")
            
            curr = self.root
            replacement = []
            
            for c in (word):
                if curr.children[ord(c) - ord('a')] == None or curr.isEnd:
                    break
                replacement.append(c) 
                curr = curr.children[ord(c) - ord('a')]
                
        
            if curr.isEnd:
                res.append("".join(replacement))

            else:
                res.append(word)

        return "".join(res)
        