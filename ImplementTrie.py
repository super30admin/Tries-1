----------------------------------Implement Trie -------------------------------------
# Time Complexity : O(L)
# Space Complexity : O(NL)  N is the  words, L is the average length of the word
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have used dictionary for the implementation of Trie. For every node in the Trie, I have a root node and isEnd with False.
#To insert a node , I will iterate through word and check weather the char is present or not.If it is present in this node , then I will go to that character node.
#and iterate through the entire dictionary nodes. If node is not present then I will insert a new dictionary of that char.

#To search the word, I will iterate through the word and check if the node present in root node dictionary , If present I will change the current node to 
#this node. At last of the word I will check weather the end of word flag is true or not. If not i will return False.



class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        self.isEnd = False
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur = self.root
        for i in word:
            if i not in cur:
                cur[i]= {}
            cur = cur[i]
        cur['isEnd'] = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.searchPrefix(word);
        return True if (node!=None and 'isEnd' in node) else False
        
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.searchPrefix(prefix);
        return node != None
        
        
    def searchPrefix(self, word:str):
        cur = self.root
        for i in word:
            if i not in cur:
                return None
            cur = cur[i]
        return cur