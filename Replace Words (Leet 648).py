'''
Time: 0(1) -> trie structure to iterate 
      0(n*k) -> where n is iterating the successor and k is iterating the root
Space: 0(k) -> build trie
'''

class Solution:
    
    class TrieNode:
        def __init__(self):
            self.children = [None for _ in range(26)]
            self.flag = False
            
    root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] == None:
                curr.children[ord(c) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.flag = True
    
    def insert_all_words(self, word_li):
        for word in word_li:
            self.insert(word)
            
            
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = self.TrieNode()
        self.insert_all_words(dictionary)
        result = ''
        temp = sentence.split(' ')
        
        for word in temp:
            curr = self.root
            repstr = ''
            for c in range(len(word)):
                sample = ord(word[c]) - ord('a')
                if curr.children[sample] is None or curr.flag:
                    break
                repstr += word[c]
                curr = curr.children[sample]
            
            if curr.flag:
                result += repstr + ' '
            else:
                result += word + ' '
                
                
        return result.strip()
            


# Hashmap solution
'''
Time: 0(k) -> for dict to cal hash func where k is the len of str in a dictionary list
      0(n*k) -> where n is iterating the successor and k is iterating the root
Space: 0(n) -> build dict 
'''

class Solution:
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        temp = set(dictionary)
        strArr = sentence.split(' ')
        result = ''
        
        for j in range(len(strArr)):
            word = strArr[j]
            prevlen = len(result)
            for i in range(len(word)):
                substr = word[0:i+1]
                if substr in temp:
                    result += substr  + ' '
                    break
            if prevlen == len(result):
                result += word + ' '
        return result.strip()
                

