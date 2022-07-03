"""
Approach: Use trie to add all dictionary words and then for each word in sentence try to find that word in the trie in linear time, as soon as you hit a node where there is a complete word, stop the search and append the result
TC O(N) where N is length of the sentence
SC O(N) the size of our Trie
"""
class TrieNode:
    def __init__(self):
        self.children = [None] * 26  # assuming 26 characters only in lower case
        self.is_end = False

    def __str__(self):
        return ' '.join([str(self.is_end), str(self.children)])

class Trie:

    def __init__(self):
        self.root = TrieNode()  # new TrieNode with is_end False and children is list of 26 None values

    def insert(self, word: str) -> None:
        curr = self.root  # start at root
        for char in word: # iterate over word, char-by-char
            idx = ord(char) - ord('a')  # get index for curr char in 0-25 using ascii values
            if curr.children[idx] == None:  # if curr.children[idx] == None, we don't have that char in list
                curr.children[idx] = TrieNode()  # so add that char by using new TrieNode
            curr = curr.children[idx]  # move the curr to next node
        # at the end, when we come out of the loop - whatever the last node is, will be marked as end of the string/word
        curr.is_end = True


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # Create a Trie and result list
        result = []
        trie = Trie()
        # insert all words from dictionary into trie
        for word in dictionary:
            trie.insert(word)
        # split sentence into words using ' ' space separator
        for word in sentence.split(' '):
            curr = trie.root  # for every word start looking at trie from its root
            s = []  # replacement string
            for char in word:  # for each char in word
                idx = ord(char) - ord('a')  # get its index
                if curr.children[idx] is None or curr.is_end == True:  # if its None or curr node is end node - break
                    break
                s += char  # else keep adding char to string
                curr = curr.children[idx] # and advance the curr to its appropriate child
            if curr.is_end:  # append string to result as we found a node with True for is_end, its a complete word
                result.append(''.join(s))
            else: # or original word if replacement wasn't found
                result.append(word)
        return ' '.join(result)
                
        