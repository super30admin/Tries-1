class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.isend = False
    
class Solution:
    def __init__(self):
        self.trie = TrieNode()
    
    def insertWord(self,word) -> None:
        # TC : O(nl) n-> no of words, l: l charecters
        # SC : O(nl)
        cur = self.trie
        for ch in word:
            i = ord(ch)-ord('a')
            if cur.children[i] == None:
                cur.children[i] = TrieNode()
            cur = cur.children[i]
        cur.isend = True
    
    def replaceWord(self,word) -> str:
        # TC : O(l)
        res = ''
        cur = self.trie
        for ch in word:
            i = ord(ch)-ord('a')
            if cur.children[i] == None or cur.isend == True:
                break
            res += ch
            cur = cur.children[i]
        if cur.isend:
            return res
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if sentence is None or len(sentence) == 0:
            return sentence
        for word in dictionary:
            self.insertWord(word)
        slist = list(sentence.split(" "))
        for j in range(len(slist)):
            word = slist[j]
            cur = self.trie
            i = ord(word[0]) - ord('a')
            if cur.children[i] != None:
                word = self.replaceWord(word)
                slist[j] = word
        return " ".join(slist)


        