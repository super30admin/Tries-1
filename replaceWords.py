class Solution:
    class TrieNode:
        def __init__(self):
            # Initialize the children array with None values, representing 26 letters of the alphabet
            self.children = [None for _ in range(26)]
            # Flag to mark the end of a word in the Trie
            self.isEnd = False
    
    def __init__(self):
        # Initialize the root of the Trie
        self.root = self.TrieNode()
        
    def insert(self, word: str) -> None:
        # Start at the root of the Trie
        curr = self.root
        for i in range(len(word)):
            c = word[i]
            # Calculate the index for the character in the children array
            index = ord(c) - ord('a')
            # If the TrieNode for this character doesn't exist, create a new one
            if curr.children[index] is None:
                curr.children[index] = self.TrieNode()
            # Move to the next node in the Trie
            curr = curr.children[index]
        # Mark the end of the word
        curr.isEnd = True 

    def search_root(self, word: str) -> str:
        # Start at the root of the Trie
        curr = self.root
        prefix = ""
        for i in range(len(word)):
            c = word[i]
            # Calculate the index for the character in the children array
            index = ord(c) - ord('a')
            # If the node for this character doesn't exist, return the original word
            if curr.children[index] is None:
                break
            # Move to the next node and append the character to the prefix
            curr = curr.children[index]
            prefix += c
            # If this node marks the end of a word, return the prefix as the root word
            if curr.isEnd:
                return prefix
        # If no root word is found, return the original word
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Build the Trie from the dictionary
        for word in dictionary:
            self.insert(word)
        
        # Split the sentence into individual words
        words = sentence.split()
        # Replace each word with its root (if found)
        replaced_words = [self.search_root(word) for word in words]
        
        # Join the replaced words back into a sentence and return it
        return " ".join(replaced_words)
