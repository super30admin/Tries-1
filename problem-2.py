# Time Complexity : O(n*k), where n is the number of the words and k is the average length of a word
# Space Complexity : O(n*k), where n is the number of the words and k is the average length of a word

# Approach :

# Create a trie node strcuture which stores the word as it does a bfs traversal
# While checking the longest word make sure to iterate in lexicographically reverse order
# If a at atage there is no word, the queue will become empty. In such cases return a "".x

class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [0]*26
            self.word = None

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word):
        currentNode = self.root

        for i in range(len(word)):
            charVal = word[i]
            index = ord(charVal) - ord('a')
            if not currentNode.children[index]:
                currentNode.children[index] = self.TrieNode()
            currentNode = currentNode.children[index]

        currentNode.word = word

    def longestWord(self, words: List[str]) -> str:

        if not words:
            return ""

        for word in words:
            self.insert(word)

        queueNode = deque([self.root])

        while (queueNode):
            currentNode = queueNode.popleft()
            for i in range(25, -1, -1):
                if currentNode.children[i] and currentNode.children[i].word:
                    queueNode.append(currentNode.children[i])

        if not currentNode.word:
            return ""
        return currentNode.word
