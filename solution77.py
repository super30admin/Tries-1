class TrieNode:
    def __init__(self):
        self.children=[None]*26 					#This class initoializes the structure of a trie node 
        self.word=None

class Solution:
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root												#Starting from root every character of the word is checked for in the trie, if it does not exist the character
        for i in range(len(word)):										#is added onto the trie and the last node of each word has isEnd set to true
            c=word[i]
            if curr.children[ord(c) - ord("a")] == None:
                curr.children[ord(c) - ord("a")] = TrieNode()
            curr = curr.children[ord(c) - ord("a")]
        curr.word=word        
        
    def longestWord(self, words: List[str]) -> str:
        self.root=TrieNode()
        for word in words:
            self.insert(word)
        d=deque()
        curr=self.root
        d.append(self.root)
        while d:
            curr=d.popleft()
            for i in range(25,-1,-1):
                if curr.children[i]!=None and curr.children[i].word!=None:
                    d.append(curr.children[i])
        return curr.word
                    