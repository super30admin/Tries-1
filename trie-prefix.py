
# Trie 
# fast search times - search only depends on length of word, not how many words are in the tree
# "give me all words that start with cat" - a hashmap you'd have to search all words. Trie just goes down a particular branch
# tries also have efficient space "car", "cart", "care" - in a standard list these would have to be stored 4 separate times in memory. 
# in a trie, words with same prefix share exact same nodes 

# O(L) time for insert, search, startwith where L is length of word
# O(N*L) space where N is number of words and L is average word length
class Trie:
    class TrieNode:
        def __init__(self):
            self.children ={}
            self.endOfWord = False

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            if c not in curr.children:
                curr.children[c]=self.TrieNode()
            curr = curr.children[c]
        curr.endOfWord = True

    def search(self, word: str) -> bool:
        curr = self.root
        for c in word:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return curr.endOfWord

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for c in prefix:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)