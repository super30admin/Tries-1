# Problem3: Replace Words (https://leetcode.com/problems/replace-words/)
# Time Complexity: O(M * L + N * L) where M is the number of words in dictionary, N is number of words in sentence and L is the average word length
# We spend O(L) time inserting each dictionary word into the Trie, done M times and O(L) time checking each sentence word against the Trie, done N times
# Space Complexity: O(M * L + N * L), The Trie can store up to M * L nodes in the worst case if dictionary words share no common prefixes. The split array and result list together hold roughly N * L characters worth of words
# Approach:
# First we build a Trie using all the words from the dictionary
# Then we go word by word in the sentence and check for the shortest prefix match in the Trie
# If a match is found, we use that root word, if not, we keep the original word

class Solution:
    class TrieNode:
        def __init__(self):
            # each node has 26 slots, one for each lowercase letter a to z
            self.children = [None] * 26
            # marks whether a complete dictionary word ends exactly at this node
            self.isEnd = False

    def __init__(self):
        # root node does not represent any letter, it is just the starting point for every word
        self.root = self.TrieNode()
    
    def insert(self, word):
        # pointer that starts at root and moves down the Trie as we process each letter
        current = self.root
        for char in word:
            # convert the letter into its position in the alphabet, this gives us the index into children
            index = ord(char) - ord('a')
            # if no node exists yet for this letter at this position, create one
            if current.children[index] is None:
                current.children[index] = self.TrieNode()
            # move pointer one level deeper to the node representing this letter
            current = current.children[index]
        # after processing every letter, mark the final node as the end of a real dictionary word
        current.isEnd = True
    
    def getShortestVersion(self, word):
        # start a fresh walk from the top of the Trie for this sentence word
        current = self.root
        # list used to build up the matched prefix letter by letter
        list = []
        for char in word:
            # convert letter into index the same way as in insert
            index = ord(char) - ord('a')
            # stop if there is no path for the next letter in the Trie
            # also stop if we already reached the end of a real dictionary word at the current position
            if not current.children[index] or current.isEnd:
                break
            # add this letter to our building prefix since we did not break
            list.append(char)
            # move pointer deeper into the Trie
            current = current.children[index]
        # after the loop, check if we actually stopped on a valid complete root
        if current.isEnd:
            # join the collected letters and return the shortened root
            return ''.join(list)
        # if we never reached a real root, return the original word unchanged
        return word

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # insert every root word from the dictionary into the Trie first
        for word in dictionary:
            self.insert(word)
        
        # break the sentence into individual words using space as separator
        splitArray = sentence.split(" ")
        # will collect the replacement for each word
        result = []

        for i in range(len(splitArray)):
            # i is just a position number, word is the actual value we care about
            word = splitArray[i]
            # check the Trie for the shortest matching root and add the result
            result.append(self.getShortestVersion(word))
        # glue all the words back together with spaces to form the final sentence
        return " ".join(result)

        