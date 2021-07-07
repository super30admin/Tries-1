class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.child = [0 for i in range(26)]

class Solution:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for i in range(len(word)):
            if not curr.child[ord(word[i]) - ord('a')]:
                curr.child[ord(word[i]) - ord('a')] = TrieNode()
            curr = curr.child[ord(word[i]) - ord('a')]
        curr.isEnd = True
    
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # self.rootNode = Trie()
        sentArray = sentence.split()
        result = []
        for word in dictionary:
            self.insert(word)
        
        for word in sentArray:
            start = self.root
            replacementString =""
            for i in range(len(word)):
                if not start.child[ord(word[i])-ord("a")] or start.isEnd:
                    break
                start = start.child[ord(word[i])-ord("a")] 
                replacementString += word[i]
            
            if start.isEnd:
                result.append(replacementString)
                
            else:
                result.append(word)
        
        return " ".join(result)
            
#Time complexity O(n*k) + O(L) where n is the number of n is the number of items in dictionary, k is avg word length in dictionary and L is the size of sentence string
#Space complexity is O(nk) for Trie construction and O(L) for storing the words after splitting the sentence string