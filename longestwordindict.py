# Time Complexity : O(n)
#Space Complexity : O(m)
# #// Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :NO
class Solution:
    def longestWord(self, words: List[str]) -> str:
        #sort the words, then keep in the set and check for nextWord[:-1] in the set
        words.sort()
        st, res = set(), "" #res == result
        st.add("")
        for word in words:
            if word[:-1] in st:
                if len(word) > len(res):
                    res = word
                st.add(word)
        
        return res