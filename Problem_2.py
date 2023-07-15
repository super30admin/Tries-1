# Time Complexity: O(summation(n))
# Space Complexity: O(summation(n))
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        map = {}
        for word in words:
            map[word] = 1
        result = ""
        words.sort()
        for word in words:
            flag = True
            for i in range(len(word) - 1):
                if word[:i+1] not in map:
                    flag = False
                    break
            if flag == True:
                if (len(result) < len(word)):
                    result = word
        return result