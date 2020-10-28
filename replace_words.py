# O(NR + MS) TIME WHERE N IS NO.OF ROOTS , R IS LEN OF LONGEST ROOT AND M IS NO.OF WORDS IN SENTENCE , S IS LEN OF LONGEST WORD IN SENTENCE
# O(NR) SPACE

class Trie:
    def __init__(self,words):
        self.root = {}
        for word in words:
            self.insert(word)
 
    def insert(self, word: str) -> None:
        current = self.root
        for char in word:
            if char not in current:
                current[char] = {}
            current = current[char]
        current["*"] = word
                

    def startsWith(self, prefix: str) -> bool:
        current = self.root
        for char in prefix:
            if "*" in current:
                return current["*"]
            if char not in current:
                return prefix
            current = current[char]
        return prefix


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie(dictionary)
        # print(trie.root)
        output = []
        for word in(sentence.split(" ")):
            output.append(trie.startsWith(word))
        return ' '.join(output)

            
        
        
        

