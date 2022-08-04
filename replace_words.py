#Time complexity: O(nl)-n is no.of.words, l if average length of each word
#space complexity: O(n) - to create sentencelist
#Approach: create a trie for the given dictionary
# split the sentence into list of words
# check the trie for given word's prefix
# check if isend is true, if true then it means- prefix is found, replace the prefix into the sentence list-word
# make the sentence list as sentence again



class Trienode:
    def __init__(self):
        self.val = None 
        self.children = [None] * 26
        self.isend = False
class Trie:
    def __init__(self):
        self.root = Trienode()
    def insert(self, word):
        curr = self.root
        for char in word:
            ci = ord(char)-ord('a')
            if curr.children[ci] == None:
                curr.children[ci] = Trienode()
                curr.children[ci].val = char
            curr = curr.children[ci]
        curr.isend = True
    
    
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        sentencelist = sentence.split(" ")
        trie = self.create_trie(dictionary)
        for i in range(len(sentencelist)):
            replacement = ''
            curr = trie.root
            for char in sentencelist[i]:
                ci = ord(char)-ord('a')
                if curr.children[ci] is None or curr.isend:
                    break
                replacement += char
                curr = curr.children[ci]
            if curr.isend:
                sentencelist[i] = replacement
        return " ".join(sentencelist)
    
    def create_trie(self, dic):
        trie = Trie()
        for word in dic:
            trie.insert(word)
        return trie
                    
                
            
        
        