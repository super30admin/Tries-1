"""
Create a Trei Data structure

Time complexity : creation = O(N), Search O(N), Prefix O(N). N -> word length

Space complexity : O(num_words)

Works on leet code . Silly mistake in the prefix implementation
"""

class Trie(object):
    
    nodes = {}
    word_end = False
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.nodes = {}
    
    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        if word == "":
            self.word_end = True
            return
        
        if not self.nodes.get(word[0]):
            self.nodes[word[0]] = Trie()
        
        self.nodes[word[0]].insert(word[1:])
    
    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        if word == "" :
            return self.word_end
        
        if self.nodes.get(word[0]):
            return self.nodes[word[0]].search(word[1:])
        
        return False
    
    def startsWith(self, prefix):
        
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        if prefix == "":
            return True
        
        if self.nodes.get(prefix[0]):
            return self.nodes[prefix[0]].startsWith(prefix[1:])
        
        return False


if __name__ == '__main__':
    t = Trie()
    t.insert("apple")
    print(t.startsWith("app"))