class TrieNode:
        def __init__(self):
            self.children=[None]*26
            self.is_end=False
class Solution:

    def __init__(self):
        self.root=TrieNode()
    def insert(self, word: str) -> None:
        node=self.root
        for char in word:
            index=ord(char)-ord('a')
            if node.children[index]==None:
                node.children[index]=TrieNode()
            node=node.children[index]
        node.is_end=True
    def shortest(self,word):
        curr=self.root
        sb=[]
        for char in word:
            index=ord(char)-ord('a')
            if curr.children[index]==None:
                break
            sb.append(char)
            curr=curr.children[index]
            if curr.is_end:
                return ''.join(sb)
        return word
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)
        array=[]
        word1=''
        for i in range(len(sentence)):
            if sentence[i]!=' ':
                word1=word1+sentence[i]
            else:
                array.append(word1)
                word1=''
        array.append(word1)
        result=[]
        for i in range(len(array)):
            word=array[i]
            result.append(self.shortest(word))

        return ' '.join(result)

        