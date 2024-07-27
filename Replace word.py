#// Time Complexity : O(n * L) n is the number of words, L is length of the word
# // Space Complexity : O(n * L) where n is number of words and l is average length of the word
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class TrieNode:
    def __init__(self):
        # Stores children nodes and whether node is the end of a word
        self.children = [None for _ in range(26)]
        self.isEnd = False

class Solution:
    def __init__(self):
      self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in word:
            if curr.children[ord(i) - ord('a')] == None:
                curr.children[ord(i) - ord('a')] = TrieNode()
            curr = curr.children[ord(i) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for i in dictionary:
            self.insert(i)
        result = []
        
        for i in sentence.split(" "):
            curr = self.root
            replacement = ''
            for j in i:
                if curr.children[ord(j) - ord('a')] == None or curr.isEnd:
                    break
                curr = curr.children[ord(j) - ord('a')]
                replacement  += j

            if curr.isEnd:
                result.append(replacement)
            else:
                result.append(i)
        
        return " ".join(result)
             
        

