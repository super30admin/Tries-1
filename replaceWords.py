"""
Time Complexity : insert() - O(n) - where n is the total number of characters
                  replaceWords() - O(n)
Space Complexity : insert() - O(mn) - where m is the number of words and n is the average length of a word   
                  replaceWords() - O(mn) - where m is the number of words and n is the average length of a word 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.word = None
            
    def __init__(self):
        self.root = self.TrieNode()
        
    def insert(self, word):
        curr = self.root
        for w in word:
            idx = ord(w) - ord('a')
            if not curr.children[idx]:
                curr.children[idx] = self.TrieNode()
            curr = curr.children[idx]
        curr.word = word
        
    
    def replaceWords(self, dict, sentence):
        for word in dict:
            self.insert(word)
            
        output = ""
        split_sent = sentence.split(" ")
        
        for w in split_sent:
            if len(output) > 0:
                output += " "
            curr = self.root
            for i in w:
                idx = ord(i) - ord('a')
                if curr.children[idx] == None or curr.word != None:
                    break
                curr = curr.children[idx]
            
            replacement = curr.word
            if replacement == None:
                output += w
            else:
                output += replacement
            
        return output
    
s = Solution()
print(s.replaceWords(["a", "aa", "aaa", "aaaa"],
"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"))
print(s.replaceWords(["cat", "bat", "rat"],
"the cattle was rattled by the battery"))