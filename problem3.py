# Time Complexity:
# Trie Insertion: O(N * L)  N :no of words in the dictionary, L:average length of the words
# find_shortest_prefix: O(P) P :average length of the words
# replaceWords: O(S * P) S: no of words in sentence

# Space Complexity:
# Trie: O(N * L)
# replaceWords: O(S * P)
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

    def find_shortest_prefix(self, word: str) -> str:
        node = self.root
        prefix = ''
        for char in word:
            if char not in node.children:
                break
            prefix += char
            node = node.children[char]
            if node.is_end_of_word:
                return prefix
        return word


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert(word)

        words = sentence.split()
        for i, word in enumerate(words):
            words[i] = trie.find_shortest_prefix(word)

        return ' '.join(words)
