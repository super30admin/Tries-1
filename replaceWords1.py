#Time: O(sum of lengths of all roots + number of words in the sentence)
#Space: same as time
#did the code run successfully on LC? yes
#issues faced? when word in a sentence is smaller than a root
#approach:
#build a prefix tree for roots in dictionary
#get the smallest root if a root is possible for each word in the sentence

class Trie:
    def __init__(self):
        self.root = {}

    def insert(self, word):
        curr = self.root
        for letter in word:
            if letter not in curr:
                curr[letter] = {}
            curr = curr[letter]
        curr['isWord'] = True
    
    def giveRoot(self, word):
        curr = self.root
        for idx in range(len(word)):
            child = word[idx]
            if child not in curr:
                return word
            if 'isWord' in curr[child]:
                return word[:idx+1]
            curr = curr[child]
        return word
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = Trie()
        for root in dictionary:
            trie.insert(root)

        result = sentence.split()
        for i in range(len(result)):
            result[i] = trie.giveRoot(result[i])
        print(result)
        return ' '.join(result)