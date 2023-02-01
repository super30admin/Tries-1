# Time Complexity :
# Insert - O(L) for each word
# Search - (O(L)) for each word
# Starts With (O(L)) for each word

# Space Complexity :
# O(26^L) - where L is the max word length

# Did this code successfully run on Leetcode :
#Yes

#For insert, we start adding character by character. We check if the character exists in the current node's children, if it does, then we move to that child and process the next character the same way until then end. If it doesn't exist, we create a trie node at the correct location for the given character and go on until the end. At the end of the word, for the last character, we add is_end = True
#Search : We start looking character by character. If a certain character doensn't exist, we return False. If we reach the end of the word, we return if the current letter is the end i nthe tree or not
#Starts with: We search character by character. If we find all characters level by level, then we return true

class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.is_end = False

    def insert(self, word: str) -> None:
        if len(word) == 0 :
            return
        curr_node = self
        if self.children[ord(word[0])-ord('a')] == None :
            self.children[ord(word[0])-ord('a')] = Trie()

        self.children[ord(word[0]) - ord('a')].insert(word[1:])   
        if len(word) == 1 :
            self.children[ord(word[0]) - ord('a')].is_end = True

    def search(self, word: str) -> bool:
        curr = self
        for char in word :
            if curr.children[ord(char) - ord('a')] == None :
                return False
            else :
                curr = curr.children[ord(char) - ord('a')]
        return curr.is_end

    def startsWith(self, prefix: str) -> bool:
        curr = self
        for char in prefix :
            if curr.children[ord(char) - ord('a')] == None :
                return False
            else :
                curr = curr.children[ord(char) - ord('a')]
        return True

