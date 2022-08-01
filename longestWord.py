# Did this code successfully run on Leetcode : Yes
class Solution:
    def longestWord(self, words: List[str]) -> str:

        class TrieNode:
            def __init__(self):
                self.children = {}
                self.endofword = False

        class Trie:
            # O(w*l) where w is the num of words and l is the length
            def __init__(self,words):

                self.root = TrieNode()
                for word in words:
                    current = self.root
                    for c in word:
                        if c in current.children:
                            current = current.children[c]
                        else:
                            current.children[c] = TrieNode()
                            current = current.children[c]
                    current.endofword = True

            # O(w) where w is the length of the word
            def check_prefix(self,word):
                current = self.root
                for w in word:
                    if w in current.children and current.children[w].endofword:
                        current = current.children[w]
                    else:
                        return False
                return True

        trie = Trie(words)
        l = collections.defaultdict(list)
        max_len = 0
        # O(n*w) where n is num of words and w is the length of the word
        for word in words:
            if trie.check_prefix(word):
                l[len(word)].append(word)
                max_len = max(max_len,len(word))
        if not l:
            return ""
        l[max_len].sort()
        return l[max_len][0]
