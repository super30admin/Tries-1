''' 
Time Complexity:  
if X is total number of characters across all words 
and L is the max length of building a string via concatenation 
Then time complexity is O(X*L) 

Space Complexity: 
O(X) the space used by the trie is proportional to the number of characters in the inserted words
'''

class Solution:
    def longestWord(self, words: List[str]) -> str:
        self.trie = {}
        self.max_length = float("-inf")
        self.max_length_word = ""

        for word in words:
            temp = self.trie
            for char in word:
                if char not in temp:
                    temp[char] = {}
                temp = temp[char]
            temp["end"] = True

        def traverse(word, length, curr_char, trie):
            if curr_char in trie:
                if "end" in trie[curr_char]:
                    if length > self.max_length or (
                        length == self.max_length and word < self.max_length_word
                    ):
                        self.max_length = length
                        self.max_length_word = word
                    for next_char in trie[curr_char]:
                        if next_char != "end":
                            temp_word = word + next_char
                            traverse(temp_word, length + 1, next_char, trie[curr_char])
            else:
                return

        for char in self.trie:
            traverse(char, 1, char, self.trie)

        return self.max_length_word
