'''
Solution: Using Trie Data-structure
Time Complexity: 
    N1 - number of words in dictionary, L1 = average length of word in dictionary
    N2 - number of words in sentence, L2 = average length of word in sentence
    - O(N1*L1): Inserting words into Trie
    - O(N2*L2): Replacing words in the sentence with their root. 
    Total: O(N1*L1 + N2*L2) - maximum of them will take precedence
Space Complexity:
    - O(N1*L1) - Trie 
    - O(N2*L2) - sentence words list
'''
class TrieNode:
    def __init__(self):
        self.isWord = False
        self.children = None
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self,word):
        node = self.root
        for ch in word:
            if node!=None and node.isWord==True: # if short word already present, we dont need bigger word
                return
            if node.children == None:
                node.children = [None]*26
            if node.children[ord(ch)-ord('a')] == None:
                node.children[ord(ch)-ord('a')] = TrieNode()
            node = node.children[ord(ch)-ord('a')]
        node.isWord = True
    
    def replace(self,derivative):
        node = self.root
        root_word = []
        
        for ch in derivative:
            if node!=None and node.isWord==True: # got root
                return "".join(root_word)
            if node.children == None or node.children[ord(ch)-ord('a')] == None:
                # did not found the root, return the entire derivative
                return derivative
            node = node.children[ord(ch)-ord('a')]
            root_word.append(ch)
        
        if node.isWord:
            return "".join(root_word)
        
        return derivative

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        replaceWord_Trie = Trie()
        
        for word in dictionary:
            replaceWord_Trie.insert(word)
        
        sentence_words = sentence.split(" ")
        replaced_sentence = []
        for i,word in enumerate(sentence_words):
            replaced_sentence.append(replaceWord_Trie.replace(word))
            if i<len(sentence_words)-1: # don't add space after last replaced word
                replaced_sentence.append(" ") # add space

        return "".join(replaced_sentence)
        

