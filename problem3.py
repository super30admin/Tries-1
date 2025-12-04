class TrieNode:

    def __init__(self): 
        self.children = {}
        self.eow = False

    def addword(self, word): 
        curr = self

        for ch in word: 
            if ch not in curr.children:
                curr.children[ch] = TrieNode()

            curr = curr.children[ch]

        curr.eow = True

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = TrieNode()
        for word in dictionary: 
            root.addword(word)

        sentence_array = sentence.split(" ")
        result = []
        for word in sentence_array:
            flag = False
            curr = root
            res = ''
            for ch in word: 
                if ch in curr.children:
                    res += ch
                    curr = curr.children[ch]
                    if curr.eow == True: 
                        result.append(res)
                        flag = True
                        break
                else:
                    break
                
            if not flag: 
                result.append(word)

        return " ".join(result)

                


        




