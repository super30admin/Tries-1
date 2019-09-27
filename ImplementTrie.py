# Insert
#   Time Complexity: O(n)
#   Space Complexity: O(n^2)
# Search
#   Time Complexity: O(n)
#   Space Complexity: O(1)
# Prefix
#   Time Complexity: O(n)
#   Space Complexity: O(1)
# Algorithm:
# Create a trie (a list of size 26 have pointer to other 26 size lists). Mark True ar last array when string ends while inserting.
# For search follow the array and the pointers as per the character in the string and on the last character check if the character position of the list is True
# For search follow the array and the pointers as per the character in the string and on the last character check if the position of the list has another list

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = []
        for i in range(26):
            self.trie.append([False, list()])
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current_list = self.trie
        for idx, char in enumerate(word):
            if len(current_list[ord(char)-ord('a')][1]) == 0:
                temp_list = []
                for i in range(26):
                    temp_list.append([False, list()])
                current_list[ord(char)-ord('a')][1] = temp_list   
            
            if len(word) - 1 == idx:
                current_list[ord(char) - ord('a')][0] = True
            else:
                current_list = current_list[ord(char)-ord('a')][1]

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current_list = self.trie
        for idx, char in enumerate(word):
            if len(current_list[ord(char)-ord('a')][1]) == 0:
                return False

            if idx == len(word) - 1:
                if current_list[ord(char)-ord('a')][0]:
                    return True
            current_list = current_list[ord(char)-ord('a')][1]
        return False
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current_list = self.trie
        for idx, char in enumerate(prefix):
            if len(current_list[ord(char)-ord('a')][1]) == 0:
                return False
            current_list = current_list[ord(char)-ord('a')][1]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)