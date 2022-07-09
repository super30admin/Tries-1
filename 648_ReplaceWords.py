"""
Leetcode-https://leetcode.com/problems/flatten-nested-list-iterator/
TC- O(N), SC- O(N), N is length of sentence.
Challenges- Doing the trie traversal
Lecture-https://www.youtube.com/watch?v=C8VRMbEgOqc
FAQ-


In English, we have a concept called root, which can be followed by some other word to form another longer word - let's
call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new
word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the
successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it
with the root that has the shortest length.

Return the sentence after the replacement.


Example 1:
Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 2:
Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"


Constraints:
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.
"""


class TrieNode():
    def __init__(self):
        self.val = None
        self.children = [None] * 26
        self.isEnd = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for char in word:
            ci = ord(char) - ord('a')
            if curr.children[ci] is None:
                curr.children[ci] = TrieNode()
                curr.children[ci].val = char
            curr = curr.children[ci]

        curr.isEnd = True

class Solution:
    """
    Ideation- Trie implementation,
    TC- O(4N), where N is size of sentence. O(N) for sentence split, O(N) for creating a trie, and O(N) for searching through that trie for each
    character, and O(N) for join.
    SC- O(N), array for split

    Step1: Put words in dictionary in a trie
    Step2: for each word in sentence traverse through trie and see if any prefix exists. If it does, substitute the
    word with that prefix, else, keep the original word.

    Do check for isEnd and stop when you're looking for prefix. This make sure that the smallest prefix is picked
    """
    def replaceWords(self, dictionary, sentence: str) -> str:
        sentenceList = sentence.split(" ")
        trie = self.implementTrie(dictionary)

        for i in range(len(sentenceList)):
            replacement = ''
            curr = trie.root
            for char in sentenceList[i]:
                ci = ord(char) - ord('a')
                # if you have reached the end of the prefix wod in trie or if we already found a prefix (isEnd = True),
                # stop looking
                if curr.children[ci] is None or curr.isEnd:
                    break
                # add that character to the replacement
                replacement += char
                curr = curr.children[ci]

            # If prefix found is not a complete prefix in trie, we can't use that as our replacement since it's not
            # really a prefix. If it's a complete prefix, use it as replacement.
            if curr.isEnd:
                sentenceList[i] = replacement

        return " ".join(sentenceList)

        # implement trie with given words
    def implementTrie(self, words):
        trie = Trie()
        for word in words:
            trie.insert(word)
        return trie

    """
    Ideation- Brute Force
    For each word in the sentence, we'll look at successive prefixes and see if we saw them before.

    Algorithm
    Store all the roots in a Set structure. Then for each word, look at successive prefixes of that word. If you find a 
    prefix that is a root, replace the word with that prefix. Otherwise, the prefix will just be the word itself, and 
    we should add that to the final sentence answer.
    """

    def replaceWords1(self, roots, sentence):
        rootset = set(roots)

        def replace(word):
            for i in range(1, len(word)):
                if word[:i] in rootset:
                    return word[:i]
            return word

        return " ".join(map(replace, sentence.split()))