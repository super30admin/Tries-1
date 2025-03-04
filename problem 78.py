# Replace Words (https://leetcode.com/problems/replace-words/)


# Time Complexity : O((m*n) l ), m = #words in dictionary, #words in sentence, l = ang length of the words
# Space Complexity : O(m * l). for the trie.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : NO


class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False

class Solution:
    def __init__(self):
        self.root = TrieNode()
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        #ld = len(dictionary)
        #curr = self.root

        for word in dictionary:
            curr = self.root
            for i in range(len(word)):
                ch = word[i]
                index = ord(ch) - ord('a')
                if curr.children[index] == None:
                    curr.children[index] = TrieNode()
                curr = curr.children[index]
            curr.isEnd = True
        
        st = sentence.split()
        result = []
        for word in st:
            curr = self.root
            replacement = []
            for i in range(len(word)):
                ch = word[i]
                index = ord(ch) - ord('a')
                if curr.children[index] ==  None or curr.isEnd:
                    break

                replacement.append(ch)
                curr = curr.children[index]
            
            if curr.isEnd:
                result.append("".join(replacement))
            else:
                result.append(word)
        return " ".join(result)
