# Solution

# // Time Complexity : Total will be O((n*k)+(m*k))
#                      Insert: O(n*k), k - average length of words in dictionary(I think we are ignoring 26 since it is constant)
#                                      n - number of words in dictionary
#                      search: O(m*k), k - average length of words in sentence
#                                      m - number of words in sentence
# // Space Complexity : O(n*k), where k is the average length of the words, n is number of words in dictionary
# 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is create a Trie dictionary for all the words in dictionary. Now split the sentence on space and for each word check
# if there is a successor(smaller word) that can replace the word in sentence by using search function. If search provides data
# replace the word of sentence with the obtained result

def replaceWords(dictionary, sentence):
    class Trie:
        class trieNode:
            def __init__(self):
                self.children = [None for _ in range(26)]
                self.isEnd = False
        def __init__(self):
            self.root = Trie.trieNode()
        def insert(self,word):
            cur = self.root
            for c in word:
                if cur.children[ord(c)-ord("a")] == None:
                    cur.children[ord(c)-ord("a")] = Trie.trieNode()
                
                cur = cur.children[ord(c)-ord("a")]
            cur.isEnd = True
        def search(self,word):
            result = ""
            cur = self.root
            for c in word:
                if cur.children[ord(c)-ord("a")] == None:
                    return ""
                cur = cur.children[ord(c)-ord("a")]
                result += c
                if cur.isEnd == True:
                    return result
            return ""

    dictTrie = Trie()
    for word in dictionary:
        dictTrie.insert(word)
    
    sentenceList = sentence.split()
    for i in range(len(sentenceList)):
        result = dictTrie.search(sentenceList[i])
        if result != "":
            sentenceList[i] = result
    
    return " ".join(sentenceList)

if __name__ == "__main__":
    dictionary = ["cat","bat","rat"]
    sentence = "the cattle was rattled by the battery"
    print(replaceWords(dictionary, sentence))