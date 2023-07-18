#Time complexity is: O(L) where L is the length of the word
#Space complexity is: O(N) where N is the total length of all the words inserted
#Code ran successfully on leetcode
#No issues faced while coding

#Class for the trienode which contains children as well as isEnd value
class Trienode:
    def __init__(self):
        self.children=[None for i in range(0,26)]
        self.isEnd=False

class Trie(object):
    def __init__(self):
        #Creating a root of type trienode
        self.root=Trienode()

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        self.curr=self.root
        #We are going through each character in the word 
        for i in range(0,len(word)):
            c=word[i]
            #If self.curr.children[ord(c)-ord('a')]==None then we will create a trienode at that position
            if(self.curr.children[ord(c)-ord('a')]==None):
                self.curr.children[ord(c)-ord('a')]=Trienode()
            #We will update the curr with self.curr.children[ord(c)-ord('a')]
            self.curr=self.curr.children[ord(c)-ord('a')]
        #We will update the isEnd to True at the last character of the word
        self.curr.isEnd=True
        

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        self.curr=self.root
        #We are going through each character in the word 
        for i in range(0,len(word)):
            c=word[i]
            #If once of the character in the word is missing, we will return False
            if(self.curr.children[ord(c)-ord('a')]==None):
                return False
            #We are updating curr to the below value
            self.curr=self.curr.children[ord(c)-ord('a')]
        #we will return isEnd value which will true if the word is present in the trie
        return self.curr.isEnd

    #Here we are going to check if previously inserted string word contains the provided prefix
    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        self.curr=self.root
        #We will be going through each character in the prefix
        for i in range(0,len(prefix)):
            c=prefix[i]
            #If once of the character in the word is missing, we will return False
            if(self.curr.children[ord(c)-ord('a')]==None):
                return False
            #We are updating curr to the below value
            self.curr=self.curr.children[ord(c)-ord('a')]
        #If previously inserted string word contains the provided prefix, we return True
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)