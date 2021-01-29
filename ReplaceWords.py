'''
    Time Complexity:
        O(l + n)
        (where l = number of characters in the dictionary
        and, n = length of the sentence)

    Space Complexity:
        O(l + n)
        (to store the dictionary as a Trie
        and, to split the sentence and keep it as an array of words)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Add all the words of the dictionary to a Trie.
        Split the given sentence by space character and for each word:
            -> find the longest suffix in the Trie.
            -> If the suffix is empty, add the word itself to the output array.
            -> Else, add the suffix.
        Join the words of the resultant array with space between every two words.
'''

class Solution:
    def __init__(self):
        self.trie = Trie()
        self.op = []


    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.build_trie(dictionary)
        self.build_op(sentence)

        return ' '.join(self.op)


    def build_trie(self, dictionary):
        for word in dictionary:
            self.trie.insert(word)


    def build_op(self, sentence):
        for word in sentence.split(' '):
            succ = self.trie.find_successor(word)

            if succ:
                self.op.append(succ)
            else:
                self.op.append(word)


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


    def find_successor(self, word):
        curr = self.root

        for char in word:
            loc = Trie.child_loc(char)

            if curr.word or not curr.children[loc]:
                break

            curr = curr.children[loc]

        return curr.word


    @staticmethod
    def child_loc(char):
        return ord(char) - ord('a')
