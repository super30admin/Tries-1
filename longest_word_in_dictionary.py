class TrieNode:
    def __init__(self) -> None:
        self.children = [None]*26
        self.word = ''

class Solution:
    def __init__(self) -> None:
        self.root = TrieNode()

    def insert_trie(self, word):
        curr = self.root 
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if curr.children[idx] == None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        
        curr.word = word

    def longestWord(self, words: List[str]) -> str:
        ## T.C = O(n.l)
        ## S.C = O(n.l)
        for word in words:
            self.insert_trie(word)
        
        queue = [self.root]
        
        while queue:
            curr = queue.pop(0)
            for i in range(25, -1, -1):
                if curr.children[i] is not None and curr.children[i].word != '':
                    queue.append(curr.children[i])
                    
        return curr.word



