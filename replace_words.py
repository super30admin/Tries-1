class Solution:
    class TrieNode():
        def __init__(self):
            self.children={}
            self.isEnd=False
    def __init__(self):
        self.root=self.TrieNode()

    def insert(self,word):
        curr=self.root
        for c in word:
            if c not in curr.children:
                curr.children[c]=self.TrieNode()
            curr=curr.children[c]
        curr.isEnd=True

    def getRootWord(self,word):
        curr=self.root
        sb=[]
        for c in word:
            if not curr.children.get(c) or curr.isEnd:
                break
            sb.append(c)
            curr=curr.children[c]
        if curr.isEnd:
            return "".join(sb)
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for word in dictionary:
            self.insert(word)

        splitArr=sentence.split(" ")
        result=[]

        for i in range(len(splitArr)):
            word=splitArr[i]

            result.append(self.getRootWord(word))
        return " ".join(result)

        