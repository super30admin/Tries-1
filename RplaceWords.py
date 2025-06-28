# Time complexity - o(N+L)
# Space Complexity - o(N+L)

class TrieNode:
        __slots__ = "children", "isEnd"
        isEnd:bool
        children:list

        def __init__(self):
            self.isEnd = False
            self.children = [None]*26

class Trie:

    

    def __init__(self):
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        curr = self.root

        for c in word:
            position = ord(c)-ord('a')
            if not curr.children[position]:
                curr.children[position] = TrieNode()

            curr = curr.children[position]
        curr.isEnd = True
        

    def search(self, word: str) -> bool:
        curr = self.root

        for c in word:
            position = ord(c)-ord('a')
            if not curr.children[position]:
                return False

            curr = curr.children[position]
        return curr.isEnd
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root

        for c in prefix:
            position = ord(c)-ord('a')
            if not curr.children[position]:
                return False

            curr = curr.children[position]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        obj = Trie()
        for word in dictionary:
            obj.insert(word)

        sen = sentence.split(' ')


        for i in range(len(sen)):
          
            new_word = ''
            w = sen[i]
            curr = obj.root
            
            for c in w:
                if curr.children[ord(c)-ord('a')] is None or curr.isEnd:
                    break
                new_word+=c
                curr = curr.children[ord(c) - ord('a')]

            if curr.isEnd:
                sen[i] = new_word               

        return " ".join(sen)

            
        