class TrieNode:

    def __init__(self) -> None:
        self.children = [None]*26
        self.is_end = False

class Solution:
    
    def __init__(self) -> None:
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.is_end = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        ## T.C = O(n.l) + O(n.k)
        ## S.C = O(n.l) + O(n.k)
        for word in dictionary:
            self.insert(word)
        
        res = []
        word_list = sentence.split(' ')
        
        for word in word_list:
            curr = self.root
            tmp = ''
            for i in range(len(word)):
                idx = ord(word[i]) - ord('a')
                if curr.children[idx] == None or curr.is_end:
                    break
                tmp += word[i]
                curr = curr.children[idx]
            

            if curr.is_end:
                res.append(tmp)
            else:
                res.append(word)
        
        return ' '.join(res)









