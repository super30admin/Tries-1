#720. Longest word in dictionary
"""
Time Copmlexity : O(N * L)
Space Complexity : O(N * L) N = number of words L = length of longest word

While searching for word, we check number of isEnd == True it encounters. If it is equal to len(word) that means that that word is longest word since, all of its prefix are present in trie(counr of isEnd == len(word)).

After getting such word, we check if it is of mex lenght among words of input or not.
"""
class TrieNode:
    isEnd = False
    children = []
    
    def __init__(self):
        self.isEnd = False
        self.children = [None]*26
    
    
class Trie:
    max_word = "" #class global variable string to override the word of greater len if found later
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        
        for i in range(0, len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            

            if curr.children[pos] == None:
                curr.children[pos] = TrieNode()
                
            curr = curr.children[pos]
        
        curr.isEnd = True
    
    def search(self, word: str):
        curr = self.root
        len_count = 0
        for i in range(0, len(word)):
            ch = word[i]
            pos = ord(ch) - ord('a')
            
            if curr.children[pos] == None:
                return None
                
            curr = curr.children[pos]
            if curr.isEnd == True: #checking count of isEnd so taht it can be compared with len(word)
                len_count += 1
            
        if len_count == len(word) and len(word) > len(self.max_word):
            self.max_word = word

    """
    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for i in range(0, len(prefix)):
            ch = prefix[i]
            pos = ord(ch) - ord('a')
            
            if curr.children[pos] == None:
                return False
                
            curr = curr.children[pos]
        
        return True
    """
    
class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort() #Tc = n log(n)
        """
        Words are sorted in begining becuase we want them in lexicographical order.
        As above condition in search() check only for new_word > current_max_word, we need not need to concern about
        lexicographical order
        """
        #print(words)
        tr = Trie()
        for i in words: #Tc = n * L
            tr.insert(i)
        
        for i in words: #TC n * L
            tr.search(i)
        
        return (tr.max_word)
