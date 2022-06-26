class Cell:
    def __init__(self):
        self.arr = [None for _ in range(26)]
        self.end = False
        self.val = ""
class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.trie = Cell()
        
        for i in words:
            curr = self.trie
            for j in i:
                val = 97-ord(j)
                if(curr.arr[val]==None):
                    curr.arr[val] = Cell()
                curr.arr[val].val = curr.val +j
                curr = curr.arr[val]
            curr.end = True
        queue = []
        for i in self.trie.arr:
            if(i!=None):
                queue.append(i)
        ans  = ""
        while(len(queue)!=0):
            curr = queue.pop(0)
            if(len(curr.val)>=len(ans)):
                ans = curr.val
            if(curr.end):
                for i in curr.arr:
                    if(i!=None and i.end):
                        queue.append(i)
        return ans