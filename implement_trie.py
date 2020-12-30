class TrieNode:
    #prefix tree
    #each root node has 1)boolean value to indicate end or not 2) children map >here 26 lowercase alphas
        # Initialize your data structure here.
        def __init__(self):
            self.word=False
            self.children={}
    
class Trie:
        #O(length of word/prefix)
        #O(1)
        def __init__(self):
            self.root = TrieNode()
    
        # @param {string} word
        # @return {void}
        # Inserts a word into the trie.
        
        def insert(self, word):
            #initilize node as root trieNode
            node=self.root
            #for every char in word> check if entry is there in children map> if not>create one and insert and proceed with that child
            for i in word:
                if i not in node.children:
                    node.children[i]=TrieNode()
                node=node.children[i]
            #mark end
            node.word=True
            #print(node.children)
    
        # @param {string} word
        # @return {boolean}
        # Returns if the word is in the trie.
        
        def search(self, word):
            node=self.root
            for i in word:
                #if child not mpresent>false
                if i not in node.children:
                    return False
                node=node.children[i]
            #return end word
            return node.word
    
        # @param {string} prefix
        # @return {boolean}
        # Returns if there is any word in the trie
        # that starts with the given prefix.
        def startsWith(self, prefix):
            node=self.root
            for i in prefix:
                if i not in node.children:
                    return False
                node=node.children[i]
            return True
            
    
    # Your Trie object will be instantiated and called as such:
    # trie = Trie()
    # trie.insert("somestring")
    # trie.search("key")