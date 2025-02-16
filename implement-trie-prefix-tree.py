"""

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
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


Time Complexity:
- insert(word): O(n), where n is the length of the word (each character is processed once).
- search(word): O(n), where n is the length of the word (traverse through characters).
- startsWith(prefix): O(n), where n is the length of the prefix (similar traversal as search).

Space Complexity:
- insert(word): O(n), in the worst case where no prefixes are shared, creating new TrieNodes for each character.
- search(word) and startsWith(prefix): O(1), as they do not store additional data beyond traversal.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# This Trie implementation supports insert, search, and prefix search operations using a tree-like structure. 
# Each TrieNode stores its children in a dictionary and tracks whether it marks the end of a word. 
# The insert operation constructs paths for words, search checks for exact word matches, and startsWith verifies prefix existence.


class TrieNode:
    def __init__(self):
        self.children = {}
        self.endofword = False


class Trie:

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        cur = self.root

        for ch in word:
            if ch not in cur.children:
                cur.children[ch] = TrieNode()

            cur = cur.children[ch]

        cur.endofword = True
        

    def search(self, word: str) -> bool:

        cur = self.root

        for ch in word:
            if ch not in cur.children:
                return False

            cur = cur.children[ch]

        return cur.endofword
        

    def startsWith(self, prefix: str) -> bool:

        cur = self.root

        for ch in prefix:
            if ch not in cur.children:
                return False

            cur = cur.children[ch]

        return True
        

