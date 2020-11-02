#Time Complexity: O(sigma wi2)
#Space Complexity: O(sigma wi2)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def longestWord(self, words: List[str]) -> str:
        wordSet = set(words)
        returnList = []
        for word in words:
            if all(word[:k] in wordSet for k in range(1,len(word))):
                    returnList.append(word)

        returnList.sort() # sorts normally by alphabetical order
        returnList.sort(key=len, reverse=True) # sorts by descending length

        return returnList[0]