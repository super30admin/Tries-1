'''

Did it run leetcode: Yes
Problems faced: When to return, return at earliest root or longest prefix

Time Compelxity: 0(N2)
Space Compelxity: 26^N

Algorithm:
- create a trie data structure by using root words
- for every word in sentence , serach for smallest prefix in trie and return the path

'''

class Solution(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        self.trie = {}
        self.createTrie(dict)

        sentence = sentence.split(" ")
        for i in range(len(sentence)):
            sentence[i]=self.getRoot(sentence[i])
        
        return " ".join(sentence)
    
    
    
    def createTrie(self,words):
        for word in words:
            wordMap = self.trie
            for char in word:
                if char in wordMap:
                    wordMap = wordMap.get(char)
                else:
                    wordMap[char] = {}
                    wordMap = wordMap.get(char)
            
            # to mark the end of the string
            wordMap["#"] = "#"
    
    
    def getRoot(self,word):
        replcementWord = []
        wordMap = self.trie
        for char in word:
            if char in wordMap:
                wordMap = wordMap.get(char)
                replcementWord.append(char)
                if "#" in wordMap:
                    return "".join(replcementWord)
            else:
                break
        return word