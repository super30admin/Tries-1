"""
## Problem3
Replace Words (https://leetcode.com/problems/replace-words/)


In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"


Note:

The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000


"""
class TrieNode:
    def __init__(self):
        self.isWord=False
        self.str = ''
        self.children=[None]*26

def replaceWord(dict, senetence):
    root = TrieNode()
     #create TRIE
    self.createTrie(dict, root)

    split_sentence = senetence.split(" ")
    ret_val=""
    for s in split_sentence:
        #call str function
        ret_val += self.new_str(s,root) + " "

    return ret_val[:len(ret_val)-1]  #to remove extra space in endlab

def new_str(Self, word ,root):
    node = root
    for char in word:
        if node.isWord==True:
            return node.str
        if node.children[ord(char) - ord('a') ]==None:
            break
        else:
            node=node.children[ord(char) - ord('a') ]
    return word




def createTrie(self,dict, root):
    for word in dict:
        node = root
        for char in word:
            if node.children[ord(char) - ord('a') ] ==None:
                node.children[ord(char) - ord('a')] = TrieNode()

            node = node.children[ord(char) - ord('a')]

        node.isWord = True
        node.str= word

