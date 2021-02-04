# // Time Complexity : O(mn + kp)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Create a Trie for the dictionary
	# Traverse throught the dictionary for the words in the given sentence
	# if we reach the end or if we dont see the word we break the traversal and
	# append the corresponding original word or replacement word.
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None] * 26
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = TrieNode()
        Curr = self.root
        
        for words in dictionary:
            self.MakeNode(words)
            
        stringList = sentence.split(' ')
        result = []
        for word in stringList:
            temp = ''
            CurrNode = self.root
            for w in word:
                if CurrNode.children[ord(w)-ord('a')] == None  or CurrNode.isEnd == True:
                    break
                temp += w
                CurrNode = CurrNode.children[ord(w)-ord('a')]
                
            if CurrNode.isEnd == True:
                result.append(temp)
            else:
                result.append(word)
        return ' '.join(result)
                    
                
            
    def MakeNode(self,words):
        CurrNode = self.root
        for w in words:
            if CurrNode.children[ord(w)-ord('a')] == None:
                CurrNode.children[ord(w)-ord('a')] = TrieNode()
            CurrNode = CurrNode.children[ord(w)-ord('a')]
        CurrNode.isEnd = True