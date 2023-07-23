"""
Problem : 1

Time Complexity : 
insert - O(n)
search - O(n)
startsWith - O(n)

Space Complexity : O(26*N)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Initializing a TrieNode class with useful data members, while inserting, first checking if the specific index at a TrieNode is None, if Yes,
creating a TrieNode at that Index to accomodate upcoming elements and shofting the current pointer to newly created TrieNode, after insertion,
the updating the flag of the current pointer as True, marking as the end of the word. For search, performing the operations as insertion, insteading
of creating new TrieNode at a index where index was NULL, returning False, as it means specific character of the word not found, otherwise, moving the current
pointer to the TrieNode of current character. For startWith, performing same operation as search, if every character in prefix found in the Trie, then returning
True at the end

"""

# Implement Trie (Prefix Tree)



class TrieNode(object):
        def __init__(self):
            self.children=[None for _ in range(26)]
            self.isEnd=False

class Trie(object):
    

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            index=ord(c)-ord('a')
            if curr.children[index]==None:
       
                curr.children[index]=TrieNode()
            
            curr=curr.children[index]
        curr.isEnd=True

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            index=ord(c)-ord('a')
            if curr.children[index]==None:
                return False
            else:
                curr=curr.children[index]

            
        return curr.isEnd


    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        curr=self.root
        for i in range(len(prefix)):
            c=prefix[i]
            index=ord(c)-ord('a')
            if curr.children[index]==None:
                return False
            else:
                curr=curr.children[index]
        return True
            
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)