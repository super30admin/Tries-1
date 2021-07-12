class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [0] * 26
        
class Solution:
    
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            index = ord(word[i]) - ord('a')
            if not curr.children[index]:
                curr.children[index] = TrieNode()
            curr = curr.children[index]
        curr.isEnd = True  
        
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        for word in dictionary:
            self.insert(word)
            
        splitArray = sentence.split()
        result = ''
        for k in range(len(splitArray)):
            word = splitArray[k]
            if k > 0:
                result += ' '
            replacement = ''
            curr = self.root
            for i in range(len(word)):
                index = ord(word[i]) - ord('a')
                if not curr.children[index] or curr.isEnd:
                    break
                curr = curr.children[index]
                replacement += word[i]
            if curr.isEnd:
                result += replacement
            else:
                result += word
        return result

# Time Complexity: O(NK + L) 
# Space Complexity: O(NK)
# where K is average length of word in dictionary, N is number of words in dictionay and L is length of sentence.