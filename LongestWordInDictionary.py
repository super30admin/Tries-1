# TC: O(n x p) where n is no of words in dictionary, p is average length of each word
# SC: O(n x p) where n is no of words in dictionary, p is average length of each word
# LeetCode: Y(https://leetcode.com/problems/longest-word-in-dictionary/)
# Approach: Use a trie to populate the words in the dictionary
#           keep track of the current word formed by adding attribute word to the TrieNode
#           Perform BFS on the tree and append the nodes from the back (answer should be lexicographically smaller) if it leads to a valid answer

class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [False for _ in range(26)]

class Solution:
    
    def insert_word_in_trie(self, word):
        current = self.root
        
        for character in word:
            if not current.children[ord(character) - ord('a')]:
                current.children[ord(character) - ord('a')] = TrieNode()
            
            current = current.children[ord(character) - ord('a')]
            
        current.word = word
    
    def longestWord(self, words: List[str]) -> str:
        
        # edge case
        if words == None or len(words) == 0:
            return ""
        
        # intiialize root
        self.root = TrieNode()
        
        # populate each word in trie
        for word in words:
            self.insert_word_in_trie(word)
            
        # intialize q for bfs
        q = []
        
        # append root to q
        q.append(self.root)
        
        # track current
        current = self.root
        
        # perform bfs until q is empty
        while (len(q)):
            
            # pop the trienode from front
            current = q.pop(0)
            
            # loop backwards as the answer should be lexicographically smaller
            for i in range(25, -1, -1):
                # if there is a word formed by changing the current word by one character then add the child node to bfs q
                if current.children[i] and current.children[i].word:
                    q.append(current.children[i])
         
        # if the last node in bfs q is a valid answer
        if current.word:
            return current.word
        
        # if the last node in bfs q is not a valid answer
        return ""
        
            
            
        
        
