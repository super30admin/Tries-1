# Time Complexity : O(n)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -
class Solution(object):
    def __init__(self):
        self.root = TrieNode()
    def replaceWords(self, dictionary, sentence):#TC: m*l
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        for word in dictionary:
            self.insert(word)

        sentenceList = sentence.split(' ')
        strArr = []
        result = ' '
        for word in sentenceList:
            node = self.root
            replacement=''
            for char in word:
                if node.children[ord(char) - ord('a')] == None or node.isEnd :
                    break
                replacement+=(char)
                node = node.children[ord(char) - ord('a')]
            

            if node.isEnd:
                strArr.append(replacement)
                
            else:
                strArr.append(word)
        return result.join(strArr)
    
    
    def insert(self, word):
        node = self.root
        for char in word:
            if node.children[ord(char) - ord('a')] is None:
                node.children[ord(char) - ord('a')] = TrieNode()
            node = node.children[ord(char) - ord('a')]
        node.isEnd = True
    
class TrieNode:
    def __init__(self):
        self.children = [None for _ in range(26)]
        self.isEnd = False