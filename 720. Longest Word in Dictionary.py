#Time Complexity:O(n+m(average size of the word))
#Space Complexity:O(1)

class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.word=False
class Solution(object):    
    def __init__(self):
        self.root=TrieNode()

    def insert(self,word,root):
        for char in word:
            x=ord(char)-ord('a')
            if root.children[x]==None:
                root.children[x]=TrieNode()
            root=root.children[x]
        root.word=word

    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        dq=collections.deque()
        root=self.root
        for word in words:
            self.insert(word,root)
        dq.append(root)
        while dq:
            curr=dq.popleft()
            for i in range(25,-1,-1):
                if curr.children[i]!=None and curr.children[i].word!=False:
                    dq.append(curr.children[i])
        if curr.word==False:
            return ""
        return curr.word

        
    
                
        