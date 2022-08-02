# Time Complexity => O(N)
# Space Complexity => O(N)


class TrieNode:
    def __init__(self):
        self.child = {}
        self.endOfWord = False

class Solution:
    def __init__(self):
        self.root = TrieNode()    
        
    def insert(self, s: str):
        cur = self.root
        for i in s:
            if i not in cur.child:
                cur.child[i] = TrieNode()
            cur = cur.child[i]
        cur.endOfWord = True
        
    def search(self, prefix: str):
        curr = self.root
        string = ""
        for i in prefix:
            if i not in curr.child:
                return ""
            string += i
            curr = curr.child[i]
            if curr.endOfWord == True:
                return string
        return ""
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if(len(dictionary) == 0):
            return sentence
        for i in dictionary:
            self.insert(i)
        
        newsent = []
        for i in sentence.split():
            ret = self.search(i)
            if(ret!=""):
                newsent.append(ret)
            else:
                newsent.append(i)
        return ' '.join(newsent)
        
        
        
        