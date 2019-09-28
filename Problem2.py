# Did this code successfully run on Leetcode : Yes
# Time Complexity: O(n) (where n is sum of length of all the words)
# Space Complexity: O(n) (where n is sum of length of all the words)

# Three line explanation of solution in plain english:
# - Use trie to store all the words. Make change into the trie node to store whole word at the end of trie node.
# - Use bfs to parse the trie nodes. Add root node into the queue and after that add only the nodes which have isEnd True into the queue.
# - Update the word if current node from queue is bigger in length and smaller in lexical order.

class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}
#       Same Trie implementation nut one more variable to store word.
        self.word = ''
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for char in word:
            if char not in curr.children:
                curr.children[char] = TrieNode()
            curr = curr.children[char]
        curr.isEnd = True
#       In the insert if we reach the end of the word than add that word to the last trie node.
        curr.word = word
        

class Solution:
    def longestWord(self, words: List[str]) -> str:
#       Initialize trie and add all the words in it.
        trie = Trie()
        for word in words:
            trie.insert(word)
            
#       Initialize queue and answer string.
        queue = []
        ans = ''
        
#       Add root in the queue
        queue.append(trie.root)
        
#       Run this until queue is not empty
        while queue:
#           pop the element form the queue
            curr = queue.pop(0)
#           Check all its children
            for child in curr.children.values():
#               If the child element is end add it to the queue
                if child.isEnd:
                    queue.append(child)
#                   Also make sure that child's word is smaller in lexical order and bigger in length than current answer
                    if child.word < ans or len(child.word) > len(ans):
                        ans = child.word
                        
        return ans
