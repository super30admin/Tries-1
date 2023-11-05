class Solution:
    def longestWord(self, words: List[str]) -> str:
        """
        This is a Brute force solution. 
        Time Complexity: Sorting time + Loop through each word. 
            Sorting time complexity: O(n log n)
            Loop through each word: 
               O(m.n) where n is the number of words, and m is the length of the largest string

        Space complexity: O(n) where n is the length of the words list. 
        This is used for the sorted, lexical list
        """
        wordset = set(words) # We do this for an O(1) lookup since this is a Set
        #print(f"wordset={wordset}")

        """
        This line sorts the list of words first by the length of the words in descending order 
        (because of the negative sign) and second, by alphabetical order. 
        This means the longest words will come first, and if two words are of the same length, 
        the one that is lexicographically smaller will come first.
        """
        words_sorted = sorted(wordset, key=lambda x: (-len(x), x)) # this is a list
        #print(f"words_sorted={words_sorted}")
        
        for word in words_sorted:
            if all(word[:k] in words_sorted for k in range(1, len(word))):
                return word

        return ""
        

        
