"""
Leetcode-https://leetcode.com/problems/implement-trie-prefix-tree/ (submitted)
TC- , SC- *Refer ideation below*
Challenges-NA
Lecture-https://www.youtube.com/watch?v=C8VRMbEgOqc
FAQ-Why can't you combine two branches of words in Trie sharing same suffix? Because when we hit the isEnd flag True,
we can't tell for which of the two words ended. So, we shall keep them separate


A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a
dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:
Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false
otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix
prefix, and false otherwise.


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
"""


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Trie:
    """
    Ideation-Iterative
    The idea is each node in Trie could be either of a-z characters that have its own Trie. To do so, we create Trie
    node object with its children list hashed by its ascii - ascii(a) so the lookup for a certain character is easy.
    That children[i] will have its own Trie node and children. If the child does not exists at a hash value index,
    that means that character is not the child and will have None value.s

    Insert - To insert a word, first traverse trie to find any prefix available and append the remaining string after
    that. TC- O(N) , SC- O(1) user space

    Search - Traverse the trie and see if the char path of word exists and tree and check is isEnd = True which tells
    that the complete word is in our trie. TC- O(N), SC- O(1)

    Start with- It looks for prefix in the trie, here we do the same thing as search() except here we don't need to
    check if the word is complete or not, i.e. isEnd
    """
    def __init__(self):
        self.root = TrieNode()

    # O(N)
    def insert(self, word) -> None:
        curr = self.root
        for char in word:
            # children index
            ci = ord(char) - ord('a')
            # if that char doesn't exists in Trie child, add it.
            if curr.children[ci] is None:
                curr.children[ci] = TrieNode()
            # go to next level, i.e., its children
            curr = curr.children[ci]

        # mark the end of the word of the leaf node
        curr.isEnd = True

    # TC- O(N)
    def search(self, word):
        curr = self.root
        for char in word:
            ci = ord(char) - ord('a')
            # char does not exists in Trie
            if curr.children[ci] is None:
                return False
            curr = curr.children[ci]

        # check if the end of the word is try has isEnd which signifies a complete word in Trie
        return curr.isEnd

    def startsWith(self, prefix):
        curr = self.root
        for char in prefix:
            ci = ord(char) - ord('a')
            # char does not exists in Trie
            if curr.children[ci] is None:
                return False
            curr = curr.children[ci]

        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
