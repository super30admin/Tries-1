class Solution:
    def longestWord(self,words):
        words.sort()
        valid_words=set([""])
        longest=""

        for word in words:
            if word[:-1] in valid_words:
                valid_words.add(word)
                if len(word)>len(longest):
                    longest=word
        
        return longest
    
sol=Solution()
print(sol.longestWord(["w","wo","wor","worl","world"]))
print(sol.longestWord(["a","banana","app","appl","ap","apply","apple"])) 
