"""
Time complexity insert + To find logestword->O(n.l)+o(n.L) SO O(N*l)
where N is no of words and L is avg length

Space complexity - O(Nl) -->all words inside queue in WC 


"""
class TrieNode:
    def __init__(self):
       
        self.children =[None]*26
        self.word=None

class Solution_longest:
 
    def insert(self, word):
        curr = self.root
        for c in word:
            a=ord(c)-ord('a')
            #print(a,c)
            if curr.children[a] is None:
                curr.children[a]=TrieNode()
                #print(a,curr.children[a])
                #print(curr.children[a])
            curr=curr.children[a] 
        curr.word=word
        #print(word,curr.word)
        
        
    def longestWord(self, words: List[str]) -> str:
        self.root=TrieNode()
        for word in words:
            self.insert(word)
        q=[]
        q.append(self.root)
        while q:
            curr=q.pop(0)
            print(curr.children)
            for j in range(25,-1,-1):
                if curr.children[j] and curr.children[j].word:
                    q.append(curr.children[j])
        
        return curr.word
 