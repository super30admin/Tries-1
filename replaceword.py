#Time Complexity: O(kl+n)
#Space Complexity: O(n)
class Solution:
    
    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.isEnd = False
    
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            idx = ord(ch) - ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = self.TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = self.TrieNode()
        res = []
        for word in dictionary:
            self.insert(word)
            
        lst = sentence.split()
        
        
        for i in range(len(lst)):
            word = lst[i]
            curr = self.root
            temp = ""
            flag = 0
            for i in range(len(word)):
                ch = word[i]
                idx = ord(ch) - ord('a')
                
                if curr.isEnd == True:
                    break
                if curr.children[idx] == None:
                    flag = 1
                    break
        
                    
                temp += word[i]
                curr = curr.children[idx]
                
            if flag ==0:
                res.append(temp)
            else:
                res.append(word)
                
        return " ".join(res)