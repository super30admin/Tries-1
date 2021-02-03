# Created by Aashish Adhikari at 12:48 PM 2/3/2021

'''
Time Complexity:
insert(): If n words with average length k, O(n.k) ~ O(N) to create the dictionary.
find_longest(): Say L is the longest word in the dictionary --> height of the tree == L.
                Since each node has an array of size 26 and we run a for loop at each node,
                O(26 ^ L)

Space Complexity:
insert(): Each node has 26 children. Each node represents a letter and also contains an array of size 26.
          O(26 . N) where N = n. k = no of letters in all the words combined
          ~ O(N)
find_longest(): O(1)

'''

class Trie_Node(object):
    def __init__(self, string):
        self.children = [None for idx in range(26)]
        self.hasWord = False
        self.string = string

class Trie(object):

    def __init__(self):
        self.root = Trie_Node("")
        self.longest_string = ""



    def insert(self, word):
        curr = self.root

        for idx in range(len(word)):

            pos = ord(word[idx]) - ord('a')

            if curr.children[pos] is None:

                curr.children[pos] = Trie_Node(string = curr.string + word[idx])
            curr = curr.children[pos]

        curr.hasWord = True

    def find_longest(self, node):


        # base case
        if node.hasWord:
            if len(node.string) >= len(self.longest_string):
                self.longest_string = node.string


        # logic
        for character in range(25, -1, -1):

            if node.children[character] is not None and node.children[character].hasWord:


                self.find_longest(node.children[character])








class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """



        # create a dictionary of all the words in Trie data structure
        prefix_tree = Trie()
        for word in words:
            prefix_tree.insert(word)


        # find the length of the longest word in the dictionary
        prefix_tree.find_longest(prefix_tree.root)

        return prefix_tree.longest_string




