class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        trie = Trie()
        for ix, word in enumerate(words):
            trie.insert(word, ix + 1)
        
        return trie.search(words)
    

class Trie:
    
    def __init__(self):
        self.root = TrieNode("")
    
    def insert(self, word, ix):
        curr = self.root
        for c in word:
            temp = TrieNode(c)
            if curr.children.get(c) == None:
                curr.children[c] = temp
            curr = curr.children.get(c)
        curr.ix = ix
    
    def search(self, words):
        result = ""
        st = []
        st.append(self.root)
        while len(st) > 0:
            temp = st.pop()
            if temp.ix > 0 or temp == self.root:
                if temp != self.root:
                    word = words[temp.ix - 1]
                    if len(word) > len(result) or len(word) == len(result) and result > word:
                        result = word
                for d in temp.children.values():
                    st.append(d)
        
        return result
        


class TrieNode:
    
    def __init__(self, data):
        self.data = data
        self.ix = 0
        self.children = dict()


        