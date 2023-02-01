# Time Complexity :
# O(NL)

# Space Complexity :
# O(26^L) - where L max length of amonng the give words

# Did this code successfully run on Leetcode :
#Yes


#We first add all words in a Trie Tree
# Then we process the entire Trie Tree in a DFS manner. When we are going down each level, we check if a word ends here and keep going until that is true, we keep updating our max lengths(if it was smaller than current len) and when it is not, we return. 
#Everytime we find a new max length, we store that word. Since we are traversing in order of left ot right, they will be lexicographically sorted by default
#Every time we find a word of previous max length, we add it to our list of results 
#In the end, we return results's list first element as that will the lexicographically smallest element

class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.is_end = False

    def insert(self, word: str) -> None:
        if len(word) == 0 :
            return
        curr_node = self
        if self.children[ord(word[0])-ord('a')] == None :
            self.children[ord(word[0])-ord('a')] = Trie()

        self.children[ord(word[0]) - ord('a')].insert(word[1:])   
        if len(word) == 1 :
            self.children[ord(word[0]) - ord('a')].is_end = True

    def search(self, word: str) -> bool:
        curr = self
        for char in word :
            if curr.children[ord(char) - ord('a')] == None :
                return False
            else :
                curr = curr.children[ord(char) - ord('a')]
        return curr.is_end

    def startsWith(self, prefix: str) -> bool:
        curr = self
        for char in prefix :
            if curr.children[ord(char) - ord('a')] == None :
                return False
            else :
                curr = curr.children[ord(char) - ord('a')]
        return True

class Solution:
    def longestWord(self, words: List[str]) -> str:
        curr_trie = Trie()
        self.max_len_words = []
        self.max_len = -1
        for word in words:
            curr_trie.insert(word)

        if curr_trie.is_end == True :
            return ""
        curr_trie.is_end = True
        self.dfs(curr_trie,0,"")
        if len(self.max_len_words) != 0 :
            return self.max_len_words[0]
        else :
            return ""
        
    def dfs(self,trie_node,curr_len,curr_word):
        if trie_node == None :
            return

        if trie_node.is_end == True :
            if curr_len == self.max_len:
                self.max_len_words.append(curr_word)
            if curr_len > self.max_len:
                self.max_len = curr_len
                self.max_len_words =[]
                self.max_len_words.append(curr_word)
        else :
            return
        for i,trie_node_child in enumerate(trie_node.children) :
            self.dfs(trie_node_child,curr_len+1,curr_word + chr(i+ ord('a')) )
