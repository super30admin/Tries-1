# problem 3

# https://leetcode.com/problems/word-search/


class Solution:

    class Tries:
        def __init__(self):
            self.node = [None]*26
            self.end_word = False

    def __init__(self):
        self.root = self.Tries()

    def insert(self,word):
        current = self.root
        for i in word:
            idx = ord(i) - ord('a')
            if current.node[idx] is None:
                current.node[idx] = self.Tries()
            current = current.node[idx]
        current.end_word = True
    
    def searchSmall(self,word):
        current = self.root
        for i in range(len(word)):
            idx = ord(word[i]) - ord('a')
            if current.end_word:
                return True,word[:i]
            if current.node[idx] is None:
                return False,'' 
            current = current.node[idx]
        return False,''

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for dict_val in dictionary:
            self.insert(dict_val)
        
        split_sentences = sentence.split(' ')
        final_arr=[]
        for split_sentence in split_sentences:
            match,string = self.searchSmall(split_sentence)
            if match:
                final_arr.append(string)
            else:
                final_arr.append(split_sentence)
        return ' '.join(final_arr)