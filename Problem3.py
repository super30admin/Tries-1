"""
    Student : Shahreen Shahjahan Psyche
              
    Pased Test Cases : Yes
    
"""

class Node:
    def __init__(self):
        self.isEnd = False
        self.records = [None for i in range(26)]

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = Node()
        
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current = self.head
        for i in range(len(word)):
            pos = ord(word[i]) - ord("a")
            if current.records[pos]:
                current = current.records[pos]
            else:
                newNode = Node()
                current.records[pos] = newNode
                current = current.records[pos]
        current.isEnd = True
        
    def get_trie(self):
        return self.head

class Solution:
    
    def search(self, word: str, trie_dict: Trie) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = trie_dict.get_trie()
        for i in range(len(word)):
            pos = ord(word[i]) - ord("a")
            if current.records[pos]:
                current = current.records[pos]
            else:
                break
            if current.isEnd == True:
                word = word[0:i+1]
                return word
        return word
    
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        
        if not dict or not sentence:
            return sentence
        
        trie_dict = Trie()
        
        for i in dict:
            trie_dict.insert(i)

        sen_array = sentence.split(" ")
        
        for i in range(len(sen_array)):
            sen_array[i] = self.search(sen_array[i], trie_dict)
        
        sentence = " ".join(sen_array)
        
        return sentence
            
            
        
        
        
