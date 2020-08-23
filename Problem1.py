#Time Complexity - O(L) for functions insert, search and startsWith where L is the length of input. O(n*m) for forming the Trie where n is
# the number of words and m is the longest word
#Space Complexity - O(n*m) for worst case where n is total words and m is the longest word
#Works on leetcode  - yes
#Approach - We form a Trie node by using isword rto identify a word and children sing TrieNode. Functions insert, search and startsWith start
#by iterating through the input string where insert adds the letter to the children and set isword True. While search and startsWith just return
#True or False based on if the input string is there in the Trie or not. 
class TrieNode:
    
    def __init__(self):
        self.isword = False
        self.children = collections.defaultdict(TrieNode)
        
class Trie:

    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        node = self.root
        for w in word:
            if w not in node.children:
                node.children[w] = TrieNode()
            node = node.children[w]
        node.isword = True
        
    def search(self, word: str) -> bool:
        node = self.root
        for w in word:
            if w not in node.children:
                return False
            node = node.children[w]
        return node.isword
        

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for p in prefix:
            if p not in node.children:
                return False
            node = node.children[p]
        return True