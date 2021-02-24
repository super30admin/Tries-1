# // Time Complexity : 
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# We store all the word from the given array into the trie
# along with it we store "WORD" at each node
# if there is no Word that means we dont have substring for that word in the list
# we use BFS to find the largest word
# we use for loop from 25 to 0 to find if there is children also it taked care the lexiographic order
# in queue we check if word is not None and the children is not None
# finally we return the last element remaining in the queue word -> cur.word 

class Solution:
    def __init__(self):
        self.root = TrieNode()

    def longestWord(self, words: List[str]) -> str:
        
        for w in words:
            self.insert(w)
        
        node = self.root
        q = deque()
        q.append(node)
        cur = TrieNode()
        while q:
            cur = q.popleft()
            # find if it has children and take care of lexiographic order
            for i in range(25,-1,-1):
                # if there is children at ith location and this children is present in the array add it to the queue
                if cur.children.get(i) != None and cur.children.get(i).word != None:
                    q.append(cur.children[i])
        return cur.word
    
    
    
    def insert(self, word):
        node = self.root
        for i in word:
            if ord(i)-ord('a') not in node.children:
                node.children[ord(i)-ord('a')] = TrieNode()
            node = node.children[ord(i)-ord('a')]
        node.word = word
            
class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = None
        
    