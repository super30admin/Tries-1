# TC:O(MK+N),M=lenght of dictionary, K=length of longest word in dictionary,N=length of sentence
# SC:O(MK)
    
#Did code run successfully on Leetcode : yes
class TrieNode:
    def __init__(self):
        self.isend=False
        self.children = [False]*26

class Solution:  
    
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if len(dictionary)==0:
            return sentence
        
        def buildTrie(dictionary):
            root = TrieNode()
            trie = root
            for word in dictionary:
                cur = trie
                for index,w in enumerate(word):
                    w_ind = ord(w)-ord('a')
                    if not cur.children[w_ind]:
                        cur.children[w_ind] = TrieNode()
                    cur = cur.children[w_ind]
                cur.isend=True
            return trie

        trie = buildTrie(dictionary)
        output = ''

        def search_prefix(word):
            cur = trie
            replace = ''
            for index,w in enumerate(word):
                w_ind = ord(w)-ord('a')
                if not cur.children[w_ind] or cur.isend:
                    break
                cur = cur.children[w_ind]
                replace+=w
            if cur.isend :
                return replace
            return word
            
        words = sentence.split()
        n = len(words)
        

        
        for index,word in enumerate(words):
            pre = search_prefix(word)
            output+=pre
            if index!=n-1:
                output+= ' '
        return output
                