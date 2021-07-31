#Time: O(m): For Finding words
#Space: O(m)  For storing words in trie
class Trie:
    def __init__(self):
        self.children = [None]*26
        self.isend = False
    def insert(self,word):
        curr = self
        for char in word:
            if not curr.children[ord(char)-ord("a")]:
                curr.children[ord(char)-ord("a")] = Trie()
            curr = curr.children[ord(char)-ord("a")]
        curr.isend = True
    def search(self,word):
        curr = self
        for index,char in enumerate(word):
            if not curr.children[ord(char)-ord("a")]:
                return False
            elif curr.children[ord(char)-ord("a")] and curr.children[ord(char)-ord("a")].isend:
                return word[:index+1]
            curr = curr.children[ord(char)-ord("a")]
        return False
        

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        dictionary_trie = Trie()
        for word in dictionary:
            dictionary_trie.insert(word)
        sentence_list = sentence.split(" ")
        for index,word in enumerate(sentence_list):
            root = dictionary_trie.search(word)
            if root:
                sentence_list[index]=root
        return " ".join(sentence_list)