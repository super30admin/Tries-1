from typing import  List
class Solution:
    def __init__(self):
        self.root=TrieNode()

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if dictionary is None or sentence is None or len(sentence) == 0: return str
        result=[]
        for word in dictionary:
            self.buidTries(word)
        sentence = sentence.split(" ")
        for wordcharacter in sentence:
            result.append(self.searchtheTries(wordcharacter))

        return result



    def buidTries(self, word : str) -> None:
        ptr = self.root
        for charcater in word:
            if ptr.children[ord(charcater) - ord('a')] == None:
                ptr.children[ord(charcater) - ord('a')]=TrieNode()
            ptr=ptr.children[ord(charcater) - ord('a')]
        ptr.isend = True
    def searchtheTries(self,target: str ) -> str:
        ptr = self.root
        prefixword=''
        for character in target:
            if ptr.children[ord(character) - ord('a')] == None or ptr.isend ==True:  break
            ptr =ptr.children[ord(character) - ord('a')]
            prefixword= character + " "+ prefixword

        if ptr.isend == True:
            return  prefixword
        else:
            return target






class TrieNode:
    def __init__(self):
        self.isend=False
        self.children = [None for _ in range(26)]