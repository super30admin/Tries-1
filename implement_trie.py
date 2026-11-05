'''
    208 Implement Trie (Prefix Tree)
    https://leetcode.com/problems/implement-trie-prefix-tree/description/

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:
Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:
Input:
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output:
[null, null, true, false, true, null, true]
Explanation:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


Constraints:
1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

Solution:
1. Design Trie data structure using hash map
N = no. of words in Trie
W = average length of word in the Trie
                Time        Space
Trie DS:        O(W)       O(NW)
Insert word:    O(W)       O(W)
Search word:    O(W)       O(1)
StartsWith:     O(W)       O(1)

https://youtu.be/-JJCOdLilxg?t=2088
https://youtu.be/W-fdlHtwOBs?t=94

'''
from collections import defaultdict

trie_type = 2

if trie_type == 1:
    # Trie using a hash
    class TrieNode:
            def __init__(self):
                self.children = defaultdict(str) # key = data, value = TrieNode()
                self.isEOS = False

    class Trie:
        def __init__(self):
            ''' Time: O(1), Space: O(1)'''
            self.root = TrieNode()

        def insert(self, word: str) -> None:
            ''' Time: O(N), Space: O(N), N = num chars in word'''
            if not self.root:
                return None
            curr = self.root
            for c in word:
                if not curr.children[c]:
                    curr.children[c] = TrieNode()
                curr = curr.children[c]
            curr.isEOS = True

        def search(self, word: str) -> bool:
            ''' Time: O(N), Space: O(1), N = num chars in word'''
            if not self.root:
                return False
            curr = self.root
            for c in word:
                if not curr.children[c]:
                    return False
                curr = curr.children[c]
            return curr.isEOS

        def startsWith(self, prefix: str) -> bool:
            ''' Time: O(N), Space: O(1), N = num chars in word'''
            if not self.root:
                return False
            curr = self.root
            for c in prefix:
                if not curr.children[c]:
                    return False
                curr = curr.children[c]
            return True
elif trie_type == 2:
    # Trie using a list
    class TrieNode:
            def __init__(self):
                self.children = [None]*26  # list of None
                self.isEOS = False # boolean

    class Trie:
        def __init__(self):
            ''' Time: O(1), Space: O(1)'''
            self.root = TrieNode()

        def insert(self, word: str) -> None:
            ''' Time: O(W), Space: O(W), W = num chars in word'''
            if not self.root:
                return None
            curr = self.root
            for c in word:
                index = ord(c) - ord('a')
                if curr.children[index] is None:
                    curr.children[index] = TrieNode()
                curr = curr.children[index]
            curr.isEOS = True
            return None


        def search(self, word: str) -> bool:
            ''' Time: O(W), Space: O(1), W = num chars in word'''
            if not self.root:
                return None
            curr = self.root
            for c in word:
                index = ord(c) - ord('a')
                if curr.children[index] is None:
                    return False
                curr = curr.children[index]
            return curr.isEOS

        def startsWith(self, prefix: str) -> bool:
            ''' Time: O(W), Space: O(1), W = num chars in word'''
            if not self.root:
                return None
            curr = self.root
            for c in prefix:
                index = ord(c) - ord('a')
                if curr.children[index] is None:
                    return False
                curr = curr.children[index]
            return True


def run_tests():
    global trie_type
    trie_type = 1
    t = Trie()
    # Insert
    words = ["apple", "ape", "no", "not", "news", "not", "never"]
    print(f"--Insertion--")
    for word in words:
        t.insert(word)
        print(f"Inserted word = {word}")
    print(f"Done Building\n")


    # Search
    tests = [("newz", False), ("new", False), ("news", True), ("india", False)]
    print(f"-- Search --")
    for test in tests:
        word, ans = test[0], test[1]
        found = t.search(word)
        print(f"word = {word}, found = {found}")
        passed = (ans == found)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}\n")
    print(f"Done Searching\n")


    # StartsWith
    tests = [("a", True), ("ap", True), ("app", True), ("ape", True), ("appn", False)]
    print(f"-- Prefix Valid --")
    for test in tests:
        prefix, ans = test[0], test[1]
        is_prefix = t.startsWith(prefix)
        print(f"is_prefix({prefix}) = {is_prefix}")
        passed = (ans == is_prefix)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}\n")
    print(f"\nDONE")

run_tests()