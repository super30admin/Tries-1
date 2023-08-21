# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class TrieNode:
    
    def __init__(self, val):
        self.is_end=False
        self.children=[None for i in range(26)]
        self.val=val

class Trie:
   

    def __init__(self):
        self.root=TrieNode(" ")
        

    def insert(self, word: str) -> None:
        temp=self.root

        for i in word:
            node=TrieNode(i)
            if(temp.children[ord(i)-ord('a')]==None):
                temp.children[ord(i)-ord('a')]=node
            temp=temp.children[ord(i)-ord('a')]
        temp.is_end=True
    


    def search(self, word: str) -> bool:
        temp=self.root
        for i in word:
            if(temp.children[ord(i)-ord('a')]==None):
                return False
            temp=temp.children[ord(i)-ord('a')]
        return temp.is_end
    

    def startsWith(self, prefix: str) -> bool:
        temp=self.root
        for i in prefix:
            if(temp.children[ord(i)-ord('a')]==None):
                return False
            temp=temp.children[ord(i)-ord('a')]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)