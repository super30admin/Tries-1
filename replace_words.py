class Trei:
    child = {}
    root_end = False
    
    def __init__(self):
        self.child = {}
        self.root_end = False
    
    def add(self, i):
        if (i == "") or self.root_end:
            self.root_end = True
            return
        
        if not self.child.get(i[0]):
            self.child[i[0]] = Trei()
        
        return self.child[i[0]].add(i[1:])
    
    def get_root(self, i):
        
        if self.root_end or (i == ""):
            return ""
        
        if self.child.get(i[0]):
            return i[0] + self.child[i[0]].get_root(i[1:])
        else:
            return i


class Solution(object):
    
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        
        root = Trei()
        
        for i in dict:
            root.add(i)
        
        return " ".join([root.get_root(i) for i in sentence.split()])


