#Problem2: Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)
# Time complexity: O(N * L),N is the number of words and L is the average length of a word
# Inserting all words into the Trie takes O(N * L) since we go through every character of every word
# The DFS also visits each Trie node once and there are at most O(N * L) nodes total, so DFS also takes O(N * L)

# Space complexity: O(N * L), The Trie stores up to O(N * L) nodes in the worst case, one node per character inserted
# The path list and recursion stack can grow up to the length of the longest word, which is at most L
# Approach:
# We first insert all words into a Trie, marking the end of each real word using isEnd
# Then we do a DFS starting from the root, but we only step into a child if that child is the end of a real word
# This way, any string we build during the DFS is guaranteed to be buildable one character at a time using other words in the list
# We check letters from a to z in order and we only update our answer when we find a strictly longer path
# This means if there is a tie in length, the word that comes first alphabetically is the one that gets kept, since the later tie will not be strictly longer

class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26   # one slot for each letter a to z, starts empty
            self.isEnd = False            # marks whether a real word ends exactly at this node
        
    def __init__(self):
        self.root = self.TrieNode()   # the root node represents an empty string, the starting point
        self.result = ""              # this will store the best answer found so far
    
    def insert(self, word):
        current = self.root                     # start walking from the root for every new word
        for char in word:                       # go through the word one character at a time
            index = ord(char) - ord('a')         # convert the character into a number from 0 to 25
            if current.children[index] is None:  # if this letter path does not exist yet
                current.children[index] = self.TrieNode()   # create a new node for this letter
            current = current.children[index]    # move down into that letter's node
        current.isEnd = True   # after placing all letters, mark the last node as a complete word
    
    def longestWord(self, words: List[str]) -> str:
        for word in words:
            self.insert(word)     # insert every word into the Trie first
        self.dfs(self.root, [])   # then explore the Trie starting from the root with an empty path
        return self.result        # return whatever ended up being the best answer found
    
    def dfs(self, node, path):
        if len(self.result) < len(path):   # check if the current path is strictly longer than our saved answer
            self.result = "".join(path)    # if it is, save this path as the new best answer
        
        for index in range(26):   # check every possible next letter from a to z
            if node.children[index] is not None and node.children[index].isEnd:
                # only step into this letter if it exists and it completes a real word

                le = len(path)   # remember the current length of path so we can undo later

                path.append(chr(index + ord('a')))   # add the new letter to our path

                self.dfs(node.children[index], path)   # recurse deeper using this new letter

                path = path[:le]   # backtrack by cutting path back to its length before this letter was added
