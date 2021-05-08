# Store all the dictionary words into a Trie
# For every word in sentence, get the prefix of that word from trie if it exists
# Return the motified string
# Time Complexity O(p*m), to find the dictionary word of size m for all the p words in the sentence
# Space Complexity is O(mn) to form Trie from dictionary words, where p is the number of words in the sentence, n is the # of words in dictionary, m is the average word length
class TrieNode(object):
    def __init__(self):
        self.head = {}
    def insert(self,word):
        curr = self.head
        for c in word:
            if c not in curr:
                curr[c] = {}
            curr = curr[c]
        curr['*'] = word
    def getPrefix(self,word):
        curr = self.head
        for c in word:
            if c not in curr:
                break
            if '*' in curr:
                return curr['*']
            curr = curr[c]
        if('*' in curr):
            return curr['*']
        return word
    
class Solution(object):
    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """
        sentence = sentence.split(" ")
        trie = TrieNode()
        for word in dictionary:
            trie.insert(word)
        for i in range(len(sentence)):
            sentence[i] = trie.getPrefix(sentence[i])
        return ' '.join(sentence)