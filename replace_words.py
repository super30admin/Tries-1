# Time Complexity: O(nl) where n is number of words and l is avg length of the word
#  Space Complexity:  O(l).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = [None] *26
        self.isEnd = False
        self.ch = None

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert_word(self, word):
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch)-ord('a')] == None:
                curr.children[ord(ch)-ord('a')] = TrieNode()
            curr = curr.children[ord(ch)-ord('a')]
            curr.ch = ch
        curr.isEnd = True
    
    def find_root_word(self, word):
        curr = self.root
        res = ""
        for i in range(len(word)):
            ch = word[i]
            if curr.children[ord(ch)-ord('a')] == None:
                return word
            curr = curr.children[ord(ch)-ord('a')]
            res = res + curr.ch
            if curr.isEnd:
                return res
        return word


    


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for word in dictionary:
            trie.insert_word(word)
        
        sentence_list = sentence.split()
        res = []
        for word in sentence_list:
            res.append(trie.find_root_word(word))
        result = " "
        return result.join(res)
