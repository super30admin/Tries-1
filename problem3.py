# Replace Words
# // Time Complexity :  O(nk + lm) n-number of words in dictionary, k- average length of words in dictionary, and l- words in the sentence, m- average3 length of the words in the sentence
# // Space Complexity : O(N) - N is the number of words in the dictionary
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    
    class TrieNode:                                                 #making the trie node class with its children and isend method
        def __init__(self):
            self.children = [None]*26
            self.is_end = False
    def __init__(self):
        self.curr = self.TrieNode()
            
    def insert(self,word):                                      #inserts the replace words in the trienode in the repective order
        curr = self.curr
        for i in word:
            if(curr.children[ord(i)-97] ==None):
                curr.children[ord(i)-97] = self.TrieNode()
            curr=curr.children[ord(i)-97]
        curr.is_end = True
                
    def replaceWords(self, dictionary, sentence):
        res=""
        curr = self.curr
        for i in dictionary:                                        #inserts every words in the dictionary
            self.insert(i)
        for i in sentence.split(" "):
            if len(res)>0:
                res+=" "
            temp=""
            curr = self.curr
            for j in i:                                                 #for every letter in the sentence, checks if the letter exists in the trie node, if it does add them to string
                if(curr.children[ord(j)-97] ==None or curr.is_end):
                    break
                temp+=j
                curr = curr.children[ord(j)-97]
            if(curr.is_end):                                            #if you reach the end of the trienode, add replace the word
                res+=temp
            else:                                                       #if not, add the same word back to the string
                res+=i
        return res