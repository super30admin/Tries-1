'''
Problem:  Replace Words
Time Complexity: O(n), where n is characters in sentence
Space Complexity: O(n), for trie
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        insert the dictionary words in trie
        traverse characters in sentence 
        find replacing word simultaneously
'''

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Solution:
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = TrieNode()
        for word in dictionary:
            self.insert(word)
        
        sent = sentence.split()
        result = []
        

        for k in range(len(sent)):
            word = sent[k]
            rep = ""
            curr = self.root
            for i in range(len(word)):
                idx = ord(word[i]) - ord('a')
                if curr.isEnd == True or curr.children[idx] == None:
                    break
                curr = curr.children[idx]
                rep+=word[i]
            
            if curr.isEnd==False:
                result.append(word)
            else:
                result.append(rep)
        
        return ' '.join(result)