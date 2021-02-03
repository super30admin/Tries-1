# Created by Aashish Adhikari at 10:51 PM 2/2/2021
'''
Time Complexity:
If L is the average length of all the dicitonary words, and there are n such dictionary words,
if k is the average length of the words in the sentence, and there are m such words in the sentence,
To create Trie: O(L.n)
To replace each word in the sentence: O(m.k)
then O(  max(L.n, m.k)  ). Need to consider both because the number of dictionary words and the number of sentence words
are both variables.


Space Complexity:
Prefix tree takes O(L.n).
If k is the average length of the words in the sentence, and there are m such words in the sentence,
then we store all of them after splitting. O(m . k)
O(L.n + m.k)

'''

class Prefix_Tree_Node(object):

    def __init__(self):
        self.children = [None for idx in range(26)]
        self.isEnd = False

class Prefix_Tree(object):

    def __init__(self):
        self.root = Prefix_Tree_Node()

    def add(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        curr = self.root

        for idx in range(len(word)):

            if curr.children[ord(word[idx]) - ord("a")] is not None:
                curr = curr.children[ord(word[idx]) - ord("a")]
            else:
                curr.children[ord(word[idx]) - ord("a")] = Prefix_Tree_Node()
                curr = curr.children[ord(word[idx]) - ord("a")]

        curr.isEnd = True

    def replace(self, word):


        prefix = ""
        curr = self.root

        for idx in range(len(word)):
            if curr.isEnd:
                return prefix

            if curr.children[ord(word[idx]) - ord("a")] is None:

                return word # returning the original word as no prefix was found

            # letter matched
            prefix += word[idx]

            curr = curr.children[ord(word[idx]) - ord("a")]

        # if nothing found till the end, return the original word
        return word





class Solution(object):

    def replaceWords(self, dictionary, sentence):
        """
        :type dictionary: List[str]
        :type sentence: str
        :rtype: str
        """

        prefix_tree = Prefix_Tree()

        # add the dictionary prefixes to the prefix tree first
        for word in dictionary:
            prefix_tree.add(word)

        # check of a prefix exists for each word in the sentence, if it does, replace, else keep the original word
        words = sentence.split()
        sol = ""

        for successor in words:
            sol += prefix_tree.replace(successor)
            sol += " "

        return sol[0:-1]