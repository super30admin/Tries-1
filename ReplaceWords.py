#All TC passed on leetcode
    

class TrieNode:

    def __init__(self):
        self.isEnd = False
        self.children = [None]*26

class Trie:

    def __init__(self):
        self.root = TrieNode()


    def insert(self, word: str):
        cur = self.root
        for i in range(len(word)):
            if not cur.children[ord(word[i])-ord('a')]:
                cur.children[ord(word[i])-ord('a')] = TrieNode()
            cur =  cur.children[ord(word[i])-ord('a')]

        cur.isEnd = True


    def search(self, word: str):
        cur = self.root
        ans = ""
        for i in range(len(word)):
            if not cur.children[ord(word[i])-ord('a')]:
                return ""
            else:
                ans = ans + word[i]
                cur = cur.children[ord(word[i])-ord('a')]
                if cur.isEnd:
                    return ans
        return ""
            
            

class Solution:
    #Time complexity - O(m*l) + O(n*k) where  where m is no. of words in dictionary and l is average length of each word. 
    # n is the no. of words in sentence and k is average length of each word. (m*l) for inserting into Trie and 
    # (n*k) for searching and replacing
    #Space complexity - O(m*l)+O(p) where m is no. of words in dictionary and l is average length of each word, 
    # p is length of prefix word used to replace word in sentence
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:

        wordTrie = Trie()

        #inserting dictionary words into Trie
        for w in dictionary:
            wordTrie.insert(w)

        #split the sentence by spaces
        s_array = sentence.split()

        #iterate and call search function on each word
        for i in range(len(s_array)):
            prefix = wordTrie.search(s_array[i])
            if prefix!="":
                s_array[i] = prefix

        return " ".join(s_array)

        






