# Time Complexity : O(N)  //Where n is the size of the array
#  Space Complexity : O(H)  //Recursive stack for the tree
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class TrieNode():
    def __init__(self):
        self.children = {}
        self.isEnd = False
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        #Store all roots in a tire 
        root = self.insert(dictionary)
		#Split the sentence into individual words 
        words = sentence.split(' ')
        results = []
        
		#Replace each word in a sentence with either the root of itself when no prefix matches
        for word in words:
            results.append(self.find(root, word))
            
         #Return result as a string
        return ' '.join(results)
    
    #Store roots in a trie
    def insert(self, dictionary: List[str]) -> TrieNode:
        root = TrieNode()
        
		#We have to go through each character in each word 
        for word in dictionary:
            node = root
            for char in word:
				#Add a new node if doesn't exist
                if char not in node.children:
                    node.children[char] = TrieNode()
				# move to next node 
                node = node.children[char]
			# finally, set the last inserted node as complete
            node.isEnd = True 
                
        return root
    
   #Get replacement for each word, this will either return 
   #The root or the successor if no matching prefix is found
    def find(self, root: TrieNode, word: str) -> str:
        replacement = ''
        node = root
        
        for char in word:
            if char not in node.children or node.isEnd:
                break
            
            replacement += char
            node = node.children[char]
        
        return replacement if node.isEnd == True else word