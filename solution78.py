#Time Complexity:O(mn+kp)
#Space COmploexity:O(mn)

class TrieNode:
    def __init__(self):
        self.children=[None]*26 					#This class initoializes the structure of a trie node 
        self.isEnd=False

class Solution:        
    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root												#Starting from root every character of the word is checked for in the trie, if it does not exist the character
        for i in range(len(word)):										#is added onto the trie and the last node of each word has isEnd set to true

            c=word[i]
            if curr.children[ord(c) - ord("a")] == None:
                curr.children[ord(c) - ord("a")] = TrieNode()
            curr = curr.children[ord(c) - ord("a")]
        curr.isEnd = True
        
        
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        if len(dictionary)==0:											#if the dictionary is empty the sentence is return
            return sentence
        self.root=TrieNode()											#an root node is created to build a trie on
        for word in dictionary: 										#every word in the dictionary is added onto the trie
            self.insert(word)

        spArr=sentence.split() 											#the senetence is split into words 
        result='' 														#result sentence is declared
        for s in spArr:													#for every word of the sentence
            word=list(s)												#a list of characters of words is obtained
            curr=self.root
            replace='' 													#a replacement string is declared
            for c in word: 												#for every character in the word
                if not curr.children[ord(c)-ord('a')] or curr.isEnd:  	#if the character is not in trie or it is the end of word in trie we break
                    break
                replace+=c 												#else we add the character to replacement string and move to the next character of trie
                curr=curr.children[ord(c)-ord('a')]
            if curr.isEnd: 												#if the end is reached, we add the replacement string to the result else we return the old word
                result+=replace+' '
            else:
                result+=s+' '
        return result[:-1]