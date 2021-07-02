# Time Complexity : O(n*k)
# Space Complexity : O(n*k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#construct trie and check if substring is a word in dictionary
class TrieNode:
    def __init__(self):
        self.isEnd = False
        self.Childs = [None]*26
class Solution:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        
        for i in range(len(word)):
            if node.Childs[ord(word[i]) - 97] == None:
                node.Childs[ord(word[i]) - 97] = TrieNode()
            node = node.Childs[ord(word[i]) - 97]
        node.isEnd = True
        return;
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        for i in range(len(dictionary)):
            self.insert(dictionary[i])
        temp = sentence.split(" ")
        words = []
        for i in temp:
            if i != " ":
                words.append(i)
        
        for i in range(len(words)):
            word = words[i]
            node = self.root
            exists = True
            newWord = ""
            for j in range(len(word)):
                char = word[j]
                if node.isEnd:
                    exists = True
                    break
                if node.Childs[ord(char)-97] == None:
                    exists = False
                    break
                newWord += char
                node = node.Childs[ord(char)-97]
            if node.isEnd or exists:
                words[i] = newWord
        return " ".join(words)