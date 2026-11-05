'''
720 Longest Word In Dictionary
https://leetcode.com/problems/longest-word-in-dictionary/description/

Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end of a previous word.

Example 1:
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

Constraints:
1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.

Solution:
1. DFS + Backtrack:
Insert all the words into a Trie so we can easily explore valid prefixes. For the root node in the trie, check if its child node has isEOS = True (this means prefix is a valid word in the wordlist). If yes, add it to the path and recurse on that child node. The base condition is when a child does not exist (we have reached the end of the Trie).

Let N = total no. of words in the wordlist, W = average length of words in the wordlist
Time: O(NW), Space: O(NW)

2. BFS:
Insert all the words into a Trie so we can easily explore valid prefixes. Enque the root node of the trie. Pop the queue and check if the popped element has a child node that has isEOS = True (this means prefix is a valid word in the wordlist). If yes, add it to the queue.
https://youtu.be/yIY-cPhVGIo?t=2509

Time: O(NW), Space: O(NW)

'''
from collections import deque
from trie import *

def longestWord_dfs(words):
    def dfs(root, path):
        nonlocal result
        if len(result) < len(path):
            result = "".join(path)

        for index, curr in enumerate(root.children):
            if curr is None:
                continue
            if not curr.isEOS:
                return
            ch = chr(ord('a') + index)
            path.append(ch)
            dfs(curr, path)
            path.pop()

    t = Trie()
    for word in words: # O(N)
        t.insert(word) # O(W)

    result = ""
    path = []
    dfs(t.root, path)
    return result, t


def longestWord_bfs(words):
    def bfs(root):
        nonlocal result
        q = deque()
        s = ""
        curr = (root, s)
        q.append(curr)
        while q:
            this, s = q.popleft()
            for index, child in enumerate(this.children):
                if child is None or not child.isEOS:
                    continue
                ch = chr(ord('a') + index)
                new_string = s + ch
                if len(result) < len(new_string):
                    result = new_string
                q.append((child, new_string))


    # Build a Trie from the list of words present in the wordlist
    t = Trie()
    for w in words: # O(NW)
        t.insert(w)

    result = ""
    bfs(t.root)
    return result, t

def run_tests():
    tests = [(["w","wo","wor","worl","world"], "world"),
             (["a","ba", "banana","app","appl","ap","apply","apple"], "apple"),
             (["w","wo","wor","worl","world", "a","ba", "banana","app","appl","ap","apply","apple"], "apple"),
    ]
    for test in tests:
        words, ans = test[0], test[1]
        print(f"\nWords = {words}")
        for method in ['bfs', 'dfs']:
            if method == "dfs":
                result, trie = longestWord_dfs(words)
            elif method == "bfs":
                result, trie = longestWord_bfs(words)
            trie.root.pprint()
            print(f"{method}: Result = {result}")
            passed = (ans == result)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}\n")
    print(f"\nDONE")

run_tests()
