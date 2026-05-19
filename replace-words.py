# d is no of words in dictionary, w is no of words in sentence and l is average length of the words
# Time Complexity: O(d*l + w*l) 
# Space Complexity: O(d*l)
# Did this code successfully run on Leetcode: Yes

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Trie(object):

    def __init__(self):
        self.root=TrieNode()
        

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        curr=self.root
        for ch in word:
            idx=ord(ch)-ord('a')
            if not curr.children[idx]:
                curr.children[idx]=TrieNode()            
            curr=curr.children[idx]
        curr.isEnd=True                                                                     


class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        words = sentence.split()
        dict_trie=Trie()
        for word in dictionary:
            dict_trie.insert(word)
        
        for word_idx in range(len(words)):
            curr=dict_trie.root
            rep=''
            for ch in words[word_idx]:
                idx=ord(ch)-ord('a')
                if curr.children[idx]: 
                    curr=curr.children[idx]              
                    rep+=ch  
                    if curr.isEnd: 
                        break                         
                else:
                    rep=words[word_idx]
                    break
            
            if not curr.isEnd:
                rep=words[word_idx]        

            words[word_idx] = rep

        return " ".join(words)

        