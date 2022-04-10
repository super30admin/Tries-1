# Time Complexity : O(summation of word square)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False
        self.word = ''
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self,word):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.isWord = True
        node.word = word
        
    def find_prefix(self, word):
        node = self.root
        prefix = ''
        for i in word:
            prefix += i
            if i not in node.children:
                return word
            else:
                if node.children[i].word:
                    return prefix
                else:
                    node = node.children[i]
        return word
        
class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        tire = Trie()
        for i in dictionary:
            tire.insert(i)

        words=[]
        for i in sentence.split():
            words.append(tire.find_prefix(i))
        return ' '.join(words)