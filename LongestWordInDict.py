'''
    Time Complexity:
        O(l) (where l = number of characters in the words list)

    Space Complexity:
        O(l) (where l = number of characters in the words list)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Trie + BFS
        -> Put all the words in a Trie
        -> Traverse the trie in BFS manner (from last child to first, i.e z -> a)
        -> If a TrieNode child is not none and has a word associated to it, then
            this can be our potential result.
        -> Going from right to left ensures processing of the lexicographically
            smallest word in the end. 

'''

class Solution:
    def __init__(self):
        self.trie = Trie()


    def longestWord(self, words: List[str]) -> str:
        self.build_trie(words)
        return self.get_desired_word()


    def build_trie(self, words):
        for word in words:
            self.trie.insert(word)


    def get_desired_word(self):
        q = collections.deque()
        curr = self.trie.root
        q.append(curr)

        while q:
            curr = q.popleft()

            for i in range(len(curr.children) - 1, -1, -1):
                child = curr.children[i]

                if child and child.word:
                    q.append(child)

        return curr.word


class TrieNode:
    def __init__(self, char):
        self.char = char
        self.children = [None] * 26
        self.word = None


class Trie:
    def __init__(self):
        self.root = TrieNode('/')


    def insert(self, word: str) -> None:
        curr = self.root

        for char in word:
            loc = Trie.child_loc(char)

            if not curr.children[loc]:
                curr.children[loc] = TrieNode(char)

            curr = curr.children[loc]

        curr.word = word


    @staticmethod
    def child_loc(char):
        return ord(char) - ord('a')
