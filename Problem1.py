"""
TC:
insert: O(L) {where L is the length of the word. We traverse the trie once for each character of the word.}
search: O(L) {where L is the length of the word. We traverse the trie once for each character of the word.}
startsWith: O(P) {where P is the length of the prefix. We traverse the trie once for each character of the prefix.}

SC: O(Total characters of all inserted words) {The space complexity is proportional to the total number of nodes created, which is at most the sum of the lengths of all inserted words times the alphabet size (26), although shared prefixes reduce this.}

Approach:

This solution implements a **Trie** (also known as a prefix tree) data structure, specialized for efficient storage and retrieval of strings based on their prefixes.

1.  **TrieNode**: A nested class `TrieNode` is defined to represent a node in the tree. Each node contains a list of 26 possible `children` (one for each lowercase English letter) initialized to `None`, and an `isEnd` boolean flag that is set to `True` if the node marks the end of a valid word.
2.  **insert**: To insert a word, we start at the root and traverse the trie character by character. For each character, we determine its index (0-25) and check the corresponding child pointer. If the child doesn't exist, a new `TrieNode` is created. We then move to the child node and continue until the word is exhausted. Finally, the `isEnd` flag of the last node is set to `True`.
3.  **search**: To search for a complete word, we follow the same traversal path as `insert`. If at any point the path breaks (a child node is `None`), the word is not in the trie, and we return `False`. If the traversal completes, we return the value of the final node's `isEnd` flag to confirm if it's a complete, stored word.
4.  **startsWith**: To check for a prefix, the process is identical to `search`, but we only need to ensure the traversal path exists for every character in the prefix. If the traversal completes successfully, we return `True`, regardless of the final node's `isEnd` status.

All operations achieve a linear time complexity proportional to the length of the key being processed, making the Trie highly efficient for prefix-based searches.

The problem ran successfully on LeetCode.
"""
from typing import List
class Trie:

    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.isEnd = False

    def __init__(self):
        self.root = self.TrieNode()


    def insert(self, word: str) -> None:
        curr = self.root

        for ch in word:

            if not curr.children[ord(ch) - ord('a')]:
                curr.children[ord(ch) - ord('a')] = self.TrieNode()

            curr = curr.children[ord(ch) - ord('a')]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root

        for ch in word:
            if not curr.children[ord(ch) - ord('a')]:
                return False
            curr = curr.children[ord(ch) - ord('a')]

        return curr.isEnd

        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root

        for ch in prefix:
            if not curr.children[ord(ch) - ord('a')]:
                return False
            curr = curr.children[ord(ch) - ord('a')]
        
        return True

        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)