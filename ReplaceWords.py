#Brute Force:
#TC: O(n*l) n => no of words, l=>length of each word
#SC: O(n)
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        small_words = set(dictionary)
        result = []
        sentence = sentence.split(" ")
        for word in sentence:
            print(word)
            found = False
            for j in range (1, len(word)+1):
                if word[0:j] in small_words:
                    result.append(word[0:j])
                    found = True
                    break
            
            if found == False:
                result.append(word)
            result.append(" ")
        
        return "".join(result).strip()
        


 
#TC: O(n*l) n=> number of words in sentence l => length of each word (We could ignore construction of Trie here as it is just created once)
#SC: O(m*l) m => number of dictionary l=> length of each word
class Solution:
    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = [None]*26

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        root = self.TrieNode()
        #Insert
        for word in dictionary:
            curr = root
            for w in word:
                index = ord(w)-ord('a')
                if curr.children[index] == None:
                    curr.children[index] = self.TrieNode()
                curr = curr.children[index]
            curr.isEnd = True
        
        result = []
        word_list = sentence.split(" ")
        for word in word_list:
            curr = root
            replaced = False
            for w in range(0,len(word)):
                index = ord(word[w])-ord('a')
                if curr.children[index]!= None:
                    if curr.children[index].isEnd == True:
                        result.append(word[0:w+1])
                        replaced = True
                        break
                    curr = curr.children[index]
                else:
                    break

            if not replaced:
                result.append(word)
            result.append(" ")

        return ''.join(result).strip()
                
                