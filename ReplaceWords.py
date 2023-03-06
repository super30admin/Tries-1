"""
Rasika Sasturkar
Time Complexity: O(n*k + m*k), where a sentence contains n words of avg. length k
                and a dictionary contains m words of avg. length k.
Space Complexity: O(mk+n)
"""


class TrieNode:
    """
    Constructing a Trie Node
    """

    def __init__(self):
        self.is_end = False
        self.children = [None for _ in range(26)]


class Solution:
    def __init__(self):
        self.root = None

    def insert(self, word: str) -> None:
        """
        Inserting into a Trie
        """
        curr = self.root
        for i in range(len(word)):
            char = word[i]
            if curr.children[ord(char) - ord('a')] is None:
                curr.children[ord(char) - ord('a')] = TrieNode()
            curr = curr.children[ord(char) - ord('a')]
        curr.is_end = True

    def replaceWords(self, dictionary, sentence: str) -> str:
        """
        We create a Trie of the given dictionary and start checking word by
        word in the sentence. For every child in the root of the word, if
        is_end is True, we replace else continue. If another letter present
        at that character, we do not replace the word at all.
        :return:
        """
        self.root = TrieNode()
        for string in dictionary:
            self.insert(string)

        result = ""
        str_arr = sentence.split()

        for k in range(len(str_arr)):
            if k != 0:
                result += " "
            word = str_arr[k]
            replacement = ""
            curr = self.root
            for i in range(len(word)):
                char = word[i]
                if curr.children[ord(char) - ord('a')] is None or curr.is_end:
                    break
                replacement += char
                curr = curr.children[ord(char) - ord('a')]
            if curr.is_end:
                result += replacement
            else:
                result += word

        return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    s = Solution()
    print(s.replaceWords(dictionary=["cat", "bat", "rat"],
                         sentence="the cattle was rattled by the battery"))  # prints "the cat was rat by the bat"
    print(s.replaceWords(dictionary=["a", "b", "c"], sentence="aadsfasf absbs bbab cadsfafs"))  # prints "a a b c"


if __name__ == "__main__":
    main()
