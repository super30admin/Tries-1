
class Trie:
    def __init__(self):
        self.arr = [None for _ in range(26)]
        self.end = False
        self.val = None
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        main = Trie()
        for i in dictionary:
            curr =main
            for j in i:
                val = ord(j)-97
                if(curr.arr[val]==None):
                    curr.arr[val] = Trie()
                curr = curr.arr[val]
            curr.end = True
            curr.val = i
        sentence = sentence.split(" ")
        
        for i,v in enumerate(sentence):
            curr = main
            flag = False
            for j in v:
                val = ord(j)-97
                if curr.end:
                    flag = True
                    break
                if(curr.arr[val]==None):
                    break
                curr = curr.arr[val]
            if(flag and curr.end):
                sentence[i] = curr.val
        return ( " ".join(sentence))
                
                