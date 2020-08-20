'''
PROBLEM 1

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

- create a class trieNode with the properties of isEnd(boolean) and array(size of 26)
- for insertion, create a new trieNode at index equal to the ascii value of every character in the word
- for searching, starting from root, traverse until length of word and at last check if isend is True
- for prefix, traverse until length of prefix and if at any point the value is not there in trieNode, return False
'''


class Trie(object):
    class trieNode:
        def __init__(self):
            self.isEnd=False
            self.array= [None for i in range(26)]

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root=self.trieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        curr=self.root
        
        for i in word:
            if curr.array[ord(i)-97]==None:
                curr.array[ord(i)-97]=self.trieNode()
            curr=curr.array[ord(i)-97]
        curr.isEnd=True
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        curr=self.root
        for i in word:
            if curr.array[ord(i)-97]==None:
                return False
            curr=curr.array[ord(i)-97]
        return curr.isEnd


    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        if not self.root:
            return False
        curr=self.root
        for i in prefix:
            if curr.array[ord(i)-97]==None:
                return False
            curr=curr.array[ord(i)-97]
        return True
                


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

'''
PROBLEM 2

TIME COMPLEXITY: O(N) where N is the sum of lengths of words
SPACE COMPLEXITY: O(N) where N is the sum of lengths of words

- insert all the words in the Trie and save the entire word instead of isEnd
- traverse the array from backwards for a trieNode starting from root
- if the property isEnd is true for a trieNode, push it into the queue
- return the word at the last trieNode in the queue
'''

from collections import deque
class Solution(object):
    class trieNode:
        def __init__(self):
            self.word=None
            self.array=[None for i in range(26)]
        
    def __init__(self):
        self.root=self.trieNode()
        
    def insert(self, word):
        curr=self.root
        for i in word:
            if curr.array[ord(i)-97]==None:
                curr.array[ord(i)-97]=self.trieNode()
            curr=curr.array[ord(i)-97]
        curr.word=word
        
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        
        for i in words:
            self.insert(i)
            
        queue=deque()
        queue.append(self.root)
        
        curr=None
        while(len(queue)!=0):
            curr=queue.popleft()
            for i in range(25, -1, -1):
                if curr.array[i]!=None and curr.array[i].word!=None:
                    queue.append(curr.array[i])
        
        return curr.word
        
'''
PROBLEM 3

TIME COMPLEXITY: O(N) where N is the length of sentence
SPACE COMPLEXITY: O(N) where N is length of trie

- insert all the words from dictionary in the Trie
- traverse each character in the sentence and check if the  keyword is there in the trie, if No, then copy the entire word in result and  go to the next word 
- if the keyword is there, got to  the next word without copying the rest of  the word to result
- return the result at the end
'''


        

class Solution:
    class trieNode:
        def __init__(self):
            self.isEnd=False
            self.array=[None for i in range(26)]
    
    def __init__(self):
        self.root=self.trieNode()
    
    def insert(self, word):
        curr=self.root
        for i in word:,
            # print(i)
            if curr.array[ord(i)-97]==None:
                curr.array[ord(i)-97]=self.trieNode()
            curr=curr.array[ord(i)-97]
        curr.isEnd=True
    
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        

        
        for word in dict:
            self.insert(word)
        result=""
        curr=self.root
        index=0
        while(index<len(sentence)):

            if sentence[index]==" ":
                curr=self.root
                result+=" "
                index+=1
                
            if curr.array[ord(sentence[index])-97]!=None:
                
                result+=sentence[index]
                curr=curr.array[ord(sentence[index])-97]
                if curr.isEnd==True:
                    while(index<len(sentence) and sentence[index]!=" "):
                        index+=1
                else:
                    index+=1
                    
                
            else:
                while(index<len(sentence) and sentence[index]!=" "):
                    result+=sentence[index]
                    index+=1


        return result
                
                
                    