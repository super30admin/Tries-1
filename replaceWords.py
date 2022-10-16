class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        sentence_words = sentence.split(" ")
        for word in dictionary:
            trie.insert(word)
        result_sentence = ""
        root = trie.getRoot()
        
        for word in sentence_words:
            temp = root
            replace = ""
            flag = False
            for c in word:
                replace += c
                if temp.children[ord(c) - ord('a')] is None:
                    result_sentence += word + " "
                    flag = True
                    break
                temp = temp.children[ord(c) - ord('a')]
                if temp.isEnd:
                    result_sentence += replace + " "
                    flag = True
                    break
            if not temp.isEnd and not flag:
                result_sentence += word + " "
        
        return result_sentence.strip()
        
class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False
        
class Trie:
        

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        temp = self.root 
        for c in word:
            new_node = TrieNode()
            if temp.children[ord(c) - ord('a')] is None:
                temp.children[ord(c) - ord('a')] = new_node
            temp = temp.children[ord(c) - ord('a')]
        
        temp.isEnd = True
    
    def getRoot(self):
        return self.root