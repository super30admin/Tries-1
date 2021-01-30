class Solution:
    # Time Complexity: O(sum(w)) - create a trie
    # Space Complexity: O(sum(w)) [Trie]
    class Trie:
        def __init__(self):
            self.alphabet = [None for i in range(0,26)]
            self.endWord = None
    
    def __init__(self):
        self.root = self.Trie()
    def longestWord(self, words: List[str]) -> str:
        for w in words:
            temp = self.root
            for x in w:
                i = ord(x)-ord('a')
                if(temp.alphabet[i]!=None):
                    temp = temp.alphabet[i]
                else:
                    temp.alphabet[i] = self.Trie()
                    temp = temp.alphabet[i]
            temp.endWord = w
            
        q = deque([self.root]) #    q will O(1), maximum 25 letters can be added in queue at once
        x = ""
        while(len(q)>0):
            temp = q.popleft()
            for i in range(25,-1,-1):
                if(temp.alphabet[i]!=None and temp.alphabet[i].endWord!=None):
                    q.append(temp.alphabet[i])
                    x = temp.alphabet[i].endWord
        
        return x
