# Longest word in dictionary
# // Time Complexity :  O(N log n) 
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
#not sure if its the most optimal solution
def longestWord( words):
        words = sorted(words)                               #sort the words
        res = set()
        longestword=""
        for i, w in enumerate(words):                       
            if len(w) == 1 or w[:-1] in res:                #if everything but the last letter is already in the set, you know its being built one character at a time, then you add to the set
                res.add(w)
                if(len(w) >len(longestword)):               #is the current word's length is bigger than the longest word, then set this to the longest word
                    longestword = w
        
        return longestword