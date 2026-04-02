# Time: O(N * L) where N is the number of words and L is the average length of the words. This time complexity is for both adding and traversing the trie. 
# Space: O(N * L) for the trie structure

# Question => Given an array of strings words, return the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.


# At first we create a class for TrieNode.
# Then we will add all the words in the trie and mark the end of the word with isEnd = True.
# After that we will do a dfs and whenever we see that isEnd is False we will return 
# and if the length of the path is greater than the max_str then we will update the max_str to be the curent path.
# In the dfs we go through all the childrens and whenever we see a child we append it to the path then recurse with the child as the root and then we backtrack by popping the last character from the path.
# MAKE SURE TO MARK THE ROOT NODE AS isEnd = True BECAUSE WE CAN START FROM THE ROOT NODE AND THEN BUILD THE WORDS FROM THERE. IF WE DONT MARK THE ROOT NODE AS isEnd = True THEN WE WONT BE ABLE TO BUILD ANY WORDS FROM THE ROOT NODE AND WE WONT GET ANY ANSWER.
# At the end return the max_str.
class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isEnd = False
    def longestWord(self, words: List[str]) -> str:
        root = self.TrieNode()
        root.isEnd = True
        for word in words:
            curr = root
            for char in word:
                idx = ord(char) - ord('a')
                if not curr.children[idx]:curr.children[idx] = self.TrieNode() 
                curr = curr.children[idx]
            curr.isEnd = True

        self.max_str = ''
        self.dfs(root,[])
        return self.max_str
        
    def dfs(self,curr,path):
        if not curr.isEnd: return
        if len(path) > len(self.max_str):
            self.max_str = ''.join(path)

        for i in range(26):
            if curr.children[i]: 
                # action
                path.append(chr(ord('a') + i))
                # recurse
                self.dfs(curr.children[i],path)
                # backtrack
                path.pop()