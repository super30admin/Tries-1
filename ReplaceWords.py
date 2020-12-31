
"""
Approach: Using trie

Given dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"

We will make trie from the words in dictionary.

        root
      /  |  \  
     c   b  r
     |   |  |
     a   a  a
     |   |  |
     t   t  t
     
Here we will maintain an additional information if the letter is a last letter or not. So for nodes 't' in all 3 branches will have last character as true.

We will traverse through every letter in every word. If a letter is present in the trie, we will go down that branch to check for the root and replace the original word with that root word.

Time complexity: O(n*p + m*p'); where 
n = length of dictionary
p = avg legth of word in dictionary
m = length of sentence
p' = avg legth of word in sentence

Now if we see in the constraints m and p turns out to be the dominating factors which makes it O(m * p')
Space complexity: 
Trie building O(n * p)
String building O(m * p') , but we are supposed to return this string.
That makes it O(n * p )
"""
class TrieNode:
    def __init__(self):
        self.lastChar = False
        self.children = [0] * 26

class Solution:
    
    # Insert in a trie
    def insert(self, word):
        curr = self.root
        
        for i in range(len(word)):
            c = word[i]
            if curr.children[ord(c) - ord('a')] == 0:
                curr.children[ord(c) - ord('a')] = TrieNode()
                
            curr = curr.children[ord(c) - ord('a')] 
        
        curr.lastChar = True
        

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        if dictionary == None or len(dictionary) == 0:
            return sentence
        
        self.root = TrieNode()
        
        # Creating our trie
        
        for word in dictionary:
            self.insert(word)
            
        splitSentence = sentence.split(" ")
        result = ""
        
        curr = self.root
        
        # Going through each word in the sentence
        for i in range(len(splitSentence)):
            if i > 0:
                result += " "
            
            temp = ""
            curr = self.root
            
            # Going through each letter in the word
            for j in range(len(splitSentence[i])):
                c = splitSentence[i][j]
                if curr.children[ord(c) - ord('a')] == 0 or curr.lastChar:
                    break
                    
                # Recreating the word letter by letter
                temp += c
                curr = curr.children[ord(c) - ord('a')]
            
            # Recreating the sentence word by word
            if curr.lastChar:
                result += temp
            else:
                result += splitSentence[i] 
            
        return result
        
        