'''
Time Complexity: 
Insert: O(len(word))
Search: O(len(word))
Startswith: O(len(prefix))

Space Complexity:
Insert: O(len(word))
Search: O(1)
Startswith: O(1)
'''
class TrieNode(object):
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False

class Trie(object):
    def __init__(self, root=None):
        self.root = TrieNode()
        
    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        dummy = self.root
        for i in range(len(word)):
            val = ord(word[i]) - ord('a')
            if(not dummy.children[val]):
                dummy.children[val] = TrieNode()
            dummy = dummy.children[val]
        dummy.isEnd = True
            
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        dummy = self.root
        for i in range(len(word)):
            val = ord(word[i]) - ord('a')
            if(not dummy.children[val]):
                return False
            dummy = dummy.children[val]
        if(not dummy.isEnd):
            return False
        return True
        

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        dummy = self.root
        for i in range(len(prefix)):
            val = ord(prefix[i]) - ord('a')
            if(not dummy.children[val]):
                return False
            dummy = dummy.children[val]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)