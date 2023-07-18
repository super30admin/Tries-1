#Time complexity is: O(nl) where n is the no of words and l is the average length of the words
#Space complexity is: O(nl) where n is the no of words and l is the average length of the words
#Code ran successfully on leetcode
#No issues faced while coding

import collections
#Class for the trienode which contains children as well as isEnd value
class TrieNode:
    def __init__(self):
        self.children=[None for i in range(0,26)]
        self.isEnd=False

class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        root=TrieNode()
        #We will go through each word and we will insert them into the trie data structure
        for word in words:
            self.insert(root,word)
        #We are create q and sq deques
        q=collections.deque()
        sq=collections.deque()
        #We are going to append root into the queue
        q.append(root)
        #We are going to append empty string into the queue
        sq.append("")
        #initialising empty string
        currStr=""
        while(len(q)):
            #We will taking the values in q and sq, by popping them
            curr=q.popleft()
            currStr=sq.popleft()
            #We will be going through children of q
            for i in range(25,-1,-1):
                child=curr.children[i]
                #If the below condtion satisfies, we will append the child to q and calculate st value
                #We will append that st value to the sq
                if(child!=None and child.isEnd):
                    q.append(child)
                    st=currStr+(chr(ord('a')+i))
                    sq.append(st)
        #We will return currStr
        return currStr


    def insert(self,root,word):
        curr=root
        #We are going through each character in the word
        for i in range(0,len(word)):
            c=word[i]
            #If self.curr.children[ord(c)-ord('a')]==None then we will create a trienode at that position
            if(curr.children[ord(c)-ord('a')]==None):
                curr.children[ord(c)-ord('a')]=TrieNode()
            #We will update the curr with self.curr.children[ord(c)-ord('a')]
            curr=curr.children[ord(c)-ord('a')]
        #We will update the isEnd to True at the last character of the word
        curr.isEnd=True
    

