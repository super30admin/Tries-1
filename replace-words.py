# Time Complexity: O(w*numOfsentences) or O(m*k)
# Space Complexity: O(w*numOfsentences)
class Node:
    def __init__(self, val):
        self.val    = val
        self.child = {}
        self.end = False

class Trie:
    def __init__(self):
        self.root = Node(None)
    
    def insert(self, word):
        root = self.root
        for ch in word:
            if ch not in root.child:
                root.child[ch] = Node(ch)
            root = root.child[ch]
        root.end = True
        
    def replace(self, word):
        root = self.root
        replace = ""
        for ch in word:
            if ch not in root.child:
                return word

            replace += ch
            root = root.child[ch]

            if root.end:
                return replace
        return word
        

class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        xx = Trie()
        for dic in dictionary:
            xx.insert(dic)  
        output = ""
        y = False
        for x in sentence.split(" "):
            if y: output += " "
            output += xx.replace(x)
            y = True
        return output