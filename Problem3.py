# Time complexity : O(n*l + m*l) --> n - number of words, m - words in sentence ,l - length of words
# Space complexity : O(max(n,m)*l)
# Leetcode : Solved and submitted

# definind Trie Node
class TrieNode(object):
    def __init__(self):
        self.isEnd = False
        self.children = [None for _ in range(26)]
    
class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        # start with the root node
        self.root = TrieNode()
        res = []
        # insert all the words from the dictionary into the Trie
        for words in dictionary:
            self.insert(words)
        
        # splitting the sentence using spaces
        stmt = sentence.split(' ')
        # traversing over each word
        for each_word in stmt:
            wording = each_word
            curr = self.root
            st = ''
            # going over each word and checking with Trie
            for j in range(len(wording)):
                ch = wording[j]
                # if the char is not present or we found an end of the word, we break
                if curr.children[ord(ch) - ord('a')] == None or curr.isEnd:
                    break
                # keep adding the ch to the replacement string
                st += ch
                # moving the curr in Trie with the char in the word
                curr = curr.children[ord(ch) - ord('a')]
            # if we have reached to the end of the word, which was in dictionary, that means
            # the word can be replaced
            if curr.isEnd:
                res.append(st)
            else:
                # else we append the same word to res
                res.append(wording)
        # making a string using list of strings separated by spaces ' '
        return ' '.join(res)
                
    # insert function to insert the word into the trie data structure
    def insert(self, word):
        # start with the root
        curr = self.root
        
        # traverse over every letter of the word
        for i in range(len(word)):
            ch = word[i]
            # if char is not present, then place a trie node there and move to that node
            if curr.children[ord(ch)-ord('a')] == None:
                curr.children[ord(ch)-ord('a')] = TrieNode()
            curr = curr.children[ord(ch)-ord('a')]
        # at the end, when the word is complete, we make the isEnd flag as True marking end of current word
        curr.isEnd = True
