'''
    Time Complexity:
        Each operation is O(l) (l = length of the word)

    Space Complexity:
        Insertion would use O(l) (l = length of the word) in the worst case.
        All the rest of the operations use O(1) space.

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Explanation
'''

class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = [None] * 26
        self.is_leaf = False


class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode('/')


    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root

        for char in word:
            loc = Trie.child_loc(char)

            if not curr.children[loc]:
                curr.children[loc] = TrieNode(char)

            curr = curr.children[loc]

        curr.is_leaf = True


    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root

        for char in word:
            loc = Trie.child_loc(char)

            if not curr.children[loc]:
                return False

            curr = curr.children[loc]

        return curr.is_leaf



    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root

        for char in prefix:
            loc = Trie.child_loc(char)

            if not curr.children[loc]:
                return False

            curr = curr.children[loc]

        return True


    @staticmethod
    def child_loc(char):
        return ord(char) - ord('a')



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
