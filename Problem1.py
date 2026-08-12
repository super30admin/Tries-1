# Problem1: Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)
# Time Complexity: insert is O(L), search is O(L), startsWith is O(L)
# L is the length of the word or prefix being processed,each operation walks through the characters one time only
# Space Complexity:O(N * L) where N is number of words inserted and L is average word length,this is the worst case when words do not share prefixes with each other
# Approach
# each node holds a fixed size array of 26 slots, one for each lowercase letter to insert a word we walk character by character, creating new nodes only when a path does not already exist to search or check a prefix we walk the same way but never create nodes, we just check if the path exists
# search also checks isEnd because a path existing does not mean a full word was inserted there
# startsWith does not check isEnd because it only cares that the path exists

class Trie:
    class TrieNode:
        def __init__(self):
            # children holds 26 slots, one for each letter a to z
            # each slot starts as None meaning no child exists yet for that letter
            self.children = [None] * 26
            # isEnd tells us if a complete word ends exactly at this node
            self.isEnd = False

    def __init__(self):
        # root does not represent any letter, it is just the starting point
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        # current is a pointer that tracks where we are in the tree as we walk
        current = self.root
        for char in word:
            # convert the letter into a number from 0 to 25
            # this tells us exactly which slot in children to use
            index = ord(char) - ord('a')
            # if no node exists yet for this letter, create one
            if current.children[index] is None:
                current.children[index] = self.TrieNode()
            # move current forward into the child node
            current = current.children[index]
        # after placing all letters, mark the last node as the end of a word
        current.isEnd = True

    def search(self, word: str) -> bool:
        current = self.root
        for char in word:
            index = ord(char) - ord('a')
            # if the path does not exist, the word was never inserted
            if current.children[index] is None:
                return False
            # move current forward, we only reach here if the child exists
            current = current.children[index]
        # the path existing is not enough, we need isEnd to be True
        # this is because the path for "app" also exists after inserting "apple"
        # but "app" itself was never marked as a complete word
        return current.isEnd

    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for char in prefix:
            index = ord(char) - ord('a')
            # if the path does not exist, no word starts with this prefix
            if current.children[index] is None:
                return False
            current = current.children[index]
        # unlike search we do not check isEnd here
        # we only care that the path for the prefix exists, not that a full word ends there
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)