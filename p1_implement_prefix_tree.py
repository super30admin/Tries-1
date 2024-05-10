class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Trie:
    def __init__(self):
        self.root = self.getNode()
    
    def getNode(self):
        return TrieNode()
    
    def insert(self, word):
        p_start = self.root
        len_word = len(word)
        for i in range(len_word):
            ind = ord(word[i]) - ord('a')
            if p_start.children[ind] == None:
                p_start.children[ind] = self.getNode()
            p_start = p_start.children[ind]
        p_start.isEnd = True

    def search(self, word):
        p_start = self.root
        len_word = len(word)
        for i in range(len_word):
            ind = ord(word[i]) - ord('a')
            if p_start.children[ind] == None:
                return False
            else:
                p_start = p_start.children[ind]
        return p_start.isEnd

    def startsWith(self, word):
        len_word = len(word)
        p_start = self.root
        for i in range(len_word):
            ind = ord(word[i]) - ord('a')
            if p_start.children[ind] == None:
                return False
            else:
                p_start = p_start.children[ind]
        return True
# """ 
#     Insert 
#     Time Complexity: O(m) m = keys length
#     Space Complexity: O(m) m = keys length 

#     Search
#     Time Complexity: O(m) m = keys length
#     Space Complexity: O(1) 

#     Approach:
#         Create a construction with attributes children and isEnd
#             - children should have an array of 26 None elements. 
#             - isEnd should be default by False
#         Create a Trie class
#             - Create a construction with root attribute = TrieNode
#             - Create an insert, startsWith and search function
#                 - in insert function
#                     - if there is no node at the given index then create node
#                     - move your pointer to the children
#                     - at the end of the word change the isEnd to True
#                 - in search function
#                     - if there is no node at the given index then return False
#                     - move your pointer to the children
#                     - at the end of the word retrun node.isEnd
#                 - in startsWith function
#                     - if there is no node at the given index then return False
#                     - move your pointer to the children
#                     - at the end of the word retrun True
# """

# class TrieNode:
#     def __init__(self):
#         self.children = [None] * 26
#         self.isEnd = False        

# class Trie:
#     def __init__(self):
#         self.root = self.getNode()
    
#     def getNode(self):
#         return TrieNode()

#     def insert(self, word: str) -> None:
#         # print ("word1=", word)
#         pCrawl = self.root
#         length = len(word)
#         for i in range(0, length):
#             index = ord(word[i]) - ord('a')
#             # print ("index1=", index)
#             if not pCrawl.children[index]:
#                 pCrawl.children[index] = self.getNode()
#             pCrawl = pCrawl.children[index]
#         pCrawl.isEnd = True

#     def search(self, word: str) -> bool:
#         pCrawl = self.root
#         length = len(word)
#         for i in range(0, length):
#             index = ord(word[i]) - ord('a')
#             if not pCrawl.children[index]:
#                 return False
#             pCrawl = pCrawl.children[index]
#         return pCrawl.isEnd
        
#     def startsWith(self, prefix: str) -> bool:
#         pCrawl = self.root
#         length = len(prefix)
#         for i in range(0, length):
#             index = ord(prefix[i]) - ord('a')
#             if not pCrawl.children[index]:
#                 return False
#             pCrawl = pCrawl.children[index]
#         return True


# # Your Trie object will be instantiated and called as such:
# # obj = Trie()
# # obj.insert(word)
# # param_2 = obj.search(word)
# # param_3 = obj.startsWith(prefix)