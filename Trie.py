# Time Complexity : O(L); L --> length of the word
# Space Complexity : O(L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.flag = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        temp = self.root
        for i in range(len(word)):
            if not temp.children[ord(word[i]) - ord('a')]:
                temp.children[ord(word[i]) - ord('a')] = TrieNode()
            temp = temp.children[ord(word[i]) - ord('a')]
        temp.flag = True

    def search(self, word: str) -> bool:
        temp = self.root
        for i in range(len(word)):
            if not temp.children[ord(word[i]) - ord('a')]:
                return False
            temp = temp.children[ord(word[i]) - ord('a')]
        if not temp.flag:
            return False
        return True

    def startsWith(self, prefix: str) -> bool:
        temp = self.root
        for i in range(len(prefix)):
            if not temp.children[ord(prefix[i]) - ord('a')]:
                return False
            temp = temp.children[ord(prefix[i]) - ord('a')]
        return True


check = Trie()
check.insert('apple')
print(check.search('apple'))
print(check.startsWith('apps'))
