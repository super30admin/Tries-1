# 208. Implement Trie (Prefix Tree)

# TC : insert: O(m) - where m is the length of the word being inserted
    # search: O(m) - where m is the length of the word being searched
    # startsWith: O(m) - where m is the length of the prefix
# SC : O(n * m) in the worst case, where:
    # n is the number of words inserted
    # m is the average length of the words
    # In practice, there's often significant character overlap, reducing actual space usage
# Did this code successfully run on Leetcode : Yes

# Approach :
# Data Structure Design:
    # Each Trie node contains:
        # A dictionary children mapping characters to child nodes
        # A boolean flag is_end_of_word to mark complete words
# insert(word) Method:
    # Iterates through each character in the word
    # Creates new nodes for characters not yet in the trie
    # Marks the final node as the end of a word
# search(word) Method:
    # Traverses the trie character by character
    # Returns False if any character is missing
    # Returns True only if the final node is marked as a word ending
# startsWith(prefix) Method:
    # Similar to search, but doesn't require the final node to be a word ending
    # Returns True if the entire prefix exists in the trie
# Optimizations Used:
    # Using a dictionary for child nodes provides O(1) lookups
    # Only storing characters that are actually used (sparse representation)
    # Early termination in search and startsWith when a character is not found

    
class Trie:
    def __init__(self):
        # Initialize the trie root node
        # We'll use a dictionary to store children nodes
        # The key is the character, the value is the child node
        self.children = {}
        # Flag to mark the end of a word
        self.is_end_of_word = False
    
    def insert(self, word: str) -> None:
        # Start at the root node
        current = self
        
        # Traverse the trie for each character in the word
        for char in word:
            # If character not in current node's children, add it
            if char not in current.children:
                current.children[char] = Trie()
            # Move to the child node for this character
            current = current.children[char]
        
        # Mark the end of the word
        current.is_end_of_word = True
    
    def search(self, word: str) -> bool:
        # Start at the root node
        current = self
        
        # Traverse the trie for each character in the word
        for char in word:
            # If character not found in current children, word doesn't exist
            if char not in current.children:
                return False
            # Move to the next node
            current = current.children[char]
        
        # Return True only if we've reached the end of a word
        return current.is_end_of_word
    
    def startsWith(self, prefix: str) -> bool:
        # Start at the root node
        current = self
        
        # Traverse the trie for each character in the prefix
        for char in prefix:
            # If character not found in current children, prefix doesn't exist
            if char not in current.children:
                return False
            # Move to the next node
            current = current.children[char]
        
        # If we've traversed the entire prefix, it exists in the trie
        return True