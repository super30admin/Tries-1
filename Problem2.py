class Solution:
    def longestWord(self, words: List[str]) -> str:
    	# Time Complexity : O(nlogn) where n is the size of the words list
    	# Accepted on leetcode
    	# I was getting a time limit exceeded initially and later tried by sortint the list and it worked fine
        words = sorted(words, key = lambda x:len(x))
        wordset, longest_word = set([""]), ""
        for word in words:
            if word[:-1] in wordset:
                wordset.add(word)
                if len(word) > len(longest_word):
                    longest_word = word
        return longest_word
        #return max(wordset, key = lambda x:len(x))