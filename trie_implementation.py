class TrieNode:
    '''
    A trie node has 26 child nodes and one flag to indicate if the word is ending
    '''
    def __init__(self):
        self.children = [None]*26
        self.isEnd = None
    
class Trie:

    def __init__(self):
        '''
        A trie class has ord and a root value which is a trie node 
        '''
        self.charA = ord('a')
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        '''
        Every time you try to insert, you access the root attribute of the trie class and then yopu seacrch 
        if the child node at the desiered location to see if it is None or not. If it is None, 
        you create a new TrieNode else you get to that child node 
        You are ultimately not inserting the string, but you are just indicating the presence of the 
        letter by inserting a TrieNode in that particular index. Finally you set the isEnd variable to True
        T = O(length of the word)
        '''
        curr = self.root
        charA = self.charA
        
        for letter in word:
            if curr.children[ ord(letter) - charA] == None:
                curr.children[ord(letter) - charA] = TrieNode()
            curr = curr.children[ord(letter) - charA] 
        curr.isEnd = True 
            
    def search(self, word: str) -> bool:
        '''
        You iterate over the corresponding child nodes and see if you reach a None inbetween your traversal. This would sugest that the word is not present. Else you return the last node's isEnd which has to be True if the word is ending there 
        T = O(length of the word)
        '''
        curr = self.root
        charA = self.charA
        for letter in word:
            if curr.children[ ord(letter) - charA ] == None:
                return False 
            curr = curr.children[ ord(letter) - charA ]
        return curr.isEnd
        
    def startsWith(self, prefix: str) -> bool:
        '''
        iterate over the Trie and see if you envouter a None inebetween if so then return False 
        else return True
        T = O(length of the prefix)
        '''
        curr = self.root
        charA = self.charA
        for letter in prefix:
            if curr.children[ord(letter)-charA] == None:
                return False
            curr = curr.children[ord(letter)-charA]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
