// Time Complexity : O(N) N is the number  of words in the sentence
// Space Complexity : o(summation(N)) N is the number of words in dict
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we first create a trie with the words in the dict.Then we split the sentence into words and see if each word has any root in the trie if yes we replace it with root word.


class TrieNode:
    def __init__(self):
        self.word1=None
        self.children=[None for i in range(26)] 

class Trie(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        root1=self.root
        for i in range(len(word)):
            index=ord(word[i])-ord('a')
            if root1.children[index]==None:
                root1.children[index]=TrieNode()
            root1=root1.children[index]
        root1.word1=word
        return True
class Solution(object):
    def __init__(self):
        self.result=[]
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        trie=Trie()
        for word in dict:
            trie.insert(word)
        words=sentence.split(' ')
        for word in words:
            root1=trie.root
            for k in word:
                index=ord(k)-ord('a')
                if root1.children[index]==None or root1.word1!=None:
                    break
                root1=root1.children[index]
            # print(root1.word1)
            if root1.word1!=None:
                self.result.append(root1.word1)
            else:
                self.result.append(word)
        return ' '.join(self.result)
                
            
        