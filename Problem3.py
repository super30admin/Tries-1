#In my solution, I tackle the problem by first splitting the input sentence into individual words. For each word, I build prefixes one character at a time and check if these prefixes exist in the dictionary. If a prefix matches, I use it to replace the original word; otherwise, I keep the original word. I then compile the modified words into a new sentence and return it. The time complexity of my approach is O(N * M), where N is the number of words in the sentence and M is the length of the longest word, because of the nested loops used to check each prefix. The space complexity is O(N) due to storing the processed words and the result string.

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        l=sentence.split(" ")
        ans=""
        k=[]
        for i in range (0,len(l)):
            flag=0
            word=l[i]
            string=""
            for j in range (0,len(word)):
                string=string+word[j]
                if string in dictionary:
                    k.append(string)
                    flag=1
                    break
            if flag==0:
                k.append(word)
        for i in range(0,len(k)-1):
            ans=ans+k[i]+" "
        ans=ans+k[len(k)-1]
        return ans