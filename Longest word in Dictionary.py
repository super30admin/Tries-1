# Time Complexity: O(n) n is sum of all len of words
# Space Complexity: O(n)
class Trie:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isword = False


class Solution:
    def longestWord(self, words: List[str]) -> str:
        head = Trie()
        # print(trie.children)
        # print(x+= ord(i) for i in 'ewqz' )
        # print(ord("yodn"))

        # Inserting all words in words array in the Trie
        for word in words:
            curr = head
            for char in range(len(word)):
                if curr.children[ord(word[char]) - ord('a')] == None:
                    curr.children[ord(word[char]) - ord('a')] = Trie()
                curr = curr.children[ord(word[char]) - ord('a')]
            curr.isword = True

        # print(head.children)
        # Checking for the longest word in the trie
        curr = head
        global longest
        longest = ''

        def dfs_backtrack(root, string):
            global longest
            # Base Case
            if len(string) > len(longest):
                longest = string
            # Logic
            for i in range(26):
                if root.children[i] != None and root.children[i].isword == True:
                    # action
                    string += chr(97 + i)
                    # recurse
                    dfs_backtrack(root.children[i], string)
                    # Backtrack
                    # print(string)
                    # print(root.isword)
                    string = string[:-1]

        dfs_backtrack(curr, '')
        return longest
