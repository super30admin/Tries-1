'''
Time complexity:  
 forming trie:  O(N * M) Where N is the number of words in the sentence and M is the maximum length of a word in the dictionary. 
 searching and replacing: O(S) Where S is the total number of characters in the sentence. 

 Space Complexity: 
  O(N * M) Where N is the number of words in the sentence and M is the maximum length of a word in the dictionary.

'''

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        trie = {}

        for word in dictionary:
            temp = trie
            for char in word:
                if char not in temp:
                    temp[char] = {}
                temp = temp[char]
            temp["end"] = True

        sentence_words = sentence.split(" ")
        output = []
        print(trie)

        for word in sentence_words:
            temp = trie
            prefix = ""
            flag = False
            for char in word:
                if char in temp:
                    prefix += char
                    temp = temp[char]
                    if "end" in temp:
                        flag = True
                        break
                else:
                    break
            if flag:
                output.append(prefix)
            else:
                output.append(word)

        return " ".join(output)
