class TrieNode:
    def __init__(self) -> None:
        self.isWord = False
        self.children = {}

class Trie:
    def __init__(self) -> None:
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.isWord = True 

    def findRoot(self, word_string):
        root_string = ""
        node = self.root
        for ch in word_string:
            if ch not in node.children:
                return word_string
            root_string += ch
            node = node.children[ch]
            if node.isWord:
                break
        return root_string

    def startsWith(self, prefix):
        currNode = self.root
        #For every char in word
        for i in prefix:
            #search if the children map has the keys present
            if i not in currNode.children:
                return False
            else: #Present
                currNode = currNode.children[i]#currNode.next
        return True

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for root in dictionary:
            trie.insert(root)
        
        sentence_list = sentence.split(" ")
        for i in range(len(sentence_list)):
            word = sentence_list[i]
            root = trie.findRoot(word)

            sentence_list[i] = root #Replacement

        return " ".join(sentence_list) #Join the list