 
# // Time Complexity : O((m+n)l)
# // Space Complexity : O(mp)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# We create the dictionary by inserting all the words in givne list and making trie
# we then iterate throgh the sentence, for each word in sentence we serach int trie
# if we find prefix in trie we then replace that with that prefix else we retain that word
# for simplification we create res list instead of string and return using " ".join(str)

class Solution:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for i in word:
            if i not in node.children:
                node.children[i] = TrieNode()
            node = node.children[i]
        node.isEnd = True
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        for i in dictionary:
            self.insert(i)
        
        res = []
        wordArray = sentence.split()
        # for each word in sentence
        for word in wordArray:
            replace = ""
            node = self.root
            # for each char in word
            for i in word:
                # check if its in dictionary if not then break
                if i not in node.children or node.isEnd: break
                replace += i
                node = node.children[i]
            # if we get isEnd true that means we have found the replacement 
            if node.isEnd:
                res.append(replace)
            else:
                res.append(word)
        return " ".join(res)
                
        
        
        
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}