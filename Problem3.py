#Time Complexity -  O(n*m) for forming the Trie where n is the number of words and m is the longest word
#Space Complexity - O(n*m) for worst case where n is total words and m is the longest word. Or O(n*n) as the max words and max words in 
# sentence can be 1000
#Works on leetcode  - yes
#Approach - We insert all words from dictionary in Trie and then iterate through the words in sentence to find the replacement. The find
#function works by checking if the letter of word is in the children, if not there's no replacement. Otherwise, if we find the prefix, we return
#that instead
class TrieNode:
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isEnd = False
        self.word = None
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self,word):
        cur = self.root
        for w in word:
            cur = cur.children[w]
        cur.isEnd = True
        cur.word = word
        
    def find(self,word):
        cur  = self.root
        for w in word:
            if w not in cur.children:
                return word
            cur = cur.children[w]
            if cur.word is not None:
                return cur.word
        return word
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        T = Trie()
        for word in dictionary:
            T.insert(word)
        return ' '.join([T.find(word) for word in sentence.split()])
        