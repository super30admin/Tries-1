
# Time: O(M*L + N*L) M is num words in dict, N is num words in sentence, L is avg word length
# Space: O(M*L + N*L)
class Solution:
    class TrieNode:
        def __init__(self):
            self.children={}
            self.endOfWord = False
    
    def __init__(self):
        self.root = self.TrieNode()
    
    def insert(self,word):
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c]=self.TrieNode()
            curr = curr.children[c]
        curr.endOfWord = True
    
    def getShortestVersion(self,word):
        curr = self.root
        sb=[]
        for c in word:
            if c not in curr.children or curr.endOfWord:
                break
            sb.append(c)
            curr = curr.children[c]
        if curr.endOfWord:
            return ''.join(sb)
        # else
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        
        splitArr = sentence.split(" ")
        result = []

        for i in range(len(splitArr)):
            word = splitArr[i]
            result.append(self.getShortestVersion(word))
        
        return " ".join(result)