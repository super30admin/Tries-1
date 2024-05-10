class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Solution:
    def __init__(self):
        self.root = self.getNode()

    def getNode(self):
        return TrieNode()

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)

        word = ""        
        flag = True
        res = ""
        for i in range(len(sentence)):
            word += sentence[i]
            if sentence[i] == " " or i == len(sentence) - 1:
                # Form new word 
                if flag == True:
                    res += word
                word = ""
                flag = True
                continue
            if flag and self.search(word):
                res += word
                res += " "
                flag = False
        if res[-1] == " ":
            res = res[:-1]
        return res            
    
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
        len_word = len(word)
        p_start = self.root
        for i in range(len_word):
            ind = ord(word[i]) - ord("a")
            if p_start.children[ind] == None:
                return False
            p_start = p_start.children[ind]
        return p_start.isEnd

#     """
#         Insert 
#         Time Complexity: O(m) m = keys length
#         Space Complexity: O(m) m = keys length 

#         Search
#         Time Complexity: O(m) m = keys length
#         Space Complexity: O(1) 

#         Approach:
#             Create a construction with attributes children and isEnd
#                 - children should have an array of 26 None elements. 
#                 - isEnd should be default by False
#             Create a Trie class
#                 - Create a construction with root attribute = TrieNode
#                 - Create an insert, startsWith and search function
#                     - in insert function
#                         - if there is no node at the given index then create node
#                         - move your pointer to the children
#                         - at the end of the word change the isEnd to True
#                     - in search function
#                         - if there is no node at the given index then return False
#                         - move your pointer to the children
#                         - at the end of the word retrun node.isEnd
#                     - in startsWith function
#                         - if there is no node at the given index then return False
#                         - move your pointer to the children
#                         - at the end of the word retrun True
#                 - Insert dictionary elements in the trie 
#                 - once you insert check each element of the word and see if the 
#                 subset of the word is in the Trie
#                     - if yes, then replace the word with the shortest word in the trie
#                     - else, keep it as it is
#                 - return the modified list
#     """
# class TrieNode:
#     def __init__(self):
#         self.children = [None] * 26
#         self.isEnd = False

# class Solution:
#     def __init__(self):
#         self.root = TrieNode()

#     def replaceWords(self, dictionary: List[str], sentence: str) -> str:
#         a = Solution()
#         for i in dictionary:
#             a.insert(i)
#         temp = sentence.split()
#         for i in range(0, len(temp)):
#             b = ""
#             for ch in temp[i]:
#                 b += ch
#                 if a.search(b):
#                     temp[i] = b
#                     break
#         return " ".join(temp)
        
#     def insert(self, word):
#         length = len(word)
#         rCrawl = self.root
#         for i in range(0, length):
#             index = ord(word[i]) - ord('a')
#             if not rCrawl.children[index]:
#                 rCrawl.children[index] = TrieNode()                
#             rCrawl = rCrawl.children[index]
#         rCrawl.isEnd = True
    
#     def search(self, word):
#         rCrawl = self.root
#         length = len(word)
#         for i in range(0, length):
#             index = ord(word[i]) - ord('a')
#             if not rCrawl.children[index]:
#                 return False
#             rCrawl = rCrawl.children[index]
#         return rCrawl.isEnd