#T.C = O(N*l) + O(m*l) S.C = T.C = O(N*l) + O(m*l)
class Solution(object):
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None] * 26

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self,word):
        curr = self.root
        for c in word:
            if(curr.children[ord(c) - ord('a')]) == None:
                curr.children[ord(c) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        self.root = self.TrieNode()
        for word in dictionary:
            self.insert(word)
        
        sb = []
        splitArr = sentence.split(" ")
        for i in splitArr:
            if i:
                if sb:
                    sb.append(" ")
                sb.append(self.getShortestPath(i))
        return ''.join(sb)

    def getShortestPath(self,word):
        curr = self.root
        sb = []
        for c in word:
            if(curr.children[ord(c) - ord('a')] == None or curr.isEnd):
                break
            curr = curr.children[ord(c) - ord('a')]
            sb.append(c)
        
        if(curr.isEnd):
            return ''.join(sb)
        else:
            return word

        