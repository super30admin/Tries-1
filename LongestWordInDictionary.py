"""
Approach: Using Trie 

We will build a trie of all given words first. Then we will do a level order traversal of the trie in reverse order.
Nodes at trie will have an additional infromation. Each node will also tell us the word that has been since that point.
For example: ["w","wo","wor","worl", "world"]
                    
                    "w" -> "w"
                     |
                    "o" -> "wo"
                     |
                    "r" -> "wor"
                     |
                    "l" -> "worl"
                     |
                    "d" -> "world"
                    
Also if the word "worl" is missing then we wont add that information at node "l". In this way it also tells us that if the word was present in the list or not.

                    "w" -> "w"
                     |
                    "o" -> "wo"
                     |
                    "r" -> "wor"
                     |
                    "l" 
                     |
                    "d" -> "world"

Here we will traverse the children in reverse order. Reason being we need to get the largest string with smallest lexicographical order. So if we do a normal traversal then might miss the largest string with smallest lexi order.  


So in level order traversal as we traverse the nodes, we add their children into the queue, and then their children and so on. Here we will add children that satisfy two conditions:
1) A letter is present at the node
2) It adding that letter makes a word

In this way we it will make sure we go down the branch in trie that makes up an entire word using the words given in the list.

Time complexity: O(n*p);  O(n x p) where n = no of words, p = avg length of a word
Space complexity: O(n*p); 

We are constructing a trie here with total nodes equals to n*p
"""

class TrieNode:
    def __init__(self):
        self.word = None
        self.children = [0] * 26 # If we were dealing with uppercase letters too then it will be 52

class Solution:
    
    
    def insert(self, word):
        curr = self.root
        
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] == 0:
                curr.children[ord(c) - ord('a')] = TrieNode()
                
            curr = curr.children[ord(c) - ord('a')] 
        curr.word = word
        
     
    def longestWord(self, words: List[str]) -> str:
        if words == None or len(words) == 0:
            return ""
        
        self.root = TrieNode()    
        
        # Time complexity: O(n x p) where n = no of words, p = avg length of a word
        for word in words:
            self.insert(word)
            
        q = []
        q.append(self.root)
        
        # Time complexity: O(n x p) where n = no of words, p = avg length of a word
        while len(q):
            curr = q.pop(0)
            for i in range(25, -1, -1):
                if curr.children[i] != 0 and curr.children[i].word != None:
                    q.append(curr.children[i])
                    
        # If ["world"] is given then we need to return empty string
        if curr.word == None:
            return ""
                    
        return curr.word