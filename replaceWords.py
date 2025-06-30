# Time Complexity:O(Nxk) where k is avg length of words and N is number of words
# Space Complexity:O(Nxk) where k is avg length of words and N is number of words
# Approach:
# BruteForce:Searach for all prefixes starting with length if found use that otherwise use word
# Optimal:Build a trie using give words,for each word try seraching in trie if is_end is found early use that prefix otherwise use the word itself(which means no prefix is found)
# worst case would build tree and search (common complexites on Tire) but if length of sentence is much larger than words then complexity changes
                                                                                                                                           



class TrieNode:
    def __init__(self):
        self.children={}
        self.is_end=False


class Trie:

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word: str) -> None:
        curr=self.root
        for i in word:
            if i not in curr.children:
                curr.children[i]= TrieNode()

            curr=curr.children[i]
        curr.is_end=True
        
    def dic(self,word):
        curr=self.root
        ans=""
        for letter in word:
            
            if curr.is_end:
                
                return ans
            if letter not in curr.children:
                return False
            else:
                ans+=letter
            curr=curr.children[letter]
        return ans


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        t=Trie()
        for i in dictionary:
            t.insert(i)
        words= sentence.split(" ")
        ans=""
        # print(words)
        for word in words:
            v=t.dic(word)
            if v!=False:
                
                ans+=v+" "
            else:
                ans+=word+" "
        return ans.rstrip()
            

                
                

