'''
Time Complexity: O(M*L)
Space Complexity: O(M*L)
'''
class TrieNode(object):
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False
        
class Solution(object):
    def __init__(self):
        self.root = TrieNode()
    
    def insertDict(self, dictionary):
        for word in dictionary:
            dummy = self.root
            for j in range(len(word)):
                val = ord(word[j]) - ord('a')
                if(not dummy.children[val]):
                    dummy.children[val] = TrieNode()
                dummy = dummy.children[val]
            dummy.isEnd = True
    
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        op = []
        self.insertDict(dictionary)
        arr = sentence.split(" ")
        for word in arr:
            dummy = self.root
            temp = ""
            for i in range(len(word)):
                flag = 1
                val = ord(word[i]) - ord('a')
                if(dummy.children[val]):
                    temp = temp+word[i]
                    if(dummy.children[val].isEnd):
                        flag = 0
                        op.append(temp)
                        break
                    dummy = dummy.children[val]
                else:
                    flag = 0
                    op.append(word)
                    break
            if(flag==1):
                op.append(word)
        return " ".join(op) 
            
                    
                        
                
        