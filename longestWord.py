class TrieNode:
    def __init__(self):
        self.children=dict()
        self.isEnd=False

class Solution:
    def longestWord(self, words: List[str]) -> str:
        words.sort()
        root=curr=TrieNode()
        longest=""
        
        print(words)
        for word in words:
            curr_str=""
            curr=root
            for char in range(len(word)):
                if word[char] not in curr.children:
                    curr.children[word[char]]=TrieNode()
                curr=curr.children[word[char]]

                if char==len(word)-1:
                    curr.isEnd=True

                curr_str+=word[char]
                if char!=len(word)-1 and not curr.isEnd:
                    break
                if len(curr_str)>len(longest):
                        longest=curr_str
            print(curr_str)

        return longest
        



