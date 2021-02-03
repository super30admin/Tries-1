# Created by Aashish Adhikari at 12:31 PM 2/3/2021

'''
Time Complexity:
If there are n words and each word has an average length of k, then
nested for loops take O(n.k) Within each inner for loop, we compare words, O(k)

Hence O(n.k^2)

Space Complexity:
I think it should be O(n . k) since the slicing is done for each of n words. But the solution says O(n .k ^2). Please guide.
'''


class Solution(object):

    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """

        hs = set()
        longest_len = 0

        for word in words:

            hs.add(word)

        sol = ""

        for word in hs:


            if len(word) == 1:

                if sol == "":
                    sol = word
                else:
                    if len(sol) == 1:
                        sol = min(sol, word)


            else:
                for idx in range(1,len(word)):

                    if word[0:idx] in words:

                        # check if the last letter reached:
                        if idx == len(word)-1:
                            if sol == "":
                                sol = word
                            else:
                                if len(word) == len(sol):
                                    sol = min(sol, word)
                                else:
                                    if len(word) > len(sol):
                                        sol = word


                    else:
                        break
        return sol




