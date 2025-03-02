#time complexity o(m+n)*l m is the word, n is the string in the dictionary
# space complexit  o(n*l)
class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            index = ord(ch) - ord('a')
            if index not in curr.children:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        strArr = sentence.split()
        result = []
        for currword in strArr:
            #search for smaller prefix
            curr = self.root
            replacement = []
            for j in range(len(currword)):
                index = ord(currword[j]) - ord('a')
                if index not in curr.children or curr.isEnd:
                    break 
                replacement.append(currword[j])
                curr = curr.children[index]
            if curr.isEnd:
                result.append("".join(replacement))
            else:
                result.append(currword) 
        
        return " ".join(result)