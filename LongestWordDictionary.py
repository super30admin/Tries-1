# I sort the words , so lexicographically I need not to visit the last word
# I put them in a set , check the set such s[l-1] the word with previous char is there
# this is kind of similar to dictionary that points to tree node
# time complexity 0(nlogn) because of sorting  //because we have to visit all words// , 0(1) to check and insert into set
# space complexity 0(n) approx because we insert n elements into set 

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()

        # so we can sort for lexicographically smaller words

        # this creates a set of unique words
        builtWords = set ()

        res = "" 

        for s in words :
            if (len(s) == 1 or s[:len(s)-1] in builtWords) :
                if(len(s) > len(res)) :
                    res = s 
                builtWords.add(s)

        return res 