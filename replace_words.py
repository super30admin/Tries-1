# Time Complexity: O(n) where n is the length of the words in dictionary
# Space Complexity: O(n) where n is the length of the sentence
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
After creating a Trie with the dictionary words, we iterate through the sentence and for each word we check 
if we can find a word in the Trie that is shorter than it. If we find one, we replace the word with the shorter 
word, else we keep the word as it is. We return the sentence after joining the words with a space.
"""

class Solution:
    class TrieNode():
        def __init__(self):
            self.children = [None for i in range(26)]
            self.isEnd = False           
        
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            index = ord(c) - ord('a')
            if curr.children[index] == None:
                curr.children[index] = self.TrieNode()
            curr = curr.children[index]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if dictionary is None or len(dictionary) == 0: return sentence

        self.root = self.TrieNode()
        for word in dictionary:
            self.insert(word)
        
        strArray = sentence.split(' ')
        answer = []

        for i in range(len(strArray)):
            word = strArray[i]
            curr = self.root
            replacement = []
            for j in word:
                index = ord(j) - ord('a')
                if curr.children[index] == None or curr.isEnd:
                    break
                replacement.append(j)
                curr = curr.children[index]
            if curr.isEnd:
                answer.append("".join(replacement))
            else:
                answer.append(word)

        return ' '.join(answer)
