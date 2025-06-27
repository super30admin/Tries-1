# Time Complexity: O(N + M)
# Space Complexity: O(N)

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = TrieNode()
        for word in dictionary:
            node = root
            for char in word:
                if char not in node.children:
                    node.children[char] = TrieNode()
                node = node.children[char]
            node.is_word = True

        words = sentence.split()
        for i, word in enumerate(words):
            node = root
            for j, char in enumerate(word):
                if char not in node.children:
                    break
                node = node.children[char]
                if node.is_word:
                    words[i] = word[:j+1]
                    break

        return ' '.join(words)
