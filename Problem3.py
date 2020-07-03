# Time Complexity : O(n) n = length of word
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Trie:
    def __init__(self):
        self.childrens = [False] * 26 
        self.word = '' 

class TrieNode:
    def __init__(self):
        self.root = Trie()
    
    def insert(self,word):
        node = self.root
        for ch in word:
            indx = ord(ch) - ord('a')
            if node.childrens[indx] == False:
                node.childrens[indx] = Trie()
            node = node.childrens[indx]
        node.word = word 
    
class Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        t = TrieNode()
        for word in dict:
            t.insert(word)
        result = []
        words = sentence.split(' ')
        for word in words:
            node = t.root
            # print(node.childrens)
            for ch in word:
                indx = ord(ch) - ord('a')
                if not node.childrens[indx] or node.word != '':
                    break 
                node = node.childrens[indx]
            if node.word :
                result.append(node.word)
            else:
                result.append(word)
        return ' '.join(result)
                
                    
                
            
        