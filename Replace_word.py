// Time Complexity : O(m*n + m1 * n1)
            'm' words, 'n' avg len of the word, 
            'm1' words in sentence, 'n1' avg len of word in setence,
 // Space Complexity : O(w)
            'w' is the no of unique characters in all words in dic
class TrieNode:
    def __init__(self):
        self.children=[None]*26
        self.word=None
class Solution:
    def __init__(self):
        self.root=TrieNode()
    def insert(self,word):
        curr=self.root
        for i in word:
            ch=ord(i)-ord('a')
            if not curr.children[ch]:
                curr.children[ch]=TrieNode()
            curr=curr.children[ch]
        curr.word=word
        
    def search(self,word):
        curr=self.root
        for i in word:
            ch=ord(i)-ord('a')
            if curr.children[ch]:
                curr=curr.children[ch]
                if curr.word:
                    return curr.word
            else:
                break
        return word
    
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        for d in dict:
            self.insert(d)
            
        output=''
        for word in sentence.split():
            if len(output) > 0:
                output+=' '
            output+= self.search(word)
        return output
