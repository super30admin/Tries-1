# Time Complexity :
# O((N+n)L) where N is the number of words in the sentence and n is the number of roots and L is maximum length of word from either list

# Space Complexity :
# O(26^L) - L is the max length of the root words

# Did this code successfully run on Leetcode :
#Yes

#We first add all the root words to a Trie tree. Then for each word in the sentence, we start looking for the word in the Trie tree.
#If we reach the end of the root word when going through a word from the sentence, then that is what will be added to the new sentence, otherwise the original word from the sentence will be added to the new setence
#finally, new sentence is returned

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
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        obj = Trie()
        for word in dictionary:
            obj.insert(word)

        new_sentence = ""
        sentence = sentence.split(" ")
        for word in sentence:
            flag = False
            curr_node = obj
            num_chars_to_add = 0
            for i,character in enumerate(word):
                if curr_node.children[ord(character)-ord('a')] != None and curr_node.is_end == False:
                    num_chars_to_add += 1
                    curr_node = curr_node.children[ord(character)-ord('a')]
                else :
                    break
            if curr_node.is_end == True :
                new_sentence += word[:num_chars_to_add]
            else :
                new_sentence += word
            new_sentence += " "

        return new_sentence[:-1]
            


