class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isEnd = False


class Solution:
    def insert(self, word):
        curr = self.root
        for i in range(len(word)):
            ch = word[i]
            if not curr.children[ord(ch) - ord('a')]:
                curr.children[ord(ch) - ord('a')] = TrieNode()
            curr = curr.children[ord(ch) - ord('a')]
        curr.isEnd = True

    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        self.root = TrieNode()

        for word in dictionary:
            self.insert(word)

        result = []
        splitArr = sentence.split(" ")

        for j in range(len(splitArr)):
            if j != 0:
                result.append(" ")
            word = splitArr[j]
            replacement = []
            curr = self.root
            for i in range(len(word)):
                ch = word[i]
                if not curr.children[ord(ch) - ord('a')] or curr.isEnd:
                    break
                replacement.append(ch)

                curr = curr.children[ord(ch) - ord("a")]
            if curr.isEnd:
                result.append(''.join(replacement))
            else:
                result.append(word)

        return "".join(result)


# TC =O(mk) + O(nl).k and l is the avg length of the string ,m is the number of elements in the dictionary and n is
# the number of words in the sentence.
# Space complexity : O(n2^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
