# Approach: Insert words to trie node and iterate from last child while adding current node to queue. 
# Continue adding nodes to queue as long as it is found in the trie nodes' children and as long as the children has a word associated with it

# Time - O(MN)
# Space - O(MN)
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.word = None


class Solution:
    def insert(self, word):
        current = self.root
        for char in (word):
            if current.children[ord(char) - ord('a')] == None:
                current.children[ord(char) - ord('a')] = TrieNode()
                
            current = current.children[ord(char) - ord('a')]
        
        current.word = word

    def longestWord(self, words: List[str]) -> str:

        if not words or len(words) == 0:
            return ""

        self.root  = TrieNode()

        for word in words:
            # build the trie with dict words
            self.insert(word)

        queue = collections.deque()
        current = self.root
        queue.append(self.root)

        while queue:
            current = queue.popleft()
            for i in range(25, -1, -1):
                if current.children[i] != None and current.children[i].word != None:
                    queue.append(current.children[i])

        if current is None:
            return ""

        return current.word