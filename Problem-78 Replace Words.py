# 648. Replace Words
# https://leetcode.com/problems/replace-words/

# Logic: Insert all the word of the given dictionary in the trie. 
# We then take the sentence, split it on spaces and for each word 
# we try to search the letter in the trie. If it exist then we go 
# down the branch, if not then the entire letter is added to the 
# answer. Along the way if we come across any node where isEnd is 
# true, we add the string so far and move to the next word in the sentence.

# Time Complexiety: O(n*k) [n is the number of word in the dictionary and k is length of words in the dictionary]
# Space Complexiety: O(n*k)

class trieNode:
    def __init__(self):
        self.isEnd = False
        self.child = dict()

class Solution:
    def __init__(self):
        self.root = trieNode()
        
    # To insert the words in the dictionary in the trie
    def insert(self, word):
        cur = self.root
        
        for i in word:
            if cur.child.get(i) == None:
                cur.child[i] = trieNode()
            cur = cur.child[i]
        cur.isEnd = True
    
    def replaceWords(self, dictionary, sentence) -> str:
        for i in dictionary:
            self.insert(i)
        
        sentence = sentence.split(" ")

        for idx, i in enumerate(sentence):
            cur = self.root
            temp = ""
            for j in i:
                temp += j
                if cur.child.get(j) == None: # or cur.isEnd == True:
                    sentence[idx] = i
                    break
                elif cur.child[j].isEnd == True:
                    sentence[idx] = temp
                    break
                else:
                    cur = cur.child[j]
        
        return " ".join(sentence)

obj = Solution()
print(obj.replaceWords(["cat","bat","rat"],"the cattle was rattled by the battery"))