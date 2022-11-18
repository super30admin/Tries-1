"""
FAANMG Problem #79 {Medium} 

648. Replace Words


Time complexity : O(n*l + m*l) --> n - number of words, m - words in sentence ,l - length of words
Space complexity : O(max(n,m)*l)


Did this code successfully run on Leetcode : Yes


@name: Rahul Govindkumar_RN27JUL2022
"""  

# definind Trie Node
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        # start with the root node
        self.root = TrieNode()
        res = []
        
        
        # insert all the words from the dictionary into the Trie
        for words in dictionary:
            self.insert(words)
        
        
        # splitting the sentence using spaces
        statement_word = sentence.split(' ')
        
        # traversing over each word
        for each_st_word in statement_word:
           
            curr = self.root
            st = ''
            
            
            # going over each word and checking with Trie
            for j in range(len(each_st_word)):
                ch = each_st_word[j]
                
                # if the char is not present or we found an end of the word, we break
                if curr.children[ord(ch) - ord('a')] == None or curr.isEnd:
                    break
                    
                    
                # keep adding the ch to the replacement string
                st += ch
                
                
                # moving the curr in Trie with the char in the word
                curr = curr.children[ord(ch) - ord('a')]
                
                
            # if we have reached to the end of the word, which was in dictionary, that means
            # the word can be replaced
            if curr.isEnd:
                res.append(st)
            else:
                # else we append the same word to res
                res.append(each_st_word)
                
                
        # making a string using list of strings separated by spaces ' '
        return ' '.join(res)

    
    
    # insert function to insert the word into the trie data structure
    def insert(self, word):
     
    # start with the root
        curr = self.root

        # traverse over every letter of the word
        for i in range(len(word)):
            ch = word[i]
           
        # if char is not present, then place a trie node there and move to that node
            if curr.children[ord(ch)-ord('a')] == None:
                curr.children[ord(ch)-ord('a')] = TrieNode()
                
            curr = curr.children[ord(ch)-ord('a')]
            
        # at the end, when the word iteration is complete, we make the isEnd flag as True marking end of current word
        curr.isEnd = True
        
        
"""
FAANMG Problem #79 {Medium} 

648. Replace Words


Time complexity : O(n*l)^2
Space complexity : O(N)


Did this code successfully run on Leetcode : Yes


@name: Rahul Govindkumar_RN27JUL2022
"""  

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        #creating hashset of dictionary words
        hashset= set(dictionary)
        
        
        # splitting the sentence using spaces
        statement_word = sentence.split(' ')
        res =[]
        
        # traversing over each word
        for each_st_word in statement_word:
            
            #setting the isEnd Flag and curr word formation to False and empty
            isEnd =False           
            curr = ''

            
            # going over each word and checking with hashset
            for ch in each_st_word:
                curr += ch
                
                # if the char is present in hashset we break and set the is end to true
                if curr in hashset:
                    isEnd = True 
                    break
                    
 
                
                
            # if we have reached to the end of the word, which was in dictionary, that means
            # the word can be replaced
            if isEnd:
                res.append(curr)
            else:
                # else we append the same word to res
                res.append(each_st_word)
                
                
        # making a string using list of strings separated by spaces ' '
        return ' '.join(res)
        
        