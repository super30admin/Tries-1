# Time Complexity : O(nl) where n is the number of words and l is the average length of the words
# Space Complexity : O(nl)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class TrieNode (object):
    def __init__(self):
        self.isword = False
        self.children = [None]*26


class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for i in word:
            temp = ord(i)-ord('a')
            if curr.children[temp] == None:
                curr.children[temp] = TrieNode()
            curr = curr.children[temp]
        curr.isword = True


class Solution(object):
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        if dict == None:
            return sentence

        t = Trie()
        for i in dict:
            t.insert(i)
        words = sentence.split()

        result = ""

        # for each word in the sentence
        for i in range(len(words)):
            if i > 0:
                result += " "

            word = words[i]
            # replacement string
            temp = ""
            curr = t.root
            # for each letter in the word
            for i in range(len(word)):
                index = ord(word[i])-ord('a')
                if curr.children[index] == None or curr.isword:
                    break
                temp += word[i]
                curr = curr.children[index]

            if curr.isword:
                result += temp
            else:
                result += word

        return result
