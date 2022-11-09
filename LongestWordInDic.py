class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False
        self.word = ""
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    # Time Complexity: O(len of words * avg len of word)    
    def insert(self, word: str) -> None:
        curr = self.root
        
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.end_of_word = True
        curr.word = word
        
    # Time Complexity: O(len of words * avg len of word)
    def bfs(self) -> str:
        
        queue = collections.deque()
        
        queue.append(self.root)
        result = ""
        
        while queue:
            curr = queue.popleft()
            for n in curr.children.values():
                if n.end_of_word:
                    queue.append(n)

                    if len(n.word) > len(result) or n.word < result:
                        result = n.word
                    
        return result
        
class Solution:
    def longestWord(self, words: List[str]) -> str:
        trie = Trie()
        for word in words:
            trie.insert(word)
            
        return trie.bfs()
    
    # Time Complexity: O(len of words * avg len of word) actually it will be O(2(len of words * avg len of word)) for inserting and bfs both
    # Space Complexity: O(len of words * avg len of word) because both trie and queue takes the same number of nodes