class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None for i in range(26)]
            self.IsEnd = False
    
    def insert(self, word: str) -> None:
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c)- ord('a')] == None:
                curr.children[ord(c) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.IsEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if sentence == None or len(sentence) == 0:
            return sentence
        self.root = self.TrieNode()
        for word in dictionary:
            self.insert(word)
        splitArray = sentence.split(" ")
        result = []
        for i in range(len(splitArray)):
            word = splitArray[i]
            replacement = []
            curr  = self.root
            for j in range(len(word)):
                c = word[j]
                if curr.children[ord(c) - ord('a')] == None or curr.IsEnd == True:  #changes made here
                    break
                replacement.append(c)
                curr = curr.children[ord(c) - ord('a')]
            if curr.IsEnd == True:
                result.append("".join(replacement))
            else:
                result.append(word)
        return " ".join(result)



        