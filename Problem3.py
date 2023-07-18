#Time complexity is: O(ml + nl) where m is the no of words in dictionary, n is the number of words in sentence and l is average length of the words
#Space complexity is: O(ml) where m is the no of words in dictionary and l is average length of the words
#Code ran successfully on leetcode
#No issues faced while coding

#Class for the trienode which contains children as well as isEnd value
class Trienode:
    def __init__(self):
        self.children=[None for i in range(0,26)]
        self.isEnd=False

class Solution(object):
    def insert(self, word):
        self.curr=self.root
        #We are going through each character in the word
        for i in range(0,len(word)):
            c=word[i]
            #If self.curr.children[ord(c)-ord('a')]==None then we will create a trienode at that position
            if(self.curr.children[ord(c)-ord('a')]==None):
                self.curr.children[ord(c)-ord('a')]=Trienode()
            #We will update the curr with self.curr.children[ord(c)-ord('a')]
            self.curr=self.curr.children[ord(c)-ord('a')]
        #We will update the isEnd to True at the last character of the word
        self.curr.isEnd=True

    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        self.root=Trienode()
        #We will go through each word and we will insert them into the trie data structure
        for word in dictionary: #nl-TC,SC
            self.insert(word)
        #We are splititng the sentence into strArr
        strArr=sentence.split(" ")
        result=""
        #Iterating through each value in the strArr
        for k in range(0,len(strArr)):
            word=strArr[k]
            replacement=""
            self.curr=self.root
            #We will be going through each character of the word
            for j in range(0,len(word)):
                c=word[j]
                #If the below if condition satisfies, we will break this loop
                if(self.curr.children[ord(c)-ord('a')]==None or self.curr.isEnd==True):
                    break
                #If not we will update the curr calue
                self.curr=self.curr.children[ord(c)-ord('a')]
                #We will append c value to the the replacement value
                replacement+=c
            #If isEnd is true for the curr node, we will add that to the result
            if(self.curr.isEnd==True):
                result+=replacement
            else:
            #If replacement is not found, we will just add the original word
                result+=word
            result+=" "
        #Finally returning the result by removing extra spaces
        return result.strip()


