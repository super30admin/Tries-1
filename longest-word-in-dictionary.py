# Time Complexity: O(n*m^2) where n is the number of words and m is the average length of the words
# Space Complexity: O(n*m^2) where n is the number of words and m is the average length of the words
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        res=""
        setw=set(words)
        ans=True

        for w in words:
            ans=True
            if len(w)<len(res):
                continue
            if len(w)==len(res) and w>res:
                continue
            for i in range(1,len(w)):
                if w[:i] not in setw:
                    ans=False
                    break
            if ans:
                res=w
        
        return res