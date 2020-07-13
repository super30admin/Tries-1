# Time Complexity : Add - O(nl) - n=no. of words, l = avg length of a word
# Space Complexity :O(n) - avf length of a word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class TrieNode():
    def __init__(self):
        self.children = [None]*26
        self.isEnd = False


class Solution:

    def __init__(self):
        self.root = TrieNode()

    def _insert(self, word):
        current = self.root
        for i in word:
            # print (i)
            if current.children[ord(i)-ord('a')] is None:
                current.children[ord(i)-ord('a')] = TrieNode()

            current = current.children[ord(i)-ord('a')]

        current.isEnd = True


    def replaceWords(self, dict: List[str], sentence: str) -> str:

        if not sentence or len(sentence) < 1:
            return sentence

        for root_word in dict:
            self._insert(root_word)

        result = []
        for word in sentence.split(" "):

            current = self.root
            short_word = []
            for letter in word:
                if current.children[ord(letter)-ord('a')]:
                    short_word.append(letter)
                    if current.children[ord(letter)-ord('a')].isEnd == True:
                        break
                    else:
                        current = current.children[ord(letter)-ord('a')]
                else:
                    short_word = word
                    break

            result.append("".join(short_word))            
        return " ".join(result)
