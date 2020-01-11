# Runtime - O(m*n) where m is # of words and n is length of longest word
    # Memory - O(# of words)

class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.string = None
            
    def __init__(self):
        self.root = self.TrieNode()
        
    def insert(self,word):
        node = self.root
        print("printing word",word)
        for i in word:
            if not node.children[ord(i)-ord('a')]:
                print("printing",ord(i))
                print("printing",ord(i)-ord('a'))
                node.children[ord(i)-ord('a')] = self.TrieNode()
            node = node.children[ord(i)-ord('a')]
            print(node.string)
        node.string = word
        
    def longestWord(self, words: List[str]) -> str:
        for i in words:
            # print("i is",i)
            self.insert(i)
        queue = []
        queue.append(self.root)
        
        while queue:
            size = len(queue)
            for i in range(size):
                print("i is",i)
                print("size of queue is",size)
                node = queue.pop(0)
                print("node's string at evrylevel is",node.string)
                for j in range(25,-1,-1):
                    if node.children[j] and node.children[j].string:
                        print("j is",j)
                        queue.append(node.children[j])
                    else:
                        continue
        print("final version of string is",node.string)
        print("final version of string is",node.string[0])
        return node.string
   

        
        