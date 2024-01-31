'''

Time Complexity : O(Lxn)
Space Complexity : O(Lxn)


Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Insert the dictionary words into the trie. And then look for prefix of words in trie and return the replacement if found

'''



class TrieNode:
    def __init__(self):
        self.child = {}
        self.isEnd = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self,words):
        cur = self.root
        for c in words:
            if c not in cur.child:
                cur.child[c] = TrieNode()
            cur = cur.child[c]
        cur.isEnd = True

    def replace(self,sentence):
        sentence = sentence.split()
        for i in range(len(sentence)):
            word = sentence[i]
            print(word)
            cur = self.root
            for j in range(len(word)):
                c = word[j]
                if c in cur.child:
                    cur = cur.child[c]
                    if cur.isEnd:
                        sentence[i] = word[:j+1]
                        break
                else:
                    break

        return ' '.join(sentence)


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()

        for word in dictionary:
            trie.insert(word)

        return trie.replace(sentence)








