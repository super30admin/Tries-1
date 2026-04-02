# Time: O(N * L) + (M * L) => O(N * L) for bulding the tree N is the number of words in the sentence and L is the length of the longest word in the dictionary
# Space: O(N * L + S) => N is the number of words in the sentence and L is the length of the longest word in the dictionary. The trie space complexity. S is the space complexity of the result string array that we need.

# Question => Given a dictionary consisting of words and a sentence separated by spaces, replace all the words in the sentence with the shortest word from the dictionary. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

# First we create a TrieNode class which will have an array of size 26 to store the children and a boolean variable to know where a particular word ends.
# then we will loop throught the wrods in the dictionary and add them to the Trie. 
# After that we go through each word in the sentence and and whenever we see that isEnd is true or we have a null child node we break the loop
# Then on the current node if isEnd is True then we add the joined prefix to the result else we add the current word to the result.
# and then at the end we will join the res array and return it.

class Solution:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.is_end = False
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = self.TrieNode()
        for word in dictionary:
            curr = self.root
            for char in word:
                idx = ord(char) - ord('a')
                if curr.children[idx] == None:
                    curr.children[idx] = self.TrieNode()
                curr = curr.children[idx]
            curr.is_end = True


        res = []
        for word in sentence.split():
            curr = self.root
            prefix = []
            for char in word:
                idx = ord(char) - ord('a')
                if not curr.children[idx] or curr.is_end: break
                prefix.append(char)
                curr = curr.children[idx]
            if curr.is_end: res.append(''.join(prefix))
            else: res.append(word)
        return ' '.join(res)