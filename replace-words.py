# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        sentence = sentence.split()

        operated = []

        for word in dictionary:

            k = len(word)

            for i in range(len(sentence)):

                if sentence[i][:k] == word:

                    if i not in operated:
                        sentence[i] = word
                        operated.append(i)

                    else:
                        if len(word) < len(sentence[i]):
                            sentence[i] = word

        # space because the final output is with the spaces in between words
        return " ".join(sentence)
