"""
Problem : 3

Time Complexity : O(nk)
Space Complexity : O(nk)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating a TrieNode, then inserting all the words in the trieNode, separating the words in sentence by whitespaces
and searching those words in the Trie, if the original word is finished first but its not the end of the word in Trie, then
returning the original word as it cannot be replaced, if we encounter the end of a trie node, then replacing the original 
word with the word built till the end of trieNode, returning the complete string at the end
"""

# Replace Words

# Approach - 1
# Using Tries

class TrieNode(object):
    def __init__(self):
        self.children=[None for _ in range(26)]
        self.isEnd=False

class Solution(object):
    def __init__(self):
        self.root=TrieNode()
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        result=""
        if not sentence or not dictionary:
            return sentence
        for word in dictionary:
            self.insertTrie(word)
        
        sentence=sentence.split(" ")
        for i in range(len(sentence)):
            word=sentence[i]
            newword=self.searchTrie(word)
            result+=newword
            if i<len(sentence)-1:                 
                result+=" "

        return result


    def insertTrie(self,word):
        curr=self.root
        for i in range(len(word)):
            c=word[i]
            index=ord(c)-ord('a')
            if curr.children[index]==None:
                curr.children[index]=TrieNode()
            curr=curr.children[index]
        curr.isEnd=True

    def searchTrie(self,word):
        curr=self.root
        newword=""
        for i in range(len(word)):
            c=word[i]
            index=ord(c)-ord('a')
            if curr.isEnd==True:
                return newword
            if curr.children[index]==None:
                return word
            else:
                newword+=c
                curr=curr.children[index]

        return word


# Approach - 2
# Bruteforce

class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """

        result=""
        dictionary.sort(key=lambda x:len(x))
        wordlist=sentence.split(" ")
        for i in range(len(wordlist)):
            word=wordlist[i]
            for j in range(len(dictionary)):
                size=len(dictionary[j])
                if word[:size]==dictionary[j]:
                    wordlist[i]=dictionary[j]
                    break
        for i in range(len(wordlist)):
            result+=wordlist[i]
            if i!=len(wordlist)-1:
                result+=" "
        return result