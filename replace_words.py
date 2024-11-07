class TrieNode:
    def __init__(self):
        self.isend = False
        self.children = [None] * 26


class Solution:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:  # O(l)
        curr = self.root
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] is None:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.isend = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        split_arr = sentence.split(" ")

        result = []
        for word in split_arr:
            result.append(self.get_shortest_version(word))
        return " ".join(result)

    def get_shortest_version(self, word):
        curr = self.root
        sb = []
        for c in word:
            i = ord(c) - ord("a")
            if curr.children[i] is None or curr.isend:
                break

            curr = curr.children[i]
            sb.append(c)
        if curr.isend:
            return "".join(sb)
        return word


# Time complexity: O(n * L + S) where n is the number of words,L is maximum word length and , S is the total length of the sentence
# Space complexity: O(n * L + m) where m is the number of words in the sentence
