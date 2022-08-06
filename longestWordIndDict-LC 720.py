
# Using BFS Traversal
# Time Complexity = O(n * l) (insert method), n = no. of words, l = avg length of words. At max there are 26 alphabets, so n * l * 26 = n * l

# Space Complexity = O(n * l) [Trie Space] + O(n * l) [Queue space worst case] = O(n * l)


class TrieNode:
    def __init__(self):
        self.child = [None] * 26
        self.word = ""
        
        
        
class Solution:
    def __init__(self):
        self.root = TrieNode()
        
        
    def insert(self, word):
        curr = self.root
        for char in word:
            c = ord(char) - ord('a')
            if curr.child[c] == None:
                curr.child[c] = TrieNode()
                
            curr = curr.child[c]
        
        # Assign the 'word' whenever the iteration ends fro each word in list of words. This helps in keeping track of what words were given as input and what weren't
        curr.word = word
        
    def longestWord(self, words: List[str]) -> str:
        
        if words == None:
            return ""
            
        for word in words:
            self.insert(word)
            
        # Starting BFS
        st = ""
        q = []
        q.append(self.root)
        
        while(q):
            curr = q.pop(0)
            # Iterate backwards to maintain the lexicographical order in the result
            for i in range(25, -1, -1):
                # If there is a Trie and it has a word value associated with it, it means it was passed as an input. Append that trie to the queue
                if curr.child[i] != None and curr.child[i].word != "":
                    q.append(curr.child[i])
            
        return curr.word