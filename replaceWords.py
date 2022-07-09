#time complexity: O(nk)
#space complexity: O(n) for trie

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for i in range(26)]
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = TrieNode()
        for word in dictionary:
            curr = root
            for i in range(len(word)):
                if curr.children[ord(word[i])-ord('a')] is None:
                    curr.children[ord(word[i])-ord('a')] = TrieNode()
                curr = curr.children[ord(word[i])-ord('a')]
            curr.isEnd = True
        
        splitS = sentence.split()
        res = ""
        k = 0
        for word in splitS:
            replaceS = ""
            curr = root
            if k != 0:
                res += " "
            for i in range(len(word)):
                if curr.children[ord(word[i])-ord('a')] is None or curr.isEnd:
                    break
                replaceS += word[i]
                curr = curr.children[ord(word[i])-ord('a')]
            if curr.isEnd:
                res += replaceS
            else:
                res += word
            k += 1
        return res
            
                
                
                
                
                
            
            
        
                
            
        
        
