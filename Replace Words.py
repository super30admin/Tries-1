# Time Complexity: O(n * k) n is no. of words and k is max length of a word
# Space Complexity:O(n * 26 ^ k) n is no. of words and k is max length of a word
class TrieNode():
        def __init__(self):
            self.children = [None for _ in range(26)] #26 assuming that we are only dealing with lower case letters
            self.isEnd = False
class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c)-ord('a')] == None:
                curr.children[ord(c)-ord('a')] = TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.isEnd = True
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
        
        strArr = sentence.split()
        result = []
        
        for i in range(len(strArr)):
            currWord = strArr[i]
            replacement = []
            if i!=0:
                result.append(" ")
            curr = self.root
            for j in range(len(currWord)):
                c = currWord[j]
                if curr.children[ord(c)-ord('a')] == None or curr.isEnd:
                    break
                replacement.append(c)
                curr = curr.children[ord(c)-ord('a')]
            if curr.isEnd:
                result.append(''.join(replacement))
            else:
                result.append(strArr[i])
        return ''.join(result)