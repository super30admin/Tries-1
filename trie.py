"""
Approach: Use TrieNode class with children being list of TrieNodes of size 26. We can use `ord()` function to get 
ascii value of a character and deduct ord('a') from it to find location in the array to add trie node. If an index
i is not None means that character is present at that level. 
Usage: Autocompleter, Spell checker, IP Routing(Longest prefix matching), T9 Predictive Text, Solving Word Games.

Complexity Analysis: As this is a data structure, we do analysis for each of the operation user can perform on it
TC 
Insertion O(n) where n is len of the key to be inserted
Search O(n) we search character by character and at most performn operations
SC
Insertion O(n)
Search O(1)
"""

class TrieNode:
    def __init__(self):
        self.children = [None] * 26  # assuming 26 characters only in lower case
        self.is_end = False

    def __str__(self):
        return ' '.join([str(self.is_end), str(self.children)])

class Trie:

    def __init__(self):
        self.root = TrieNode()  # new TrieNode with is_end False and children is list of 26 None values

    def insert(self, word: str) -> None:
        curr = self.root  # start at root
        for char in word: # iterate over word, char-by-char
            idx = ord(char) - ord('a')  # get index for curr char in 0-25 using ascii values
            if curr.children[idx] == None:  # if curr.children[idx] == None, we don't have that char in list
                curr.children[idx] = TrieNode()  # so add that char by using new TrieNode
            curr = curr.children[idx]  # move the curr to next node
        # at the end, when we come out of the loop - whatever the last node is, will be marked as end of the string/word
        curr.is_end = True

    def search(self, word: str) -> bool:
        curr = self.root  # start at root
        for char in word:
            idx = ord(char) - ord('a') # get idx
            # if root's children don't have value at idx, we can't find the word, return False
            if curr.children[idx] == None: return False
            # else move curr to next char, by getting node using char.children[idx]
            curr = curr.children[idx]
        return curr.is_end # if is_end is set, word is found else not

    def startsWith(self, prefix: str) -> bool:
        curr = self.root  # same as search but don't care about is_end
        for char in prefix:
            idx = ord(char) - ord('a')
            if curr.children[idx] == None: return False
            curr = curr.children[idx]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)