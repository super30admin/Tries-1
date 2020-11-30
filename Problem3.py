# Did this code successfully run on Leetcode : Yes
# Time Complexity : O(N) (where N is length of sentence. Because to find word of length w in trie is in O(w))
# Space Complexity : O(N)
# Three line explanation of solution in plain english:
#- Add all the the words from dictionary into teh trie.
#- To replace the word, pass through trie for given word and if any of the TrieNode is end of some word replace original word with word by that length.


#Same Trie used in problem 1
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.children = {}
        
class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for char in word:
            if char not in curr.children:
                curr.children[char] = TrieNode()
            curr = curr.children[char]
        curr.isEnd = True
        
        
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
#       Initialize our trie.
        trie = Trie()
#       Add all the words from dictionary to the trie
        for word in dictionary:
            trie.insert(word)
            
#       Split the senetence into the words.
        splitSentence = sentence.split(" ")
        for i in range(len(splitSentence)):
#           Call replace function on each word
            splitSentence[i] = self.replace(trie, splitSentence[i])
#       Join words to create string of sentence.
        return ' '.join(splitSentence)
        
    
    def replace(self, trie, word):
#       Take root node of trie as a current node
        curr = trie.root
#       Iterate over every character of word
        for i in range(len(word)):
#           If character is not equal to current trieNode than break the loop because we can't replace the word with anything. 
            if word[i] not in curr.children:
                break
#           If current character is in the children dictionary we just go to next TrieNode.
            curr = curr.children[word[i]]
#           If current trienode is end for some word that means we found replacement word which can be shorter or equal to the current word.
            if curr.isEnd:
#               Return this shorter word
                return word[:i+1]
#       Outside of for loop return the original word as a replacement because no replacement word is found inside the for loop.
        return word
        
