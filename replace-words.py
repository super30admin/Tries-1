# Time Complexity: O(N) - length of sentence
# Space Complexity: O(N)
# Approach: Build a trie with all the words from the dictionary. In the search function, return the shortest root word(more comments in-line).

class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.endOfWord = False
            
class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word): # Same as normal trie implementation
        curr = self.root
        for c in word:
            node = curr.children[ord(c)-ord('a')]
            if node is None:
                node = TrieNode()
                curr.children[ord(c)-ord('a')] = node
            curr = node
        curr.endOfWord = True

    def search(self, word): # Returns shortest root word
        curr = self.root
        res = '' # Empty string for result
        for c in word:
            node = curr.children[ord(c)-ord('a')]
            # If node is not null, append the chars to res string and proceed to next node
            if node: 
                res += c
                curr = node
                # If a word ends at curr, this is the shortest root word
                if curr.endOfWord:
                    break
            else:
                break
        # Root word found, return res
        if curr.endOfWord:
            return res
        
        # No root found, return the original word
        return word

class Solution(object):                
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        trie = Trie()
        for word in dictionary:
            trie.insert(word)
        out = []  
        for word in sentence.split():
            out.append(trie.search(word))
            
        return ' '.join(out)