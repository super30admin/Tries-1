class TrieNode:
    
    def __init__(self):
        self.children = [None] * 26
        self.word = None

class Solution:
    
    """
    Description: Given a list of strings words representing an English Dictionary, find the longest word 
    
    Time Complexicity: O(m*n)
    Space Complexicity: O(m*n)
    where, m is average length of word and n is the size of words
    
    Approach:
    - add words to a Trie (add space)
    Use BSF (from right to left, i.e. reverse):
    - Take each children from root to a queue
    - drop elements from queue by 
      + add children of each queue 
      + do not add if children does not complete a word
    - add the resulting word until queue is empty, which should result in largest word
      + with smaller lexicography since BSF used in reverse direction
      + longest word as the words as last queue elements will be naturally from longest string of words
    """
    
    from collections import deque
           
    def insert(self, word):
        currNode = self.root
        for char in word:
            if currNode.children[ord(char) - ord("a")] == None:
                currNode.children[ord(char) - ord("a")] = TrieNode()
            currNode = currNode.children[ord(char) - ord("a")]
        # add word and not *.isEnd (for returning, read question)
        currNode.word = word

    def longestWord(self, words: List[str]) -> str:
        
        if words == None: return ""
        
        self.root = TrieNode()
        
        # insert given words in a Trie
        for word in words:
            self.insert(word)
            
        queue = deque()
        currNode = self.root
        queue.append(currNode)

        while queue:
            currNode = queue.popleft()
            for k in reversed(range(26)):
                if currNode.children[k] != None and currNode.children[k].word != None:
                    queue.append(currNode.children[k])

        return currNode.word
