# Time Complexity : O(n)
# space complexity : O(nk), where n is the no of words and k is the avg length of the string

# Approach :

# create a trienode class
# for insert keep insert it in a psotion word[i] - "a", finally when the insert is complete make isend == true
#  for search keep going till word[i] - "a" exists, else return false. Also if the for loop ends finally return back isEnd
#  for startsWith we just need to check till the length ends else return false

class TrieNode:

    def __init__(self):
        self.isEnd = False
        self.children = [0 for i in range(26)]


class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:

        current = self.root

        for i in range(len(word)):

            if not current.children[ord(word[i]) - ord('a')]:
                current.children[ord(word[i]) - ord('a')] = TrieNode()
            current = current.children[ord(word[i]) - ord('a')]

        current.isEnd = True

    def search(self, word: str) -> bool:

        current = self.root

        for i in range(len(word)):

            if not current.children[ord(word[i]) - ord('a')]:
                return False

            current = current.children[ord(word[i]) - ord('a')]

        return current.isEnd

    def startsWith(self, prefix: str) -> bool:

        current = self.root

        for i in range(len(prefix)):

            if not current.children[ord(prefix[i]) - ord('a')]:
                return False
            current = current.children[ord(prefix[i]) - ord('a')]

        return True
